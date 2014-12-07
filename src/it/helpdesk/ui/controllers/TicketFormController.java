package it.helpdesk.ui.controllers;

import java.text.SimpleDateFormat;
import it.helpdesk.ui.interfaces.ITicketFormController;
import it.helpdesk.ui.interfaces.ITicketFormView;
import it.helpdesk.ui.interfaces.models.ILogEntry;
import it.helpdesk.ui.interfaces.models.ITicket;

public class TicketFormController implements ITicketFormController {
	ITicket ticket;
	ITicketFormView view;
	
	public TicketFormController() {
		//this.view = new AddEditTicket();
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
