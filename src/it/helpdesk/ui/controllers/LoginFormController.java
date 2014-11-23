/*
 * Copyright (C) 2014  Helpdesk Tracker Group, Fall Semester, UMUC
 * 
 * This software is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 */

package it.helpdesk.ui.controllers;

import it.helpdesk.ui.interfaces.*;

public class LoginFormController implements ILoginFormController {
	private IViewConfiguration viewConfiguration;
	private IDatasourceConfiguration datasourceConfiguration;
	private ILoginFormView view;
	private IUserDatasource datasource;
	
	public LoginFormController(IViewConfiguration viewConfiguration, IDatasourceConfiguration datasourceConfiguration) {
		this.viewConfiguration = viewConfiguration;
		this.datasourceConfiguration = datasourceConfiguration;
		this.view = viewConfiguration.getLoginFormView();
		this.view.setController(this);
		this.datasource = datasourceConfiguration.getUserDatasource();
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
		IUserFormController controller = new UserFormController(viewConfiguration, datasourceConfiguration);
		controller.openForm();
	}
}
