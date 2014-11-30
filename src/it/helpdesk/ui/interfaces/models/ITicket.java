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
import java.util.List;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public interface ITicket {
	/**
	 * Method to retrieve the current ticket ID value.
	 * 
	 * @return a long value containing the current ticket ID
	 */
	public long getId();
	
	/**
	 * Method to set the current ticket's ID
	 * 
	 * @param id contains a long value for the ticket ID
	 */
	public void setId(long id);
	
	/**
	 * Method to retrieve the current service category object.
	 * 
	 * @return an IServiceCategory object containing the current ticket service category 
	 */
	public IServiceCategory getServiceCategory();
	
	/**
	 * Method to set the current ticket's service category
	 * 
	 * @param serviceCategory contains an IServiceCategory object for the ticket service category
	 */
	public void setServiceCategory(IServiceCategory serviceCategory);
	
	/**
	 * Method to get the ticket's priority
	 * 
	 * @return the priority of the ticket
	 */
	public IPriority getPriority();
	
	/**
	 * Method to set the ticket's priority
	 * 
	 * @param the priority of the ticket
	 */
	public void setPriority(IPriority priority);
	
	/**
	 * Method to retrieve the current status object.
	 * 
	 * @return an IStatus object containing the current ticket status 
	 */
	public IStatus getStatus();
	
	/**
	 * Method to set the current ticket's status
	 * 
	 * @param status contains an IStatus object for the ticket status
	 */
	public void setStatus(IStatus status);
	
	/**
	 * Method to retrieve the current technician
	 * 
	 * @return an ITechnician object containing the current technician
	 */
	public ITechnician getTechnician();
	
	/**
	 * Method to set the current ticket's operator
	 * 
	 * @param operator contains an ITechnician object for the ticket operator
	 */
	public void setTechnician(ITechnician technician);
	
	/**
	 * Method to retrieve the current ticket open date.
	 * 
	 * @return an Date value containing the current ticket open date 
	 */
	public Date getOpenedOn();
	
	/**
	 * Method to set the current ticket's opened on date
	 * 
	 * @param openedOn contains the date the ticket was opened on
	 */
	public void setOpenedOn(Date openedOn);
	
	/**
	 * Method to retrieve the current ticket closed date.
	 * 
	 * @return an Date value containing the current ticket closed date 
	 */
	public Date getCompletedOn();
	
	/**
	 * Method to set the current ticket's completed on date
	 * 
	 * @param completedOn contains the date the ticket was completed on
	 */
	public void setCompletedOn(Date completedOn);
	
	/**
	 * Method to retrieve customer
	 * 
	 * @return the customer
	 */
	public ICustomer getCustomer();
	
	/**
	 * Method to set the customer
	 * 
	 * @param the customer
	 */
	public void setCustomer(ICustomer customer);
	
	/**
	 * Method to retrieve a summary of the issue reported
	 * 
	 * @return a summary of the issue reported
	 */
	public String getSummary();
	
	/**
	 * Method to set the summary of issue reported
	 * 
	 * @param the summary of the issue reported
	 */
	public void setSummary(String summary);
	
	/**
	 * Method to retrieve a list of log entries
	 * 
	 * @return a list of log entries
	 */
	public List<ILogEntry> getLogEntries();
	
	/**
	 * Method to set the description of the remediation efforts
	 * 
	 * @param the description of the remediation efforts
	 */
	public void setLogEntries(List<ILogEntry> logEntries);
}
