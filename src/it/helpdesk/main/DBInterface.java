/*
 * 
 * Copyright (C) 2014  Helpdesk Tracker Group, Fall Semester, UMUC
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 */

package it.helpdesk.main;

import it.helpdesk.main.Ticket.StatusEnum;

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
		StatusEnum status =ticket.getStatus();
		switch (status) {
        case NEW: {
        	activeTicketList.add(ticket);
            break;
        }	
        case IN_PROGRESS: {
        		activeTicketList.add(ticket);
                break;
        }
        case WAIT_FOR_PROCESS: {
        		activeTicketList.add(ticket);
                break;
        }
        case COMPLETE: {
    		inActiveTicketList.add(ticket);
            break;
        }
        case WITHDRAWN: {
    		inActiveTicketList.add(ticket);
            break;
        }
        case DELETE: {
    		inActiveTicketList.add(ticket);
            break;
        }
        default: {
        	activeTicketList.add(ticket);
        	break;
        }
		}


		
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
	
	
	public void updateInactiveTicket(Ticket ticket)
	{
		Iterator<Ticket> itr = inActiveTicketList.iterator();
		
		while(itr.hasNext()){
			Ticket t = (Ticket) itr.next();
			if(ticket.getID() == t.getID()){
			}
		}
		for(int i = 0; i < inActiveTicketList.size(); i++){
			if(inActiveTicketList.get(i).getID() == ticket.getID()){
				inActiveTicketList.set(i, ticket);
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
