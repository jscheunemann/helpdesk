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

import it.helpdesk.main.ApplicationState;
import it.helpdesk.ui.interfaces.*;
import it.helpdesk.ui.interfaces.models.ITechnician;
import it.helpdesk.ui.interfaces.models.datasources.*;

/**
 * Controller class to handle the communication between the model and the view classes.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-26
 */
public class LoginFormController implements ILoginFormController {
	/**
	 * Contains an IViewConfiguration object.
	 */
	private IViewConfiguration viewConfiguration;

	/**
	 * Contains an IDatasourceConfiguration object.
	 */
	private IDatasourceConfiguration datasourceConfiguration;

	/**
	 * Contains an ITechnicianDatasource object.
	 */
	private ILoginFormView view;

	/**
	 * Contains an ITechnicianDatasource object.
	 */
	private ITechnicianDatasource datasource;

	/**
	 * Contains logged in technician
	 */
	private ITechnician loggedInTechnician;

	/**
	 * Constructor for the LoginFormController class.
	 * 
	 * @param viewConfiguration contains IViewConfiguration object
	 * @param datasourceConfiguration contains IDatasourceConfiguration object 
	 */
	public LoginFormController(IViewConfiguration viewConfiguration, IDatasourceConfiguration datasourceConfiguration) {
		this.viewConfiguration = viewConfiguration;
		this.datasourceConfiguration = datasourceConfiguration;
		this.view = viewConfiguration.getLoginFormView();
		this.view.setController(this);
		this.datasource = datasourceConfiguration.getTechnicianDatasource();
	}

	/**
	 * Opens the form for the ILoginFormView object.
	 */
	@Override
	public void openForm() {
		view.open();
	}

	/**
	 * Closes the form for the ILoginFormView object.
	 */
	@Override
	public void closeForm() {
		if (this.loggedInTechnician == null) {
			System.exit(0);
		}
		else {
			this.view.close();
		}
	}

	/**
	 * Validates the password provided by the user for the ILoginFormView object.
	 */
	@Override
	public void requestAuthentication() {
		if (this.view.getUsername().equals("") || this.view.getPassword().equals("")) {
			this.view.showValidationErrorDialog("Invalid Credentials", "Unable to verify credentials");
		}
		else if (datasource.checkPassword(view.getUsername(), view.getPassword())) {
			ApplicationState.getInstance().setLoggedInTechnician(this.loggedInTechnician = datasource.getTechnicianByUsername(this.view.getUsername()));
			this.closeForm();
		}
		else {
			this.view.showValidationErrorDialog("Invalid Credentials", "Unable to verify credentials");
		}
	}

	/**
	 * Opens the form for the ITechnicianFormController object.
	 */
	@Override
	public void openCreateUserForm() {
		ITechnicianFormController controller = new TechnicianFormController(viewConfiguration, datasourceConfiguration);
		controller.openForm();
	}
}
