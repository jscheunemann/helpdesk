package it.helpdesk.ui.desktop.swing;

import javax.swing.JFrame;

import it.helpdesk.ui.interfaces.ILoginFormView;
import it.helpdesk.ui.interfaces.IUserFormView;
import it.helpdesk.ui.interfaces.IViewConfiguration;

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
	public IUserFormView getUserFormView() {
		return new UserFormView(parentWindow);
	}
}
