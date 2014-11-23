package it.helpdesk.datasources.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import it.helpdesk.persistence.init.HibernateUtil;
import it.helpdesk.ui.interfaces.IUser;
import it.helpdesk.ui.interfaces.IUserDatasource;

public class UserDatasource implements IUserDatasource {

	@Override
	public List<IUser> getUsers() {
		List<IUser> users = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		users = (List<IUser>) session.createQuery("from User").list();
		session.close();

		return users;
	}

	@Override
	public void saveUser(IUser user, String username, String password, String firstName, String lastName, String emailAddress) {
		boolean newUser = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		if (user == null) {
			user = new User();
			newUser = true;
		}
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(emailAddress);
		
		session.beginTransaction();
		
		if (newUser) {
			session.save(user);
		}
		else {
			session.update(user);
		}
	
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public IUser getUserByUsername(String username) {
		for (IUser user : this.getUsers()) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public boolean usernameAvailable(String username) {
		boolean available = true;
		
		for (IUser user : this.getUsers()) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				available = false;
			}
		}
		
		return available;
	}

	@Override
	public boolean checkPassword(String username, String password) {
		IUser ret = null;
		
		for (IUser user : this.getUsers()) {
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

}
