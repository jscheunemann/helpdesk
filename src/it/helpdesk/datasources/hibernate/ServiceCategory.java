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

package it.helpdesk.datasources.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import it.helpdesk.ui.interfaces.models.IServiceCategory;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
@Entity
@Table(name = "ServiceCategory")
public class ServiceCategory implements IServiceCategory {
	
	/**
	 * Contains the ID of the current record's service category
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * Contains the name of the current record's service category
	 */
	private String serviceCategory;

	/**
	 * Method to retrieve the current record's service category ID.
	 * 
	 * @return a long value of the current record's service category
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Method to set the current record's service category ID.
	 * 
	 * @param id a long value of the current record's service category
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Method to retrieve the current record's service category name.
	 * 
	 * @return a String value of the current record's service category
	 */
	public String getCategoryName() {
		return this.serviceCategory;
	}

	/**
	 * Method to set the current record's service category name.
	 * 
	 * @param serviceCategory a String value of the current record's service category
	 */
	public void setCategoryName(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
}
