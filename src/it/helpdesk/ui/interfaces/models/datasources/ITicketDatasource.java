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

package it.helpdesk.ui.interfaces.models.datasources;

import it.helpdesk.ui.interfaces.models.*;

import java.util.Date;
import java.util.List;

public interface ITicketDatasource {
	/**
	 * Method to retrieve a list of tickets from server
	 * 
	 * @return a list of tickets
	 */
	public List<ITicket> getTickets();
	
	/**
	 * Method to retrieve a list of open tickets from server
	 * 
	 * @return a list of open tickets
	 */
	public List<ITicket> getOpenTickets();
	
	/**
	 * Method to retrieve a list of closed tickets from server
	 * 
	 * @return a list of closed tickets
	 */
	public List<ITicket> getClosedTickets();
	
	/**
	 * Method to retrieve a list of tickets by technician
	 * '
	 * @return a list of tickets by technician
	 */
	public List<ITicket> getTicketsByTechnician(ITechnician technician);
	
	/**
	 * Method to retrieve a list of open tickets by technician
	 * 
	 * @return a list of open tickets by technician
	 */
	public List<ITicket> getOpenTicketsByTechnician(ITechnician technician);
	
	/**
	 * Method to retrieve a list of closed tickets by technician
	 * 
	 * @return a list of closed tickets by technician
	 */
	public List<ITicket> getClosedTicketsByTechnician(ITechnician technician);
	
	/**
	 * Method to retrieve a ticket by id
	 * 
	 * @param the id of the ticket
	 * @return the requested ticket, null if none found
	 */
	public ITicket getTicketById(long id);
	
	/**
	 * Method to and/or save a ticket
	 * 
	 * @param the ticket information to be persisted
	 */
	@SuppressWarnings("rawtypes")
	public void saveTicket(ITicket ticket, ITechnician openedBy, IServiceCategory serviceCategory, IPriority priority,
			IStatus status, ITechnician technician, Date openedOn, Date closedOn, ICustomer customer,
			String summary);
}
