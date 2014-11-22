package it.helpdesk.ui.interfaces;

public interface ILoginFormView {
	public void setController(ILoginFormController controller);
	public void open();
	public void close();
	public String getUsername();
	public String getPassword();
	public void showValidationErrorDialog();
}
