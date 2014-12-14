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

public interface IMainFormController {
	public void openForm();
	public void closeForm();
	public void loadActiveTickets();
	public void loadInactiveTickets();
	public void openTicketForm();
	public void openLoginForm();
	public void clearActiveTicketView();
	public void clearInactiveTicketView();
	public void updateSelectedTicket(long id);
	public void clearSelectedTicket();
	public void openCreateTicketForm();
	public void updateSelectedActiveTicketIndex(int index);
	public void updateSelectedInactiveTicketIndex(int index);
}
