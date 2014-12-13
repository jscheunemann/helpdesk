/*
 * 
 * Copyright (C) 2014  Helpdesk Tracker Group, Fall Semester, UMUC
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 */

package it.helpdesk.ui.desktop.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import it.helpdesk.ui.interfaces.IMainFormController;
import it.helpdesk.ui.interfaces.IMainMenu;

/**
 * View class that controls the main menu toolbar for the application.
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-26
 */
public class MainMenu extends JMenuBar implements IMainMenu {
	
	/**
	 * Contains the serial version number for the application.
	 */
	private static final long serialVersionUID = 6380669857111206438L;
	
	/**
	 * Contains an IMain object.
	 */
	private IMainFormController controller;
	
	/**
	 * Contains a JMenu object containing the file menu.
	 */
	private JMenu fileMenu;
	
	/**
	 * Contains a JMenu object containing the ticket menu.
	 */
	private JMenu ticketMenu;
	
	/**
	 * Contains a JMenuItem object to allow the user to logout.
	 */
	private JMenuItem logoutMenuItem;
	
	/**
	 * Contains a JMenuItem object to allow the user to login.
	 */
	private JMenuItem loginMenuItem;
	
	/**
	 * Contains a JMenuItem object to allow the user to exit the application.
	 */
	private JMenuItem exitMenuItem;
	
	private JMenuItem newTicketMenuItem;
	
	private JMenuItem updateTicketMenuItem;

	/**
	 * Class constructor to build the main menu toolbar and the available options.
	 * 
	 * @param parentWindow a reference to the IMain parent object
	 */
	public MainMenu() {
		fileMenu = new JMenu("File");

		JMenuItem settingsMenuItem = new JMenuItem("Setting");
		fileMenu.add(settingsMenuItem);
		
		fileMenu.add(new JSeparator());

		loginMenuItem = new JMenuItem("Login");
		
		fileMenu.add(loginMenuItem);
		
		logoutMenuItem = new JMenuItem("Logout"); 
		
		fileMenu.add(logoutMenuItem);
		
		fileMenu.add(new JSeparator());
		
		exitMenuItem = new JMenuItem("Exit"); 
		
		fileMenu.add(exitMenuItem);

		ticketMenu = new JMenu("Ticket");

		newTicketMenuItem = new JMenuItem("Add New Ticket");

		ticketMenu.add(newTicketMenuItem);

		updateTicketMenuItem = new JMenuItem("Update Ticket");
		
		ticketMenu.add(updateTicketMenuItem);

		this.add(fileMenu);
		this.add(ticketMenu);
	}

	/**
	 * Method that will disable the ticket menu option.
	 */
	@Override
	public void disableTicketMenu() {
		this.ticketMenu.setEnabled(false);
	}

	/**
	 * Method that will enable the ticket menu option.
	 */
	@Override
	public void enableTicketMenu() {
		this.ticketMenu.setEnabled(true);
	}
	
	/**
	 * Method that will disable the file menu option.
	 */
	@Override
	public void disableFileMenu() {
		for (Component c : this.fileMenu.getMenuComponents()) {
			c.setEnabled(false);
		}
		this.exitMenuItem.setEnabled(true);
	}

	/**
	 * Method that will enable the file menu option.
	 */
	@Override
	public void enableFileMenu() {
		for (Component c : this.fileMenu.getMenuComponents()) {
			c.setEnabled(true);
		}
	}

	/**
	 * Method that will disable the login menu item.
	 */
	@Override
	public void disableLoginMenuItem() {
		this.loginMenuItem.setEnabled(false);
	}

	/**
	 * Method that will enable the login menu item.
	 */
	@Override
	public void enableLoginMenuItem() {
		this.loginMenuItem.setEnabled(true);
	}

	/**
	 * Method that will disable the logout menu item.
	 */
	@Override
	public void disableLogoutMenuItem() {
		this.logoutMenuItem.setEnabled(false);
	}

	/**
	 * Method that will enable the logout menu item.
	 */
	@Override
	public void enableLogoutMenuItem() {
		this.logoutMenuItem.setEnabled(true);
	}
	
	public void setController(IMainFormController controller) {
		this.controller = controller;
		
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.controller.closeForm();
			}
		});
		
		loginMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.controller.clearActiveTicketView();
				MainMenu.this.controller.clearInactiveTicketView();
				MainMenu.this.controller.openLoginForm();
				MainMenu.this.controller.loadActiveTickets();
				MainMenu.this.controller.loadInactiveTickets();
			}
		});
		
		logoutMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.controller.clearActiveTicketView();
				MainMenu.this.controller.clearInactiveTicketView();
				MainMenu.this.controller.openLoginForm();
				MainMenu.this.controller.loadActiveTickets();
				MainMenu.this.controller.loadInactiveTickets();
			}
		});
		
		newTicketMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.this.controller.openCreateTicketForm();
			}
		});
		
		updateTicketMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.this.controller.openTicketForm();
			}
		});
	}

	@Override
	public void disableEditTicketMenuItem() {
		this.updateTicketMenuItem.setEnabled(false);
	}

	@Override
	public void enableEditTicketMenuItem() {
		this.updateTicketMenuItem.setEnabled(true);
	}
}
