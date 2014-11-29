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

package it.helpdesk.ui.interfaces;

/**
 * Controller class to handle the communication between the model and the view classes.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public interface IMain {
	
	/**
	 * Method to open the login dialog page.
	 */
	public void openLoginDialog();
	
	/**
	 * Method to open the logout dialog page.
	 */
	public void openLogoutDialog();
	
	/**
	 * Method to open the create new ticket dialog page.
	 */
	public void openCreateNewTicketDialog();
	
	/**
	 * Method to open the edit ticket dialog page.
	 * 
	 * @param ticketId contains the ticket ID of the ticket to be modified.
	 */
	public void openEditTicketDialog(int ticketId);
	
	/**
	 * Method to retrieve the number of the current row being selected on the Active ticket view.
	 * 
	 * @return the number of the current row selected on the active ticket view
	 */
	public int getActiveSelectedRow();
	
	/**
	 * Method to close the current dialog window.
	 */
	public void close();
}
