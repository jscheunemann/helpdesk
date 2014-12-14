package it.helpdesk.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.helpdesk.datasources.hibernate.models.Customer;
import it.helpdesk.datasources.hibernate.models.LogEntry;
import it.helpdesk.main.ApplicationState;
import it.helpdesk.ui.interfaces.IDatasourceConfiguration;
import it.helpdesk.ui.interfaces.ITicketFormController;
import it.helpdesk.ui.interfaces.ITicketFormView;
import it.helpdesk.ui.interfaces.IViewConfiguration;
import it.helpdesk.ui.interfaces.models.ICustomer;
import it.helpdesk.ui.interfaces.models.ILogEntry;
import it.helpdesk.ui.interfaces.models.ITechnician;
import it.helpdesk.ui.interfaces.models.ITicket;
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
			
			this.view.enableAddLogEntryButton();

			String logText = "<html>";

			List<ILogEntry> logEntries = datasourceConfiguration.getLogEntryDatasource().getLogEntriesByTicket(ticket);

			for (int i = logEntries.size() - 1; i >= 0; i--) {
				String format;

				if (logEntries.size() % 2 == 0) {
					format = (i % 2 == 0) ? "<div bgcolor=\"#D3D3D3\">%s\u25A0%s %s\u25A0 %s</div>" : "<div>%s\u25A0%s %s\u25A0 %s</div>";
				}
				else {
					format = (i % 2 == 1) ? "<div bgcolor=\"#D3D3D3\">%s\u25A0%s %s\u25A0 %s</div>" : "<div>%s\u25A0%s %s\u25A0 %s</div>";
				}

				logText += String.format(format, logEntries.get(i).getDateEntered(),
						logEntries.get(i).getTechnician().getFirstName(),
						logEntries.get(i).getTechnician().getLastName(),
						logEntries.get(i).getDescription());
			}

			logText += "</html>";

			this.view.setLogText(logText);
		}

		this.view.open();
	}

	@Override
	public void closeForm() {
		this.view.close();
	}

	public void addLogMessage(String text) {
		if (text.length() > 0) {
			if (this.ticket != null) {
				ITechnician technician = ApplicationState.getInstance().getLoggedInTechnician();
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Info: %s", text));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);

				List<ILogEntry> logEntries = datasourceConfiguration.getLogEntryDatasource().getLogEntriesByTicket(ticket);

				String logText = "";

				for (int i = logEntries.size() - 1; i >= 0; i--) {
					String format;

					if (logEntries.size() % 2 == 0) {
						format = (i % 2 == 0) ? "<div bgcolor=\"#D3D3D3\">%s\u25A0%s %s\u25A0 %s</div>" : "<div>%s\u25A0%s %s\u25A0 %s</div>";
					}
					else {
						format = (i % 2 == 1) ? "<div bgcolor=\"#D3D3D3\">%s\u25A0%s %s\u25A0 %s</div>" : "<div>%s\u25A0%s %s\u25A0 %s</div>";
					}

					logText += String.format(format, logEntries.get(i).getDateEntered(),
							logEntries.get(i).getTechnician().getFirstName(),
							logEntries.get(i).getTechnician().getLastName(),
							logEntries.get(i).getDescription());
				}

				logText += "</html>";

				this.view.setLogText(logText);
			}
		}
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


			if (!newTicket) {
				customer.setFirstName(this.ticket.getCustomer().getFirstName());
				customer.setLastName(this.ticket.getCustomer().getLastName());
				customer.setEmailAddress(this.ticket.getCustomer().getEmailAddress());
				customer.setPhoneNumber(this.ticket.getCustomer().getPhoneNumber());
			}

			boolean updated = true;

			if (!newTicket) {
				updated = this.addLogEntry(newTicket, technician, openedBy, openedOn, closedOn, customer);
			}

			customer.setFirstName(this.view.getClientFirstName());
			customer.setLastName(this.view.getClientLastName());
			customer.setEmailAddress(this.view.getClientEmailAddress());
			customer.setPhoneNumber(this.view.getClientPhoneNumber());

			if (updated) {
				this.ticket = this.datasource.saveTicket(ticket,
						openedBy,
						this.view.getSelectedServiceCategory(),
						this.view.getSelectedPriority(),
						this.view.getSelectedStatus(),
						technician, 
						openedOn, 
						closedOn,
						customer,
						this.view.getDescription(),
						this.view.getSummary());
			}


			if (newTicket) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition("Ticket created");
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
			}

			if (updated) {
				this.view.showValidationSuccessDialog("Save Successful", saveMessage.toString());
			}
			else {
				this.view.close();
			}
		} 
		else{
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

		if (this.view.getClientFirstName().equals("")){
			complete = false;
			saveMessage.append("The client's first name is mandatory.\n");
		}
		if (this.view.getClientLastName().equals("")){
			complete = false;
			saveMessage.append("The client's last name is mandatory.\n");
		}
		if (this.view.getClientPhoneNumber().equals("")&& this.view.getClientEmailAddress().equals("")){
			complete = false;
			saveMessage.append("You must supply either the client's phone or email address.\n");
		}
		if (this.view.getSummary().equals("")){
			complete = false;
			saveMessage.append("Summary field is mandatory.\n");
		}
		if (this.view.getSelectedServiceCategory().equals("")){
			complete = false;
			saveMessage.append("You must select a Service Category.\n");
		}

		if (this.view.getSelectedPriority().equals("")){
			complete = false;
			saveMessage.append("You must select a Priority.\n");
		}

		if (this.view.getDescription().equals("")){
			complete = false;
			saveMessage.append("The ticket description is mandatory.\n");
		}

		if (complete){
			saveMessage.setLength(0);
			saveMessage.append("Ticket Save Successful"); //If all the fields were completed, message will say successful
		}

		return complete;
	}

	/**
	 * Adds a log entry to the current ticket based on the information provided
	 */
	private boolean addLogEntry(boolean newTicket, ITechnician technician, ITechnician openedBy, Date openedOn, Date closedOn, ICustomer customer) {
		boolean updated = false;
		if (!newTicket) {
			if (!this.view.getClientFirstName().equals(customer.getFirstName())) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Customer's first name changed from \"%s\" to \"%s\".", 
						ticket.getCustomer().getFirstName(), 
						this.view.getClientFirstName()));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
				updated = true;
			}

			if (!this.view.getClientLastName().equals(customer.getLastName())) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Customer's last name changed from \"%s\" to \"%s\".", 
						ticket.getCustomer().getLastName(), 
						this.view.getClientLastName()));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
				updated = true;
			}

			if (!this.view.getClientPhoneNumber().equals(customer.getPhoneNumber())) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Customer's phone changed from \"%s\" to \"%s\".", 
						(!ticket.getCustomer().getPhoneNumber().equals("")) ? ticket.getCustomer().getPhoneNumber() : "none",
								(!this.view.getClientPhoneNumber().equals("")) ? this.view.getClientPhoneNumber() : "none"));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
				updated = true;
			}

			if (!this.view.getClientEmailAddress().equals(customer.getEmailAddress())) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Customer's email address changed from \"%s\" to \"%s\".", 
						(!ticket.getCustomer().getEmailAddress().equals("")) ? ticket.getCustomer().getEmailAddress() : "none",
								(!this.view.getClientEmailAddress().equals("")) ? this.view.getClientEmailAddress() : "none"));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
				updated = true;
			}

			if (!this.view.getSummary().equals(ticket.getSummary())) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Summary changed from \"%s\" to \"%s\".", 
						ticket.getSummary(),
						this.view.getSummary()));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
				updated = true;
			}

			if (!this.view.getDescription().equals(ticket.getDescription())) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Description changed from \"%s\" to \"%s\".", 
						ticket.getDescription(),
						this.view.getDescription()));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
				updated = true;
			}

			if (!this.view.getSelectedServiceCategory().equals(ticket.getServiceCategory())) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Selected service category changed from \"%s\" to \"%s\".", 
						ticket.getServiceCategory(),
						this.view.getSelectedServiceCategory()));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
				updated = true;
			}

			if (!this.view.getSelectedPriority().equals(ticket.getPriority())) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Priority changed from \"%s\" to \"%s\".", 
						ticket.getPriority(),
						this.view.getSelectedPriority()));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
				updated = true;
			}

			if (!this.view.getSelectedStatus().equals(ticket.getStatus())) {
				ILogEntry logEntry = new LogEntry();
				logEntry.setDateEntered(new Date());
				logEntry.setDescriptition(String.format("Status changed from \"%s\" to \"%s\".", 
						ticket.getStatus(),
						this.view.getSelectedStatus()));
				logEntry.setTechnician(technician);
				logEntry.setParent(this.ticket);
				this.datasource.addLogEntry(ticket.getId(), logEntry);
				updated = true;
			}
		}
		else {
			updated = true;
		}

		return updated;
	}


	@Override
	public void setTicket(ITicket ticket) {
		this.ticket = ticket;
	}
}
