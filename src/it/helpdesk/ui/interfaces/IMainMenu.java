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
public interface IMainMenu {
	
	/**
	 * Method to disable the ticket menu option.
	 */
	public void disableTicketMenu();
	
	/**
	 * Method to enable the ticket menu option.
	 */
	public void enableTicketMenu();
	
	/**
	 * Method to disable the file menu option.
	 */
	public void disableFileMenu();
	
	/**
	 * Method to enable the file menu option.
	 */
	public void enableFileMenu();
	
	/**
	 * Method to diable the login menu option.
	 */
	public void disableLoginMenuItem();
	
	/**
	 * Method to enable the login menu option.
	 */
	public void enableLoginMenuItem();
	
	/**
	 * Method to disable the logout menu option.
	 */
	public void disableLogoutMenuItem();
	
	/**
	 * Method to enable the logout menu option.
	 */
	public void enableLogoutMenuItem();
}
