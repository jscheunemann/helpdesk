package it.helpdesk.ui.interfaces.models;

public interface IPerson {
	public long getId();
	public void setId(long id);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getPhoneNumber();
	public void setPhoneNumber(String phoneNumber);
	public String getEmailAddress();
	public void setEmailAddress(String emailAddress);
}
