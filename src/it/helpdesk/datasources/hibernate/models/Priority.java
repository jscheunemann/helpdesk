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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import it.helpdesk.ui.interfaces.models.IPriority;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
@Entity
@Table(name = "Priority")
public class Priority implements IPriority {
	/**
	 * Contains the ID of the current record's priority
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * Contains the name of the current record's priority
	 */
	private String priorityName;
	
	/**
	 * Method to retrieve the ID of the current record's priority
	 * 
	 * @return a long value containing the ID of the current record's priority
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Method to set the ID of the current record's priority
	 * 
	 * @param id a long value containing the ID of the current record's priority
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Method to retrieve the name of the current record's priority
	 * 
	 * @return a String value containing the name of the current record's priority
	 */
	public String getPriorityName() {
		return this.priorityName;
	}

	/**
	 * Method to set the name of the current record's priority
	 * 
	 * @param priorityName a String value containing the name of the current record's priority
	 */
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
}
