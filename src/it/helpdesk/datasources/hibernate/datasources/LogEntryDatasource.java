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

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import it.helpdesk.datasources.hibernate.HibernateUtil;
import it.helpdesk.datasources.hibernate.models.LogEntry;
import it.helpdesk.ui.interfaces.models.ILogEntry;
import it.helpdesk.ui.interfaces.models.ITechnician;
import it.helpdesk.ui.interfaces.models.ITicket;
import it.helpdesk.ui.interfaces.models.datasources.ILogEntryDatasource;

public class LogEntryDatasource implements ILogEntryDatasource {

	@Override
	public void saveLogEntry(ILogEntry logEntry, ITicket ticket, Date dateEntered,
			ITechnician technician, String logEntryDescription) {
	
		boolean newLogEntry = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		if (logEntry == null) {
			logEntry = new LogEntry();
			newLogEntry = true;
		}
		
		logEntry.setTechnician(technician);
		logEntry.setDateEntered(dateEntered);
		logEntry.setDescriptition(logEntryDescription);
		
		session.beginTransaction();
		
		if (newLogEntry) {
			session.save(logEntry);
		}
		else {
			session.update(logEntry);
		}
	
		session.getTransaction().commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ILogEntry> getLogEntriesByTicket(ITicket ticket) {
		List<ILogEntry> logEntries = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from LogEntry where parent_id = :id");
		query.setParameter("id", ticket.getId());
		
		logEntries = (List<ILogEntry>) query.list();
		
		session.close();

		return logEntries;
	}
}
