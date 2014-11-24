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

import it.helpdesk.ui.interfaces.models.IStatus;
import it.helpdesk.ui.interfaces.models.datasources.IStatusDatasource;

public class StatusDatasource implements IStatusDatasource {

	@SuppressWarnings("unchecked")
	@Override
	public List<IStatus> getStatuses() {
		List<IStatus> statuses = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		statuses = (List<IStatus>) session.createQuery("from Status").list();
		session.close();

		return statuses;
	}

	@Override
	public void saveStatus(IStatus status, String statusName) {
		boolean newStatus = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		if (status == null) {
			status = new Status();
			newStatus = true;
		}
		
		status.setStatusName(statusName);
		
		session.beginTransaction();
		
		if (newStatus) {
			session.save(status);
		}
		else {
			session.update(status);
		}
	
		session.getTransaction().commit();
		session.close();
	}

}
