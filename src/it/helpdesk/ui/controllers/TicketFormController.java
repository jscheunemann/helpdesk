package it.helpdesk.ui.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import it.helpdesk.datasources.hibernate.HibernateUtil;
import it.helpdesk.datasources.hibernate.datasources.LogEntryDatasource;
import it.helpdesk.datasources.hibernate.datasources.TicketDatasource;
import it.helpdesk.datasources.hibernate.models.Customer;
import it.helpdesk.datasources.hibernate.models.LogEntry;
import it.helpdesk.datasources.hibernate.models.Ticket;
import it.helpdesk.main.ApplicationState;
import it.helpdesk.ui.interfaces.IDatasourceConfiguration;
import it.helpdesk.ui.interfaces.ITicketFormController;
import it.helpdesk.ui.interfaces.ITicketFormView;
import it.helpdesk.ui.interfaces.IViewConfiguration;
import it.helpdesk.ui.interfaces.models.ICustomer;
import it.helpdesk.ui.interfaces.models.ILogEntry;
import it.helpdesk.ui.interfaces.models.ITechnician;
import it.helpdesk.ui.interfaces.models.ITicket;
import it.helpdesk.ui.interfaces.models.datasources.ILogEntryDatasource;
import it.helpdesk.ui.interfaces.models.datasources.ITicketDatasource;

public class TicketFormController implements ITicketFormController {
	/**
	 * Contains an IViewConfiguration object.
	 */
	private IViewConfiguration viewConfiguration;

	/**
	 * Contains an IDatasourceConfiguration object.
	 */
	private IDatasourceConfiguration datasourceConfiguration;

	/**
	 * Contains an ITechnicianDatasource object.
	 */
	private ITicketFormView view;

	/**
	 * Contains an ITechnicianDatasource object.
	 */
	private ITicketDatasource datasource;

	/**
	 * Variable for ticket adding/editing
	 */
	private ITicket ticket;

	/**
	 * Constructor for ticket form controller
	 * 
	 * @param the view configuration class
	 * @param the datasource configuration class
	 */

	public TicketFormController(IViewConfiguration viewConfiguration, IDatasourceConfiguration datasourceConfiguration) {
		this.viewConfiguration = viewConfiguration;
		this.datasourceConfiguration = datasourceConfiguration;
	}

	@Override
	public void openForm() {
		if (this.view == null) {
			this.view = viewConfiguration.getTicketFormView();
			this.view.setController(this);
		}

		if (this.datasource == null) {
			this.datasource = datasourceConfiguration.getTicketDatasource();
		}
		

		List<String> statuses = new ArrayList<String>();
		statuses.add("New");
		statuses.add("In Progress");
		statuses.add("Wait For Process");
		statuses.add("Withdrawn");
		statuses.add("Complete");
		statuses.add("Delete");
		
		this.view.setStatuses(statuses);
		
		List<String> priorities = new ArrayList<String>();
		priorities.add("Low");
		priorities.add("Medium");
		priorities.add("High");
		priorities.add("Urgent");

		this.view.setPriorities(priorities);
		
		List<String> serviceCategories = new ArrayList<String>();
		serviceCategories.add("Access Issue");
		serviceCategories.add("Hardware");
		serviceCategories.add("Software");
		serviceCategories.add("Database");
		serviceCategories.add("Software Defect");
		serviceCategories.add("Inquiry");

		this.view.setServiceCategories(serviceCategories);

		if (ticket != null) {
			this.view.setId(String.valueOf(ticket.getId()));
			this.view.setOpenedBy(String.format("%s %s", ticket.getOpenedBy().getFirstName(), ticket.getOpenedBy().getLastName()));
			this.view.setDateOpened((ticket.getOpenedOn() != null) ? ticket.getOpenedOn().toString() : "");
			this.view.setClientEmailAddress(ticket.getCustomer().getEmailAddress());
			this.view.setClientFirstName(ticket.getCustomer().getFirstName());
			this.view.setClientLastName(ticket.getCustomer().getLastName());
			this.view.setClientPhoneNumber(ticket.getCustomer().getPhoneNumber());
			this.view.setDescription(ticket.getDescription());
			this.view.setSummary(ticket.getSummary());
			this.view.setSelectedServiceCategory(ticket.getServiceCategory());
			this.view.setSelectedPriority(ticket.getPriority());
			this.view.setSelectedStatus(ticket.getStatus());

			String logText = "";

			for (ILogEntry logEntry : datasourceConfiguration.getLogEntryDatasource().getLogEntriesByTicket(ticket)) {
				logText += String.format("%s %s %s: %s", logEntry.getDateEntered(),
						logEntry.getTechnician().getFirstName(),
						logEntry.getTechnician().getLastName(),
						logEntry.getDescription());
			}

			this.view.setLogText(logText);
		}

		this.view.open();
	}

