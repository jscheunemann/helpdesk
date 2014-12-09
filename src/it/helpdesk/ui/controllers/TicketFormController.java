package it.helpdesk.ui.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.helpdesk.datasources.hibernate.datasources.LogEntryDatasource;
import it.helpdesk.datasources.hibernate.models.Customer;
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

		if (ticket != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String date = sdf.format(ticket.getOpenedOn()); 
			this.view.setDateOpened(date);

			this.view.setClientEmailAddress(ticket.getCustomer().getEmailAddress());
			this.view.setClientFirstName(ticket.getCustomer().getFirstName());
			this.view.setClientLastName(ticket.getCustomer().getLastName());
			this.view.setClientPhoneNumber(ticket.getCustomer().getPhoneNumber());
			this.view.setSummary(ticket.getSummary());
			this.view.setSelectedServiceCategory(ticket.getServiceCategory());
			this.view.setSelectedPriority(ticket.getPriority());
			this.view.setSelectedStatus(ticket.getStatus());

			String logText = "";

			for (ILogEntry logEntry : ticket.getLogEntries()) {
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

	@Override
	public void saveButtonPressed() {
		ITechnician openedBy = ApplicationState.getInstance().getLoggedInTechnician();
		ITechnician technician = ApplicationState.getInstance().getLoggedInTechnician();
		Date openedOn = new Date();
		Date closedOn = null;

		ICustomer customer = new Customer();

		if (ticket != null) {
			openedBy = ticket.getOpenedBy();
			openedOn = ticket.getOpenedOn();
			closedOn = ticket.getCompletedOn();
			customer = ticket.getCustomer();
		}
		
		this.datasource.saveTicket(ticket,
				openedBy,
				this.view.getSelectedServiceCategory(),
				this.view.getSelectedPriority(),
				this.view.getSelectedStatus(),
				technician, 
				openedOn, 
				closedOn,
				customer,
				this.view.getSummary());
		
		
		
		ILogEntryDatasource logEntryDatasource = new LogEntryDatasource();
		
		if (ticket != null) {
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
