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

package it.helpdesk.datasources.hibernate.datasources;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import it.helpdesk.datasources.hibernate.HibernateUtil;
import it.helpdesk.datasources.hibernate.models.Customer;
import it.helpdesk.ui.interfaces.models.ICustomer;
import it.helpdesk.ui.interfaces.models.datasources.ICustomerDatasource;

/**
 * Model class to handle the communication between the application and the database.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class CustomerDatasource implements ICustomerDatasource{
	
	/**
	 * Method to return an array of ICustomer objects to the calling method.
	 * 
	 * @return an ICustomer array of the current customers
	 */
	@SuppressWarnings("unchecked")
	public List<ICustomer> getCustomers() {
		List<ICustomer> customers = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		customers = (List<ICustomer>) session.createQuery("from Customer").list();
		session.close();

		return customers;
	}

	/**
	 * Method to save a new customer record to the database.
	 * 
	 * @param customer contains an ICustomer object for the new customer
	 * @param firstName contains a String value for the first name of the new customer
	 * @param lastName contains a String value for the last name of the new customer
	 * @param phoneNumber contains a String value for the phone number of the new customer
	 * @param emailAddress contains a String value for the email address of the new customer
	 */
	public void saveCustomer(ICustomer customer, String firstName, String lastName, String phoneNumber, String emailAddress) {
		boolean newCustomer = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		if (customer == null) {
			customer = new Customer();
			newCustomer = true;
		}
		
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPhoneNumber(phoneNumber);
		customer.setEmailAddress(emailAddress);
		
		session.beginTransaction();
		
		if (newCustomer) {
			session.save(customer);
		}
		else {
			session.update(customer);
		}
	
		session.getTransaction().commit();
		session.close();
	}

}