	@Override
	public void closeForm() {
		this.view.close();
	}

	/**
	 * Method handles Save Button press by taking items from the view and saving it to the database. 
	 * If all of the required fields in the ticket were not completed, the user will recieve an error message. 
	 */
	public void saveButtonPressed() {
		boolean newTicket = (ticket == null);
		ITechnician openedBy = ApplicationState.getInstance().getLoggedInTechnician();
		ITechnician technician = ApplicationState.getInstance().getLoggedInTechnician();
		Date openedOn = new Date();
		Date closedOn = null;

		ICustomer customer = new Customer();

		StringBuilder saveMessage = new StringBuilder("");

		if(checkTicketFields(saveMessage)){
			if (ticket != null) {
				openedBy = ticket.getOpenedBy();
				openedOn = ticket.getOpenedOn();
				closedOn = ticket.getCompletedOn();
			}
			
			customer.setFirstName(this.view.getClientFirstName());
			customer.setLastName(this.view.getClientLastName());
			customer.setEmailAddress(this.view.getClientEmailAddress());
			customer.setPhoneNumber(this.view.getClientPhoneNumber());
			
			//this.addLogEntry(newTicket, technician, openedBy, openedOn, closedOn, customer);

			this.ticket = ((TicketDatasource) this.datasource).saveTicket(ticket,
					openedBy,
					this.view.getSelectedServiceCategory(),
					this.view.getSelectedPriority(),
					this.view.getSelectedStatus(),
					technician, 
					openedOn, 
					closedOn,
					customer,
					this.view.getDescription(),
					this.view.getSummary(),
					(this.ticket == null) ? null : ((Ticket) this.ticket).getLogEntries());
			
			List<LogEntry> logEntries = ((Ticket) this.ticket).getLogEntries();
			
			if (logEntries == null) {
				logEntries = new ArrayList<LogEntry>();
			}
			
			if (newTicket) {
				LogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition("Ticket created");
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				logEntries.add(logEntry);
				
				((Ticket) this.ticket).setLogEntries(logEntries);
				
				((TicketDatasource) this.datasource).saveTicket(this.ticket);
			}

			this.view.showValidationSuccessDialog("Save Successful", saveMessage.toString());
		} else{
			this.view.showValidationErrorDialog("Save Failed", saveMessage.toString());
		}
	}

	/**
	 * Checks to make sure the ticket field are completed correctly. 
	 * If all of the required fields are completed the method returns true. Otherwise it returns false. 
	 * saveMessage is updated by the method to include a message that can be displayed to the user
	 * as to whether the save was successful or what fields they did not complete. 
	 * @param saveMessage A message that can be displayed to the user detailing the incomplete fields or telling the user the save was successful. 
	 * @return boolean True if all of the required fields are completed. False otherwise. 
	 */
	private boolean checkTicketFields(StringBuilder saveMessage) {
		boolean complete = true;

		if(this.view.getClientFirstName().equals("")){
			complete = false;
			saveMessage.append("Client First Name must be completed.\n");
		}
		if(this.view.getClientLastName().equals("")){
			complete = false;
			saveMessage.append("Client Last Name must be completed.\n");
		}
		if(this.view.getClientPhoneNumber().equals("")&& this.view.getClientEmailAddress().equals("")){
			complete = false;
			saveMessage.append("Either Client Phone or Client Email must be completed.\n");
		}
		if(this.view.getSummary().equals("")){
			complete = false;
			saveMessage.append("Summary field must be completed.\n");
		}
		if(this.view.getSelectedServiceCategory().equals("")){
			complete = false;
			saveMessage.append("You must select a Service Category.\n");
		}

		if(this.view.getSelectedPriority().equals("")){
			complete = false;
			saveMessage.append("You must select a Priority.\n");
		}

		if(this.view.getDescription().equals("")){
			complete = false;
			saveMessage.append("You must enter a Ticket Description.\n");
		}

		if(complete){
			saveMessage.setLength(0);
			saveMessage.append("Ticket Save Successful"); //If all the fields were completed, message will say successful
		}

		return complete;
	}

