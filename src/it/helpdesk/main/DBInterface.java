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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class DBInterface {
	/**
	 * Array of Ticket objects containing the active tickets in the database.
	 */
	List<Ticket> activeTicketList;
	
	/**
	 * Array of Ticket objects containing the inactive tickets in the database.
	 */
	List<Ticket> inActiveTicketList;
	
	/**
	 * Default constructor for the class.  Initializes the array local variables.
	 */
	public DBInterface() {
		activeTicketList = new ArrayList<Ticket>();
		inActiveTicketList = new ArrayList<Ticket>();
	}
	
	
	/**.
	 * Method that will show whether the application is currently connected to the database.
	 * 
	 * @return a boolean value showing whether the application is connected to the database
	 */
	public boolean connectDB() {
		return true;
	}
	
	/**
	 * Method to create a new ticket in the database.
	 * 
	 * @param ticket contains a Ticket object with the new ticket's information
	 */
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
	
	/**
	 * Method to update an existing active ticket in the database.
	 * 
	 * @param ticket contains a Ticket object with information on the ticket being updated
	 */
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
	
	/**
	 * Method to update an existing inactive ticket in the database.
	 * 
	 * @param ticket contains a Ticket object with information on the ticket being updated
	 */
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
	
	/**
	 * Method to query the database for the active tickets.
	 * 
	 * @return an array of active Ticket objects
	 */
	public List<Ticket> queryActiveTicket() {
		
		return activeTicketList;
	}

	/**
	 * Method to query the database for the inactive tickets.
	 * 
	 * @return an array of inactive Ticket objects
	 */
	public List<Ticket> queryInactiveTicket() {
		return inActiveTicketList;
	}
	
	/**
	 * Method to sort ticket list by ID.
	 * @param active boolean select between active and inactive list
	 * 
	 */ 	
	public void sortByID(boolean active) {
		if(active)
			Collections.sort(activeTicketList, new TicketIDComparator());
		else
			Collections.sort(inActiveTicketList, new TicketIDComparator());
	}
	
	/**
	 * Method to sort ticket list by priority.
	 * @param active boolean select between active and inactive list
	 * 
	 */ 	
	public void sortByPriority(boolean active) {
		if(active)
			Collections.sort(activeTicketList, new TicketPriorityComparator());		
		else
			Collections.sort(inActiveTicketList, new TicketPriorityComparator());		
	}
	
	/**
	 * Method to sort ticket list by status.
	 * @param active boolean select between active and inactive list
	 * 
	 */ 	
	public void sortByStatus(boolean active) {
		if(active)
			Collections.sort(activeTicketList, new TicketStatusComparator());		
		else
			Collections.sort(inActiveTicketList, new TicketStatusComparator());		
	}

	/**
	 * Method to sort ticket list by category.
	 * @param active boolean select between active and inactive list
	 * 
	 */ 	
	public void sortByCategory(boolean active) {
		if(active)
			Collections.sort(activeTicketList, new TicketCategoryComparator());		
		else
			Collections.sort(inActiveTicketList, new TicketCategoryComparator());					
	}

	/**
	 * Method to sort ticket list by client name.
	 * @param active boolean select between active and inactive list
	 * 
	 */ 	
	public void sortByClient(boolean active) {
		if(active)
			Collections.sort(activeTicketList, new TicketClientComparator());		
		else
			Collections.sort(inActiveTicketList, new TicketClientComparator());		
			
	}

	/**
	 * Method to sort ticket list by opened date.
	 * @param active boolean select between active and inactive list
	 * 
	 */ 	
	public void sortByOpenedDate(boolean active) {
		if(active)
			Collections.sort(activeTicketList, new TicketDateComparator());		
		else
			Collections.sort(inActiveTicketList, new TicketDateComparator());		
	}
	
}
