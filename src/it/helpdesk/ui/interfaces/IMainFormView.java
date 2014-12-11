package it.helpdesk.ui.interfaces;

import it.helpdesk.ui.interfaces.models.ITicket;

import java.util.List;

public interface IMainFormView {
	/**
	 * Method to set the current controller to the object passed to the method.
	 * 
	 * @param controller contains an ITechnicianFormController object
	 */
	public void setController(IMainFormController controller);
	
	/**
	 * Method to open the technician form.
	 */
	public void open();
	
	/**
	 * Method to close the technician form.
	 */
	public void close();
	
	public void openTicketForm();
	
	public void openLoginForm();

	public void openLogoutDialog();
	
	public void displayActiveTickets(List<ITicket> tickets);
	
	public void displayInactiveTickets(List<ITicket> tickets);
}
