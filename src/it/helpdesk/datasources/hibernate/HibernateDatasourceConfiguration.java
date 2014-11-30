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

import it.helpdesk.datasources.hibernate.datasources.CustomerDatasource;
import it.helpdesk.datasources.hibernate.datasources.PriorityDatasource;
import it.helpdesk.datasources.hibernate.datasources.ServiceCategoryDatasource;
import it.helpdesk.datasources.hibernate.datasources.StatusDatasource;
import it.helpdesk.datasources.hibernate.datasources.TechnicianDatasource;
import it.helpdesk.datasources.hibernate.datasources.TicketDatasource;
import it.helpdesk.ui.interfaces.*;
import it.helpdesk.ui.interfaces.models.datasources.*;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class HibernateDatasourceConfiguration implements IDatasourceConfiguration {
	/**
	 * Contains n ICusotmerDatasource object.
	 */
	private ICustomerDatasource customerDatasource = null;
	
	/**
	 * Contains an IPriorityDatasource object.
	 */
	private IPriorityDatasource priorityDatasource = null;
	
	/**
	 * Contains an IServiceCategoryDatasource object.
	 */
	private IServiceCategoryDatasource serviceCategoryDatasource = null;
	
	/**
	 * Contains an IStatusDatasource object.
	 */
	private IStatusDatasource statusDatasource = null;
	
	/**
	 * Contains an ITechnicianDatasource object.
	 */
	private ITechnicianDatasource technicianDatasource = null;
	
	/**
	 * Contains an ITicketDatasource object.
	 */
	private ITicketDatasource ticketDatasource = null;
	
	/**
	 * Default class constructor.Instantiate all of the datasource objects.
	 */
	public HibernateDatasourceConfiguration() {
		this.customerDatasource = new CustomerDatasource();
		this.priorityDatasource = new PriorityDatasource();
		this.serviceCategoryDatasource = new ServiceCategoryDatasource();
		this.statusDatasource = new StatusDatasource();
		this.technicianDatasource = new TechnicianDatasource();
		this.ticketDatasource = new TicketDatasource();
	}

	/**
	 * Method to return the current ICustomerDatasource object.
	 * 
	 * @return an ICustomerDatasource object containing the current customer datasource
	 */
	public ICustomerDatasource getCustomerDatasource() {
		return this.customerDatasource;
	}

	/**
	 * Method to return the current IPriorityDatasource object.
	 * 
	 * @return an IPriorityDatasource object containing the current priority datasource
	 */
	public IPriorityDatasource getPriorityDatasource() {
		return this.priorityDatasource;
	}

	/**
	 * Method to return the current IServiceCategoryDatasource object.
	 * 
	 * @return an IServiceCategoryDatasource object containing the current service category datasource
	 */
	public IServiceCategoryDatasource getServiceCategoryDatasource() {
		return this.serviceCategoryDatasource;
	}

	/**
	 * Method to return the current IStatusDatasource object.
	 * 
	 * @return an IStatusDatasource object containing the current status datasource
	 */
	public IStatusDatasource getStatusDatasource() {
		return this.statusDatasource;
	}
	
	/**
	 * Method to return the current ITechnicianDatasource object.
	 * 
	 * @return an ITechnicianDatasource object containing the current technician datasource
	 */
	public ITechnicianDatasource getTechnicianDatasource() {
		return this.technicianDatasource;
	}

	/**
	 * Method to return the current ITicketDatasource object.
	 * 
	 * @return an ITicketDatasource object containing the current ticket datasource
	 */
	public ITicketDatasource getTickeDatasource() {
		return this.ticketDatasource;
	}
}
