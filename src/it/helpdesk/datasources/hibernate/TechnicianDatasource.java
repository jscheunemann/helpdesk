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

import it.helpdesk.datasources.hibernate.Technician;
import it.helpdesk.ui.interfaces.models.ITechnician;
import it.helpdesk.ui.interfaces.models.datasources.ITechnicianDatasource;

public class TechnicianDatasource implements ITechnicianDatasource {

	@SuppressWarnings("unchecked")
	@Override
	public List<ITechnician> getTechnicians() {
		List<ITechnician> technicians = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		technicians = (List<ITechnician>) session.createQuery("from Technician").list();
		session.close();

		return technicians;
	}

	@Override
	public void saveTechnician(ITechnician technician, String technicianname, String password, String firstName, String lastName, String phoneNumber, String emailAddress) {
		boolean newUser = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		if (technician == null) {
			technician = new Technician();
			newUser = true;
		}
		
		technician.setUsername(technicianname);
		technician.setPassword(password);
		technician.setFirstName(firstName);
		technician.setLastName(lastName);
		technician.setPhoneNumber(phoneNumber);
		technician.setEmailAddress(emailAddress);
		
		session.beginTransaction();
		
		if (newUser) {
			session.save(technician);
		}
		else {
			session.update(technician);
		}
	
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public ITechnician getTechnicianByUsername(String username) {
		for (ITechnician technician : this.getTechnicians()) {
			if (technician.getUsername().equalsIgnoreCase(username)) {
				return technician;
			}
		}
		
		return null;
	}

	@Override
	public boolean usernameAvailable(String username) {
		boolean available = true;
		
		for (ITechnician technician : this.getTechnicians()) {
			if (technician.getUsername().equalsIgnoreCase(username)) {
				available = false;
			}
		}
		
		return available;
	}

	@Override
	public boolean checkPassword(String technicianname, String password) {
		ITechnician ret = null;
		
		for (ITechnician technician : this.getTechnicians()) {
			if (technician.getUsername().equalsIgnoreCase(technicianname)) {
				ret = technician;
			}
		}
		
		if (ret != null) {
			return (ret.getPassword().equals(password));
		}
		else {
			return false;
		}
	}
}
