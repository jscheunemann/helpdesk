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

package it.helpdesk.datasources.memory;

import it.helpdesk.ui.interfaces.*;
import it.helpdesk.ui.interfaces.models.datasources.ITechnicianDatasource;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class MemoryDatasourceConfiguration implements IDatasourceConfiguration {
	
	/**
	 * Contains an ITechnicianDatasource object for the technician.
	 */
	ITechnicianDatasource datasource = null;
	
	/**
	 * Default class constructor to build the technician datasource object.
	 */
	public MemoryDatasourceConfiguration() {
		datasource = new TechnicianDatasource();
		datasource.saveTechnician(null, "test", "test", "Jason", "Scheunemann", "999-999-9999", "jason.scheunemann@example.com");
	}
	
	/**
	 * Method to retrieve the current technician datasource.
	 * 
	 * @return an ITechnicianDatasource object referencing the current local object
	 */
	@Override
	public ITechnicianDatasource getTechnicianDatasource() {
		return datasource;
	}
}
