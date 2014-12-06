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

package it.helpdesk.ui.interfaces.models;

import java.util.Date;

public interface ILogEntry {
	/**
	 * Method to get the id of the log entry
	 * 
	 * @return the id of the log entry
	 */
	public long getId();
	
	/**
	 * Method to set the id of the log entry
	 * 
	 * @param the id of the log entry
	 */
	public void setId(long id);
	
	/**
	 * Method to get the ticket id
	 * 
	 * @return the ticket id
	 */
	public long getTicketId();
	
	/**
	 * Method to set the ticket id
	 * 
	 * @param the ticket id
	 */
	public void setTicketId(long ticketId);
	
	/**
	 * Method to get the date the log entry was created
	 * 
	 * @return the date the log entry was created
	 */
	public Date getDateEntered();
	
	/**
	 * Method to set the date the log entry was created
	 * 
	 * @param the date the log entry was created
	 */
	public void setDateEntered(Date dateEntered);
	
	/**
	 * Method to get the technician that created the log entry
	 * 
	 * @return the technician that created the log entry
	 */
	public ITechnician getTechnician();
	
	/**
	 * Method to set the technician that created the log entry
	 * 
	 * @param the technician that create the log entry
	 */
	public void setTechnician(ITechnician technician);
	
	/**
	 * Method to get the description of the log entry
	 * 
	 * @return the description of the log entry
	 */
	public String getDescription();
	
	/**
	 * Method to set the description of the log entry
	 * 
	 * @param the description of the log entry
	 */
	public void setDescriptition(String description);
}
