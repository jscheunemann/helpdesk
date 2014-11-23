/*
 * Copyright (C) 2014  Helpdesk Tracker Group, Fall Semester, UMUC
 * 
 * This software is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 */

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
