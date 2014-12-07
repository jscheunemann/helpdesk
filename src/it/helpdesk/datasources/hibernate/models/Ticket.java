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
import java.util.List;

import javax.persistence.*;

import it.helpdesk.datasources.hibernate.datasources.LogEntryDatasource;
import it.helpdesk.ui.interfaces.models.ICustomer;
import it.helpdesk.ui.interfaces.models.IPriority;
import it.helpdesk.ui.interfaces.models.IServiceCategory;
import it.helpdesk.ui.interfaces.models.IStatus;
import it.helpdesk.ui.interfaces.models.ITechnician;
import it.helpdesk.ui.interfaces.models.ITicket;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-30
 */
@Entity
@Table(name = "Ticket")
public class Ticket implements ITicket {
	/**
	 * Contains the ID of the current ticket.
	 */
	@Id
	@GeneratedValue
	private long id;
	
	private Technician openedBy;
	private ServiceCategory serviceCategory;
	private Priority priority;
	private Status status;
	private Technician technician;
	private Date openedOn;
	private Date completedOn;
	private Customer customer;
	private String summary;
	
	@OneToMany
    @JoinTable(
            name="Ticket_Log_Entries",
            joinColumns = @JoinColumn(name="ticket_id"),
            inverseJoinColumns = @JoinColumn(name="log_entry_id")
    )
	private List<LogEntry> logEntries;
	
	
	/**
	 * Method to retrieve the current record's ID.
	 * 
	 * @return a long value of the current record
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Method to set the current record's ID.
	 * 
	 * @param id a long value of the current record 
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Method to set who opened the ticket
	 * 
	 * @param the technician that opened the ticket
	 */
	public void setOpenedBy(ITechnician technician) {
		this.openedBy = (Technician) technician;
	}
	
	/**
	 * Method to get who opened the ticket
	 * 
	 * @return the technician that opened the ticket
	 */
	public ITechnician getOpenedBy() {
		return this.openedBy;
	}

	/**
	 * Method to retrieve the current record's service category.
	 * 
	 * @return the service category of the current record
	 */
	public IServiceCategory getServiceCategory() {
		return this.serviceCategory;
	}

	/**
	 * Method to set the current record's service category.
	 * 
	 * @param the service category of the current record
	 */
	public void setServiceCategory(IServiceCategory serviceCategory) {
		this.serviceCategory = (ServiceCategory) serviceCategory;
	}

	/**
	 * Method to retrieve the current record's priority.
	 * 
	 * @return the priority of the current record
	 */
	public IPriority getPriority() {
		return this.priority;
	}

	/**
	 * Method to set the current record's priority.
	 * 
	 * @param the priority of the current record
	 */
	public void setPriority(IPriority priority) {
		this.priority = (Priority) priority;
	}

	/**
	 * Method to retrieve the current record's status.
	 * 
	 * @return the status of the current record
	 */
	public IStatus getStatus() {
		return this.status;
	}

	/**
	 * Method to set the current record's status.
	 * 
	 * @param the status of the current record
	 */
	public void setStatus(IStatus status) {
		this.status = (Status) status;
	}

	/**
	 * Method to retrieve the current record's assigned technician.
	 * 
	 * @return the assigned technician of the current record
	 */
	public ITechnician getTechnician() {
		return this.technician;
	}

	/**
	 * Method to set the current record's assigned technician.
	 * 
	 * @param the assigned technician of the current record
	 */
	public void setTechnician(ITechnician technician) {
		this.technician = (Technician) technician;
	}

	/**
	 * Method to retrieve the current record's date opened.
	 * 
	 * @return the date opened of the current record
	 */
	public Date getOpenedOn() {
		return this.openedOn;
	}

	/**
	 * Method to set the current record's date opened.
	 * 
	 * @param the date opened of the current record
	 */
	public void setOpenedOn(Date openedOn) {
		this.openedOn = openedOn;
	}

	/**
	 * Method to retrieve the current record's date closed.
	 * 
	 * @return the date closed of the current record
	 */
	public Date getCompletedOn() {
		return this.completedOn;
	}

	/**
	 * Method to set the current record's date closed.
	 * 
	 * @param the date closed of the current record
	 */
	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}

	/**
	 * Method to retrieve the current record's customer.
	 * 
	 * @return the customer of the current record
	 */
	public ICustomer getCustomer() {
		return this.customer;
	}

	/**
	 * Method to set the current record's customer.
	 * 
	 * @param the customer of the current record
	 */
	public void setCustomer(ICustomer customer) {
		this.customer = (Customer) customer;
	}

	/**
	 * Method to retrieve the current record's summary.
	 * 
	 * @return the summary of the current record
	 */
	public String getSummary() {
		return this.summary;
	}

	/**
	 * Method to set the current record's summary.
	 * 
	 * @param the summary of the current record
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Method to retrieve the current record's log entries.
	 * 
	 * @return the log entries of the current record
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getLogEntries() {
		return this.logEntries;
	}

	/**
	 * Method to set the current record's summary.
	 * 
	 * @param the summary of the current record
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setLogEntries(List logEntries) {
		this.logEntries = logEntries;
	}

	/**
	 * Method to add log entry to ticket
	 * 
	 * @param the date the entry was made
	 * @param the technician making the entry
	 * @param the description of the log entry
	 */
	@Override
	public void addLogEntry(Date date, ITechnician technician,
			String description) {
		LogEntryDatasource logEntryDatasource = new LogEntryDatasource();
		
		logEntryDatasource.saveLogEntry(null, this, date, technician, description);
	}
}
