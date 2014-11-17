package it.helpdesk.main;

import java.util.ArrayList;
import java.util.List;

public class DBInterface {

	List<Ticket> activeTicketList;
	List<Ticket> inActiveTicketList;
	
	public DBInterface() {
		activeTicketList = new ArrayList<Ticket>();
		inActiveTicketList = new ArrayList<Ticket>();
	}
	
	public boolean connectDB() {
		return true;
	}
	
	public List<Ticket> queryActiveTicket() {
		return activeTicketList;
	}

	public List<Ticket> queryInactiveTicket() {
		return inActiveTicketList;
	}

}
