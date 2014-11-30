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

package it.helpdesk.ui.interfaces;

import it.helpdesk.ui.interfaces.models.datasources.*;

/**
 * Class to handle the configuration of the GitHub datasource.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public interface IDatasourceConfiguration {
	
	/**
	 * Method to retrieve the customer datasource
	 * 
	 * @return an ICustomerDatasource object
	 */
	public ICustomerDatasource getCustomerDatasource();
	
	/**
	 * Method to retrieve the priority datasource
	 * 
	 * @return an IPriorityDatasource object
	 */
	public IPriorityDatasource getPriorityDatasource();
	
	/**
	 * Method to retrieve the service category datasource
	 * 
	 * @return an IServiceCategoryDatasource object
	 */
	public IServiceCategoryDatasource getServiceCategoryDatasource();
	
	/**
	 * Method to retrieve the status datasource
	 * 
	 * @return an IStatusDatasource object
	 */
	public IStatusDatasource getStatusDatasource();
	
	/**
	 * Method to retrieve the technician datasource
	 * 
	 * @return an ITechnicianDatasource object
	 */
	public ITechnicianDatasource getTechnicianDatasource();
	
	/**
	 * Method to retrieve the ticket datasource
	 * 
	 * @return an ITicketDatasource object
	 */
	public ITicketDatasource getTickeDatasource();
}
