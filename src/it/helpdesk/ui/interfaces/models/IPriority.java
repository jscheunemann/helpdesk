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

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public interface IPriority {
	/**
	 * Method to retrieve the current priority ID
	 * 
	 * @return a long value containing the current priority
	 */
	public long getId();
	
	/**
	 * Method to set the current priority ID to the value passed to the method.
	 * 
	 * @param id contains the new current priority ID
	 */
	public void setId(long id);
	
	/**
	 * Method to retrieve the current priority name
	 * 
	 * @return a String value containing the current priority name
	 */
	public String getPriorityName();
	
	/**
	 * Method to set the current priority name to the value passed to the method.
	 * 
	 * @param priorityName contains the new current priority name
	 */
	public void setPriorityName(String priorityName);
}
