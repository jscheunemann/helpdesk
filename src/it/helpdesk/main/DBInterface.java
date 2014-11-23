package it.helpdesk.main;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public void addNewTicket(Ticket ticket)
	{
		activeTicketList.add(ticket);
	}
	
	public void updateActiveTicket(Ticket ticket)
	{
		Iterator<Ticket> itr = activeTicketList.iterator();
		
		while(itr.hasNext()){
			Ticket t = (Ticket) itr.next();
			if(ticket.getID() == t.getID()){
			}
		}
		for(int i = 0; i < activeTicketList.size(); i++){
			if(activeTicketList.get(i).getID() == ticket.getID()){
				activeTicketList.set(i, ticket);
				break;
			}
		}
	}
	
	public List<Ticket> queryActiveTicket() {
		
		return activeTicketList;
	}

	public List<Ticket> queryInactiveTicket() {
		return inActiveTicketList;
	}
}
