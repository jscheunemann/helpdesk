package it.helpdesk.ui.interfaces.models;

public interface ITechnician extends IPerson {
	public String getUsername();
	public void setUsername(String username);
	public String getPassword();
	public void setPassword(String password);
}
