package it.helpdesk.ui.controllers;

import java.text.SimpleDateFormat;

import it.helpdesk.datasources.hibernate.models.Customer;
import it.helpdesk.datasources.hibernate.models.Priority;
import it.helpdesk.datasources.hibernate.models.ServiceCategory;
import it.helpdesk.datasources.hibernate.models.Status;
import it.helpdesk.ui.interfaces.IDatasourceConfiguration;
import it.helpdesk.ui.interfaces.ILoginFormView;
import it.helpdesk.ui.interfaces.ITicketFormController;
import it.helpdesk.ui.interfaces.ITicketFormView;
import it.helpdesk.ui.interfaces.IViewConfiguration;
import it.helpdesk.ui.interfaces.models.ICustomer;
import it.helpdesk.ui.interfaces.models.ILogEntry;
import it.helpdesk.ui.interfaces.models.IPriority;
import it.helpdesk.ui.interfaces.models.IServiceCategory;
import it.helpdesk.ui.interfaces.models.IStatus;
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
		ICustomer customer = new Customer();
		customer.setFirstName(this.view.getClientFirstName());
		customer.setLastName(this.view.getClientLastName());
		customer.setEmailAddress(this.view.getClientEmailAddress());
		customer.setPhoneNumber(this.view.getClientPhoneNumber());
		
		this.ticket.setCustomer(customer);
		this.ticket.setSummary(this.view.getSummary());
		
		IServiceCategory serviceCat = new ServiceCategory();
		serviceCat.setCategoryName(this.view.getSelectedServiceCategory());
		this.ticket.setServiceCategory(serviceCat);
		
		IPriority priority = new Priority();
		priority.setPriorityName(this.view.getSelectedPriority());
		this.ticket.setPriority(priority);
		
		IStatus status = new Status();
		status.setStatusName(this.view.getSelectedStatus());
		this.ticket.setStatus(status);
		// TODO still need to fill out the rest of ticket data		
	}

	@Override
	public void setTicket(ITicket ticket) {
		this.ticket = ticket;
		
	}
}
