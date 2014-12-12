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
import it.helpdesk.ui.interfaces.models.ITechnician;
import it.helpdesk.ui.interfaces.models.datasources.ITechnicianDatasource;

/**
 * Controller class to handle the communication between the model and the view classes.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-26
 */
public class TechnicianFormController implements ITechnicianFormController {
	/**
	 * Contains an IViewConfiguration object.
	 */
	private IViewConfiguration viewConfiguration;
	
	/**
	 * Contains an IDatasourceConfiguration object.
	 */
	private IDatasourceConfiguration datasourceConfiguration;
	
	/**
	 * Contains an ITechnicianFormView object.
	 */
	private ITechnicianFormView view;
	
	/**
	 * Contains an ITechnicianDatasource object.
	 */
	private ITechnicianDatasource datasource;
	
	/**
	 * Contains an ITechnician object.
	 */
	private ITechnician technician;

	/**
	 * Constructor for the TechnicianFormController class.
	 * 
	 * @param viewConfiguration contians an IViewConfiguration object 
	 * @param datasourceConfiguration contains an IDatasourceConfiguration object
	 */
	public TechnicianFormController(IViewConfiguration viewConfiguration, IDatasourceConfiguration datasourceConfiguration) {
		this.viewConfiguration = viewConfiguration;
		this.datasourceConfiguration = datasourceConfiguration;
	}

	/**
	 * Opens the form for the ITechnicianFormView object.
	 */
	@Override
	public void openForm() {
		if (this.view == null) {
			this.view = viewConfiguration.getTechnicianFormView();
			this.view.setController(this);
		}

		if (this.datasource == null) {
			this.datasource = datasourceConfiguration.getTechnicianDatasource();
		}

		if (technician != null) {
			view.setUsername(technician.getUsername());
			view.setFirstName(technician.getFirstName());
			view.setLastName(technician.getLastName());
			view.setPhoneNumber(technician.getPhoneNumber());
			view.setEmailAddress(technician.getEmailAddress());
		}

		this.view.open();
	}

	/**
	 * Button-click event handler that saves data from the view to the datasource, and closes
	 * the form.
	 */
	@Override
	public void saveButtonPressed() {
		String errorMessage = "";
		

		if (this.view.getUsername().equals("")) 
			errorMessage += "Missing username.\n";
		else {
			ITechnician loggedInTechnician = datasource.getTechnicianByUsername(this.view.getUsername());
			if(loggedInTechnician != null)
				errorMessage += "Username already existed.\n";				
		}
	
		if (this.view.getPassword().equals("")) 
			errorMessage += "Missing password.\n";
		else if (this.view.getPassword().length() < 4)
			errorMessage += "Password need to be at least 4 characters.\n";
		else if (this.view.getPasswordConfirmation().equals(""))
			errorMessage += "Missing password confirmation. \n";
		else if	(!this.view.getPasswordConfirmation().contentEquals(this.view.getPassword())){
			System.out.println(this.view.getPasswordConfirmation());
			System.out.println(this.view.getPassword());
			errorMessage += "Confirm password does not match. \n";
		}
		if (this.view.getFirstName().equals("")) 
			errorMessage += "Missing first name.\n";

		if (this.view.getLastName().equals("")) 
			errorMessage += "Missing last name.\n";

		if (this.view.getPhoneNumber().equals("")) 
			errorMessage += "Missing phone number.\n";

		if (this.view.getEmailAddress().equals("")) 
			errorMessage += "Missing email address.\n";

		if(!errorMessage.equals("")) {
			this.view.showValidationErrorDialog("Create User Failed", errorMessage); 
		}
		else {
			this.datasource.saveTechnician(technician,
					this.view.getUsername(),
					this.view.getPassword(),
					this.view.getFirstName(),
					this.view.getLastName(),
					this.view.getPhoneNumber(),
					this.view.getEmailAddress());

			this.view.close();
			this.view = null;
		}
	}

	/**
	 * Sets the local ITechnician variable to the object passed to the method.
	 * 
	 * @param technician contains an ITechnician object
	 */
	@Override
	public void setTechnician(ITechnician technician) {
		this.technician = technician;
	}

	/**
	 * Closes the ITechnicianFormView form.
	 */
	@Override
	public void closeForm() {
		this.view.close();
	}
}
