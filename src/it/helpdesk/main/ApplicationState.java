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

package it.helpdesk.main;

import it.helpdesk.ui.interfaces.models.ITechnician;

public class ApplicationState {
	private ITechnician loggedInTechnician;
	private static volatile ApplicationState instance = null;
	
	private ApplicationState() {}
 
    public static ApplicationState getInstance() {
        if (instance == null) {
            synchronized (ApplicationState.class) {
                if (instance == null) {
                    instance = new ApplicationState();
                }
            }
        }
 
        return instance;
    }
	
	public void setLoggedInTechnician(ITechnician technician) {
		this.loggedInTechnician = technician;
	}
	
	public ITechnician getLoggedInTechnician() {
		return this.loggedInTechnician;
	}
}
