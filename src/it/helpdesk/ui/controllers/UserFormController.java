package it.helpdesk.ui.controllers;

import it.helpdesk.ui.interfaces.*;

public class UserFormController implements IUserFormController {
	private IViewConfiguration viewConfiguration;
	private IDatasourceConfiguration datasourceConfiguration;
	private IUserFormView view;
	private IUserDatasource datasource;
	private IUser user;

	public UserFormController(IViewConfiguration viewConfiguration, IDatasourceConfiguration datasourceConfiguration) {
		this.viewConfiguration = viewConfiguration;
		this.datasourceConfiguration = datasourceConfiguration;
	}

	@Override
	public void openForm() {
		if (this.view == null) {
			this.view = viewConfiguration.getUserFormView();
			this.view.setController(this);
		}

		if (this.datasource == null) {
			this.datasource = datasourceConfiguration.getUserDatasource();
		}

		if (user != null) {
			view.setUsername(user.getUsername());
			view.setFirstName(user.getFirstName());
			view.setLastName(user.getLastName());
			view.setEmailAddress(user.getEmailAddress());
		}

		this.view.open();
	}

	@Override
	public void saveButtonPressed() {
		if (this.view.getFirstName().equals("") || this.view.getLastName().equals("")) {
			this.view.showValidationErrorDialog(); 
		}
		else {
			this.datasource.saveUser(user,
					this.view.getUsername(),
					this.view.getPassword(),
					this.view.getFirstName(), 
					this.view.getLastName(),
					this.view.getEmailAddress());

			this.view.close();
			this.view = null;
		}
	}

	@Override
	public void setUser(IUser user) {
		this.user = user;
	}

	@Override
	public void closeForm() {
		this.view.close();
	}
}