	/**
	 * Adds a log entry to the current ticket based on the information provided
	 */
	private void addLogEntry(boolean newTicket, ITechnician technician, ITechnician openedBy, Date openedOn, Date closedOn, ICustomer customer){
		ILogEntryDatasource logEntryDatasource = new LogEntryDatasource();

		if (!newTicket) {
			if (!this.view.getClientFirstName().equals(customer.getFirstName())) {
				logEntryDatasource.saveLogEntry(null, ticket, new Date(), technician,
						String.format("Customer's first name changed from %s to %s.", 
								ticket.getCustomer().getFirstName(), 
								this.view.getClientFirstName()));
			}

			if (!this.view.getClientLastName().equals(customer.getLastName())) {
				logEntryDatasource.saveLogEntry(null, ticket, new Date(), technician,
						String.format("Customer's last name changed from %s to %s.", 
								ticket.getCustomer().getLastName(), 
								this.view.getClientLastName()));
			}

			if (!this.view.getClientPhoneNumber().equals(customer.getPhoneNumber())) {
				logEntryDatasource.saveLogEntry(null, ticket, new Date(), technician,
						String.format("Customer's phone changed from %s to %s.", 
								(!ticket.getCustomer().getPhoneNumber().equals("")) ? ticket.getCustomer().getPhoneNumber() : "none",
										(!this.view.getClientPhoneNumber().equals("")) ? this.view.getClientPhoneNumber() : "none"));
			}

			if (!this.view.getClientEmailAddress().equals(customer.getEmailAddress())) {
				logEntryDatasource.saveLogEntry(null, ticket, new Date(), technician,
						String.format("Customer's email address changed from %s to %s.", 
								(!ticket.getCustomer().getEmailAddress().equals("")) ? ticket.getCustomer().getEmailAddress() : "none",
										(!this.view.getClientEmailAddress().equals("")) ? this.view.getClientEmailAddress() : "none"));
			}

			if (!this.view.getSummary().equals(ticket.getSummary())) {
				logEntryDatasource.saveLogEntry(null, ticket, new Date(), technician,
						String.format("Summary changed from %s to %s.", 
								ticket.getSummary(),
								this.view.getSummary()));
			}

			if (!this.view.getSelectedServiceCategory().equals(ticket.getServiceCategory())) {
				logEntryDatasource.saveLogEntry(null, ticket, new Date(), technician,
						String.format("Selected service category changed from %s to %s.", 
								ticket.getServiceCategory(),
								this.view.getSelectedServiceCategory()));
			}

			if (!this.view.getSelectedPriority().equals(ticket.getPriority())) {
				logEntryDatasource.saveLogEntry(null, ticket, new Date(), technician,
						String.format("Priority changed from %s to %s.", 
								ticket.getPriority(),
								this.view.getSelectedPriority()));
			}

			if (!this.view.getSelectedStatus().equals(ticket.getStatus())) {
				logEntryDatasource.saveLogEntry(null, ticket, new Date(), technician,
						String.format("Status changed from %s to %s.", 
								ticket.getStatus(),
								this.view.getSelectedStatus()));

				if (this.view.getSelectedStatus().equalsIgnoreCase("Complete")) {
					closedOn = new Date();
				}
			}
		}
		else {
			logEntryDatasource.saveLogEntry(null, ticket, new Date(), technician, "Ticket opened.");
		}
	}

	@Override
	public void setTicket(ITicket ticket) {
		this.ticket = ticket;
	}
}
