package it.helpdesk.datasources.hibernate.datasources;

import java.util.Date;
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
		
		logEntry.setTicketId(ticket.getId());
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
}
