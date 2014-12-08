package it.helpdesk.ui.controllers;

import java.text.SimpleDateFormat;

import it.helpdesk.ui.interfaces.IDatasourceConfiguration;
import it.helpdesk.ui.interfaces.ILoginFormView;
import it.helpdesk.ui.interfaces.ITicketFormController;
import it.helpdesk.ui.interfaces.ITicketFormView;
import it.helpdesk.ui.interfaces.IViewConfiguration;
import it.helpdesk.ui.interfaces.models.ILogEntry;
import it.helpdesk.ui.interfaces.models.ITicket;
import it.helpdesk.ui.interfaces.models.datasources.ITechnicianDatasource;
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
		this.view = viewConfiguration.getTicketFormView();
		this.view.setController(this);
		this.datasource = datasourceConfiguration.getTicketDatasource();
	}

	@Override
	public void openForm() {
		if (ticket != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String date = sdf.format(ticket.getOpenedOn()); 
			this.view.setDateOpened(date);
			
			this.view.setClientEmailAddress(ticket.getCustomer().getEmailAddress());
			this.view.setClientFirstName(ticket.getCustomer().getFirstName());
			this.view.setClientLastName(ticket.getCustomer().getLastName());
			this.view.setClientPhoneNumber(ticket.getCustomer().getPhoneNumber());
			this.view.setSummary(ticket.getSummary());
			this.view.setSelectedServiceCategory(ticket.getServiceCategory().getCategoryName());
			this.view.setSelectedPriority(ticket.getPriority().getPriorityName());
			this.view.setSelectedStatus(ticket.getStatus().getStatusName());
			
			for (ILogEntry logEntry : ticket.getLogEntries()) {
				
			}
				
			//this.view.setLogText(logText);
		}
		this.view.open();
	}

	@Override
	public void closeForm() {
		this.view.close();
	}

	@Override
	public void saveButtonPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTicket(ITicket ticket) {
		// TODO Auto-generated method stub
		
	}
}
