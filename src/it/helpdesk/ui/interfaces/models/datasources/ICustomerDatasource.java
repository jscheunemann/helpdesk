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

import it.helpdesk.ui.interfaces.models.*;

import java.util.List;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public interface ICustomerDatasource {
	
	/**
	 * Method to retrieve a list of customers from the datasource.
	 * 
	 * @return an array of ICustomer objects containing information on the current customers
	 */
	public List<ICustomer> getCustomers();
	
	/**
	 * Method to save a customer record to the datasource.
	 * 
	 * @param customer contains an ICustomer object of the current customer
	 * @param firstName contains a String value of the customer's first name
	 * @param lastName contains a String value of the customer's last name
	 * @param phoneNumber contains a String value of the customer's phone number
	 * @param emailAddress contains a String value of the customer's email address
	 */
	public void saveCustomer(ICustomer customer, String firstName, String lastName, String phoneNumber, String emailAddress);
}
