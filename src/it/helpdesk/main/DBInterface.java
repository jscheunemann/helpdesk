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

import it.helpdesk.datasources.hibernate.models.Ticket;

import java.util.ArrayList;
import java.util.Collections;

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
	private ArrayList<Ticket> activeTicketList;
	
	/**
	 * Array of Ticket objects containing the inactive tickets in the database.
	 */
	private ArrayList<Ticket> inActiveTicketList;
	
	/**
	 * Default constructor for the class.  Initializes the array local variables.
	 */
	public DBInterface() {
		activeTicketList = new ArrayList<Ticket>();
		inActiveTicketList = new ArrayList<Ticket>();
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
