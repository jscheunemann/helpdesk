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

package it.helpdesk.ui.desktop.swing;

import javax.swing.JFrame;

import it.helpdesk.ui.interfaces.*;

public class SwingViewConfiguration implements IViewConfiguration {
	JFrame parentWindow;
	
	public SwingViewConfiguration(JFrame parentWindow) {
		this.parentWindow = parentWindow;
	}
	
	@Override
	public ILoginFormView getLoginFormView() {
		return new LoginFormView(parentWindow);
	}

	@Override
	public ITechnicianFormView getTechnicianFormView() {
		return new TechnicianFormView(parentWindow);
	}
}
