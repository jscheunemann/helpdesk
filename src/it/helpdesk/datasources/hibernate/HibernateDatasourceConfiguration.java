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

import it.helpdesk.ui.interfaces.IDatasourceConfiguration;
import it.helpdesk.ui.interfaces.models.datasources.ITechnicianDatasource;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class HibernateDatasourceConfiguration implements IDatasourceConfiguration {

	/**
	 * Contains an ITechnicianDatasource object.
	 */
	private ITechnicianDatasource datasource = null;
	
	/**
	 * Default class constructor that will initialize the technician datasource. 
	 */
	public HibernateDatasourceConfiguration() {
		datasource = new TechnicianDatasource();
	}
	
	/**
	 * Method to return the current ITechnicianDatasource object.
	 * 
	 * @return a ITechnicianDatasource object containing the current technician datasource
	 */
	@Override
	public ITechnicianDatasource getTechnicianDatasource() {
		return this.datasource;
	}
}
