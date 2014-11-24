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

package it.helpdesk.ui.interfaces.models;

import java.util.Date;

public interface ITicket {
	public long getId();
	public void setId(long id);
	public IServiceCategory getServiceCategory();
	public void setServiceCategory(IServiceCategory serviceCategory);
	public IStatus getStatus();
	public void setStatus(IStatus status);
	public IOperator getOperator();
	public void setOperator(IOperator operator);
	public ITechnician getAssignedTo();
	public void setAssignedTo(ITechnician assignedTo);
	public Date getOpenedOn();
	public void setOpenedOn(Date openedOn);
	public Date getCompletedOn();
	public void setCompletedOn(Date completedOn);
}
