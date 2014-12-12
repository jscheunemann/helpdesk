package it.helpdesk.ui.interfaces;

public interface IMainFormController {
	public void openForm();
	public void closeForm();
	public void loadActiveTickets();
	public void loadInactiveTickets();
	public void openTicketForm();
	public void openLoginForm();
	public void clearActiveTicketView();
	public void clearInactiveTicketView();
	public void updateSelectedTicket(long id);
	public void clearSelectedTicket();
}