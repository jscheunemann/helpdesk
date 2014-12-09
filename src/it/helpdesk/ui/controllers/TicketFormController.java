package it.helpdesk.ui.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.helpdesk.datasources.hibernate.models.Customer;
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
	 * Contains the logged in technician object
	 */
	private ITechnician technician;
	
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
	
	public void setLoggedInTechnician(ITechnician technician) {
		this.technician = technician;
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
		ITechnician openedBy = this.technician;
		Date openedOn = new Date();
		Date closedOn = null;
		
		ICustomer customer = new Customer();
		
		
		if (ticket != null) {
			openedBy = ticket.getOpenedBy();
			openedOn = ticket.getOpenedOn();
			closedOn = ticket.getCompletedOn();
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
	}

	@Override
	public void setTicket(ITicket ticket) {
		this.ticket = ticket;
	}
}
