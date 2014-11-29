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

import java.util.List;

import it.helpdesk.ui.interfaces.models.IPriority;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public interface IPriorityDatasource {
	
	/**
	 * Method to retrieve a list of priorities from the datasource.
	 * 
	 * @return an array of IPriority objects containing information on the current priorities
	 */
	public List<IPriority> getPriorities();
	
	/**
	 * Method to save a new priority to the datasource.
	 * 
	 * @param priority contains an IPriority object of the new priority
	 * @param priorityName contains a String value of the new priority name
	 */
	public void savePriority(IPriority priority, String priorityName);
}
