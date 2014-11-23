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

package it.helpdesk.ui.controllers;

import it.helpdesk.ui.interfaces.*;
import it.helpdesk.ui.interfaces.models.datasources.*;

public class LoginFormController implements ILoginFormController {
	private IViewConfiguration viewConfiguration;
	private IDatasourceConfiguration datasourceConfiguration;
	private ILoginFormView view;
	private ITechnicianDatasource datasource;
	
	public LoginFormController(IViewConfiguration viewConfiguration, IDatasourceConfiguration datasourceConfiguration) {
		this.viewConfiguration = viewConfiguration;
		this.datasourceConfiguration = datasourceConfiguration;
		this.view = viewConfiguration.getLoginFormView();
		this.view.setController(this);
		this.datasource = datasourceConfiguration.getTechnicianDatasource();
	}

	@Override
	public void openForm() {
		view.open();
	}

	@Override
	public void closeForm() {
		view.close();
	}

	@Override
	public void requestAuthentication() {
		if (datasource.checkPassword(view.getUsername(), view.getPassword())) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
	}

	@Override
	public void openCreateUserForm() {
		ITechnicianFormController controller = new TechnicianFormController(viewConfiguration, datasourceConfiguration);
		controller.openForm();
	}
}
