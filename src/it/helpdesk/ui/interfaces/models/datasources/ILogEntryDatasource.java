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

import java.util.Date;

import it.helpdesk.ui.interfaces.models.ILogEntry;
import it.helpdesk.ui.interfaces.models.ITechnician;
import it.helpdesk.ui.interfaces.models.ITicket;

public interface ILogEntryDatasource {
	/**
	 * Method to retrieve log entries for the specified ticket
	 * 
	 * @param ticket
	 * @return
	 */
	public ILogEntry getLogEntryByTicket(ITicket ticket);
	
	/**
	 * Method to save log entry
	 * 
	 * @param the log entry to edit, or null for new log entry
	 * @param the date the log entry was entered
	 * @param the technician who created the log entry
	 * @param a description of the log entry
	 */
	public void saveLogEntry(ILogEntry logEntry,
							 Date dateEntered, 
							 ITechnician technician, 
							 String logEntryDescription);
}
