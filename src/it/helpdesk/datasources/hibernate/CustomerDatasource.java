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

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import it.helpdesk.ui.interfaces.models.ICustomer;
import it.helpdesk.ui.interfaces.models.datasources.ICustomerDatasource;

public class CustomerDatasource implements ICustomerDatasource{
	@SuppressWarnings("unchecked")
	public List<ICustomer> getCustomers() {
		List<ICustomer> customers = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		customers = (List<ICustomer>) session.createQuery("from Customer").list();
		session.close();

		return customers;
	}

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
