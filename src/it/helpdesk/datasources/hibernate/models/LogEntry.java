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

package it.helpdesk.datasources.hibernate.models;

import java.util.Date;

import javax.persistence.*;

import it.helpdesk.ui.interfaces.models.ILogEntry;
import it.helpdesk.ui.interfaces.models.ITechnician;

@Entity
@Table(name = "LogEntry")
public class LogEntry implements ILogEntry {
	
	@Id
	@GeneratedValue
	private long id;
	
	private long ticketId;
	private Date dateEntered;
	private Technician technician;
	private String description;

	/**
	 * Method to retrieve the ID of the current person record
	 * 
	 * @return a long value containing the ID of the current person record 
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Method to set the ID of the current person record
	 * 
	 * @param id a String value containing the ID of the current person record 
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Method to get the ticket id
	 * 
	 * @return the ticket id
	 */
	public long getTicketId() {
		return this.ticketId;
	}
	
	/**
	 * Method to set the ticket id
	 * 
	 * @param the ticket id
	 */
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * Method to retrieve the date the entry was entered
	 * 
	 * @return the date the entry was entered
	 */
	public Date getDateEntered() {
		return this.dateEntered;
	}

	/**
	 * Method to set the date the entry was entered
	 * 
	 * @param the date the entry was entered
	 */
	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}

	/**
	 * Method to retrieve the technician that made the log entry
	 * 
	 * @return the technician that made the log entry
	 */
	public ITechnician getTechnician() {
		return this.technician;
	}

	/**
	 * Method to set the technician that made the log entry
	 * 
	 * @param the technician that made the log entry
	 */
	public void setTechnician(ITechnician technician) {
		this.technician = (Technician) technician;
	}

	/**
	 * Method to retrieve the description of the log entry
	 * 
	 * @return the description of the log entry
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Method to set the description of the log entry
	 * 
	 * @param the description of the log entry
	 */
	public void setDescriptition(String description) {
		this.description = description;
	}
}
