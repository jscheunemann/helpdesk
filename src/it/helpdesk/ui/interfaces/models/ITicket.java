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
	 * Method to retrieve the current operator object.
	 * 
	 * @return an ITechnician object containing the current operator 
	 */
	public ITechnician getOperator();
	
	/**
	 * Method to set the current ticket's operator
	 * 
	 * @param operator contains an ITechnician object for the ticket operator
	 */
	public void setOperator(ITechnician operator);
	
	/**
	 * Method to retrieve the current assignee object.
	 * 
	 * @return an ITechnician object containing the current assignee 
	 */
	public ITechnician getAssignedTo();
	
	/**
	 * Method to set the current ticket's assignee
	 * 
	 * @param assignedTo contains an ITechnician object for the ticket assignee
	 */
	public void setAssignedTo(ITechnician assignedTo);
	
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
}
