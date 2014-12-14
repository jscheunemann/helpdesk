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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import it.helpdesk.datasources.hibernate.HibernateUtil;
import it.helpdesk.datasources.hibernate.datasources.LogEntryDatasource;
import it.helpdesk.ui.interfaces.models.ICustomer;
import it.helpdesk.ui.interfaces.models.ILogEntry;
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
@Table(name = "HelpdeskTicket")
public class Ticket implements ITicket {
	/**
	 * Contains the ID of the current ticket.
	 */
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="technician_opened_by_id")
	private Technician openedBy;
	
	private String serviceCategory;
	private String priority;
	private String status;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="technician_id")
	private Technician technician;
	
	@Column(name = "opened_on")
	private Date openedOn;
	
	@Column(name = "completed_on")
	private Date completedOn;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	@Fetch(FetchMode.JOIN)
	private Customer customer;
	
	private String summary;
	
	@Column(columnDefinition = "LONGTEXT")
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="parent")
    @Column(nullable=false)
	private List<LogEntry> logEntries;
	
	@Transient
	private boolean technicianLoaded = false;
	
	
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
	public String getServiceCategory() {
		return this.serviceCategory;
	}

	/**
	 * Method to set the current record's service category.
	 * 
	 * @param the service category of the current record
	 */
	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	/**
	 * Method to retrieve the current record's priority.
	 * 
	 * @return the priority of the current record
	 */
	public String getPriority() {
		return this.priority;
	}

	/**
	 * Method to set the current record's priority.
	 * 
	 * @param the priority of the current record
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * Method to retrieve the current record's status.
	 * 
	 * @return the status of the current record
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Method to set the current record's status.
	 * 
	 * @param the status of the current record
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Method to retrieve the current record's assigned technician.
	 * 
	 * @return the assigned technician of the current record
	 */
	public ITechnician getTechnician() {
		if (!this.technicianLoaded) {
			HibernateUtil.getSessionFactory().openSession().refresh(this.getTechnician());
			Hibernate.initialize(this);
		}
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
	 * Method to retrieve the current ticket's description value.
	 * 
	 * @return a String value containing the ticket's description value
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * Method to set the current ticket's description value.
	 * @param Description contains the current description information
	 */
	public void setDescription(String Description){
		this.description = Description;
	}

	/**
	 * Method to add log entry to ticket
	 * 
	 * @param the date the entry was made
	 * @param the technician making the entry
	 * @param the description of the log entry
	 */
	@Override
	public void addLogEntry(ILogEntry logEntry) {
		if (this.logEntries == null) {
			this.logEntries = new ArrayList<LogEntry>();
		}
		this.logEntries.add((LogEntry) logEntry);
	}

	public List<LogEntry> getLogEntries() {
		return this.logEntries;
	}

	public void setLogEntries(List<LogEntry> logEntries) {
		this.logEntries = logEntries;
	}
	
	/**
	 * Compares two tickets to see if they are the same ticket. 
	 * @return Returns true if the tickets have the same Ticket ID, False otherwise. 
	 */
	public boolean equals(Object object){
		if(this.getClass() ==  object.getClass()) {
			if(this.getId()== ((Ticket)object).getId()){
				return true;
			}
		}
		return false;

	}
}
