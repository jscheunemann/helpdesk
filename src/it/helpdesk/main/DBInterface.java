package it.helpdesk.main;

public class DBInterface {
	
	public DBInterface() {
		
	}
	
	public boolean connectDB() {
		return true;
	}
	
	public Ticket queryActiveTicket() {
		Ticket t = new Ticket();
		return t;
	}

	public Ticket queryInactiveTicket() {
		Ticket t = new Ticket();
		return t;
	}

}
