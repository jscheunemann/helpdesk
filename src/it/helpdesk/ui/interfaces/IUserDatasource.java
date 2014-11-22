package it.helpdesk.ui.interfaces;

import java.util.List;

public interface IUserDatasource {
	public List<IUser> getUsers();
	public void saveUser(IUser user, String username, String password, String firstName, String lastName, String emailAddress);
	public IUser getUserByUsername(String username);
	public boolean usernameAvailable(String username);
	public boolean checkPassword(String username, String password);
}
