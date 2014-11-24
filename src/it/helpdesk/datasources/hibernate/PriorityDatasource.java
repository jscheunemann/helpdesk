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

import it.helpdesk.ui.interfaces.models.IPriority;
import it.helpdesk.ui.interfaces.models.datasources.IPriorityDatasource;

public class PriorityDatasource implements IPriorityDatasource {

	@SuppressWarnings("unchecked")
	@Override
	public List<IPriority> getPriorities() {
		List<IPriority> priorities = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		priorities = (List<IPriority>) session.createQuery("from Priority").list();
		session.close();

		return priorities;
	}

	@Override
	public void savePriority(IPriority priority, String priorityName) {
		boolean newPriority = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		if (priority == null) {
			priority = new Priority();
			newPriority = true;
		}
		
		priority.setPriorityName(priorityName);
		
		session.beginTransaction();
		
		if (newPriority) {
			session.save(priority);
		}
		else {
			session.update(priority);
		}
	
		session.getTransaction().commit();
		session.close();
	}

}
