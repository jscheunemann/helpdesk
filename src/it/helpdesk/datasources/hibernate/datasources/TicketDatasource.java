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

import org.hibernate.*;

import it.helpdesk.datasources.hibernate.HibernateUtil;
import it.helpdesk.ui.interfaces.models.*;
import it.helpdesk.ui.interfaces.models.datasources.ITicketDatasource;

public class TicketDatasource implements ITicketDatasource{

	@SuppressWarnings("unchecked")
	@Override
	public List<ITicket> getTickets() {
			List<ITicket> tickets = null;
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			tickets = (List<ITicket>) session.createQuery("from Ticket").list();
			session.close();

			return tickets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ITicket> getOpenTickets() {
		List<ITicket> tickets = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		tickets = (List<ITicket>) session.createQuery("from Ticket where completed_on is null").list();
		session.close();

		return tickets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ITicket> getClosedTickets() {
		List<ITicket> tickets = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		tickets = (List<ITicket>) session.createQuery("from Ticket where completed_on is not null").list();
		session.close();

		return tickets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ITicket> getTicketsByTechnician(ITechnician technician) {
		List<ITicket> tickets = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Ticket where technician_id = :id");
		query.setParameter("id", technician.getId());
		
		tickets = (List<ITicket>) query.list();
		
		session.close();

		return tickets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ITicket> getOpenTicketsByTechnician(ITechnician technician) {
		List<ITicket> tickets = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Ticket where completed_on is null and technician_id = :id");
		query.setParameter("id", technician.getId());
		
		tickets = (List<ITicket>) query.list();
		
		session.close();

		return tickets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ITicket> getClosedTicketsByTechnician(ITechnician technician) {
		List<ITicket> tickets = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Ticket where completed_on is not null and technician_id = :id");
		query.setParameter("id", technician.getId());
		
		tickets = (List<ITicket>) query.list();
		
		session.close();

		return tickets;
	}

	@Override
	public ITicket getTicketById(long id) {
		ITicket ticket = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Ticket where id = :id");
		query.setParameter("id", id);
		
		ticket = (ITicket) query.list().get(0);
		
		session.close();

		return ticket;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void saveTicket(ITicket ticket, IServiceCategory serviceCategory,
			IPriority priority, IStatus status, ITechnician technician,
			Date openedOn, Date closedOn, ICustomer customer, String summary,
			List logEntries) {
		
	}
}