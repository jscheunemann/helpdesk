package it.helpdesk.datasources.memory;

import java.util.*;

import it.helpdesk.ui.interfaces.*;

public class UserDatasource implements IUserDatasource {
	private List<IUser> users = null;
	
	public UserDatasource() {
		users = new Vector<IUser>();
	}
	
	@Override
	public List<IUser> getUsers() {
		return (List<IUser>) this.users;
	}

	@Override
	public void saveUser(IUser user, String username, String password, String firstName, String lastName, String emailAddress) {
		long id = 1;

		if (user == null) {
			user = new User();
		}
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(emailAddress);

		if (!(user.getId() > 0)) {
			users.add(new User(++id, username, password, firstName, lastName, emailAddress));
		}
	}

	@Override
	public IUser getUserByUsername(String username) {
		IUser ret = null;
		for (IUser user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				ret = user;
			}
		}
		
		return ret;
	}

	@Override
	public boolean checkPassword(String username, String password) {
		System.out.println("The password is " + password);
		IUser ret = null;
		
		for (IUser user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				ret = user;
			}
		}
		
		if (ret != null) {
			return (ret.getPassword().equals(password));
		}
		else {
			return false;
		}
	}

	@Override
	public boolean usernameAvailable(String username) {
		boolean usernameExists = false;
		
		for (IUser user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				usernameExists = true;
			}
		}
		
		return usernameExists;
	}
}
