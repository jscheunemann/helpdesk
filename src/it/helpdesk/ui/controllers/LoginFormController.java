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
