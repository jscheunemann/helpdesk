package it.helpdesk.ui.interfaces;

public interface IUserFormView {
	public void setController(IUserFormController controller);
	public void open();
	public void close();
	public String getUsername();
	public void setUsername(String username);
	public String getPassword();
	public String getPasswordConfirmation();
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getEmailAddress();
	public void setEmailAddress(String emailAddress);
	public void showValidationErrorDialog();
}
