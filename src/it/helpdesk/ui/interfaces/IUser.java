package it.helpdesk.ui.interfaces;

public interface IUser {
	public long getId();
	public void setId(long id);
	public String getUsername();
	public void setUsername(String username);
	public String getPassword();
	public void setPassword(String password);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getEmailAddress();
	public void setEmailAddress(String emailAddress);
}
