package it.helpdesk.ui.desktop.swing;

import javax.swing.JFrame;

import it.helpdesk.ui.interfaces.ILoginFormView;
import it.helpdesk.ui.interfaces.IUserFormView;
import it.helpdesk.ui.interfaces.IViewConfiguration;

public class SwingViewConfiguration implements IViewConfiguration {
	ILoginFormView loginFormView;
	IUserFormView userFormView;
	JFrame parentWindow;
	
	public SwingViewConfiguration(JFrame parentWindow) {
		this.loginFormView = new LoginFormView(parentWindow);
		this.userFormView = new UserFormView(parentWindow);
	}
	
	@Override
	public ILoginFormView getLoginFormView() {
		return this.loginFormView;
	}

	@Override
	public IUserFormView getUserFormView() {
		return this.userFormView;
	}
}
