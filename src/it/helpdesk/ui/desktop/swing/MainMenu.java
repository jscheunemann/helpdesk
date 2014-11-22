package it.helpdesk.ui.desktop.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import it.helpdesk.ui.interfaces.IMain;
import it.helpdesk.ui.interfaces.IMainMenu;

public class MainMenu extends JMenuBar implements IMainMenu {
	private IMain parentWindow;
	private JMenu fileMenu;
	private JMenu ticketMenu;
	private JMenuItem logoutMenuItem;
	private JMenuItem loginMenuItem;
	private JMenuItem exitMenuItem;

	public MainMenu(IMain parentWindow) {
		this.parentWindow = parentWindow;
		fileMenu = new JMenu("File");

		JMenuItem settingsMenuItem = new JMenuItem("Setting");
		fileMenu.add(settingsMenuItem);
		
		fileMenu.add(new JSeparator());

		loginMenuItem = new JMenuItem("Login");
		
		loginMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.parentWindow.openLoginDialog();
			}
		});
		
		fileMenu.add(loginMenuItem);
		
		logoutMenuItem = new JMenuItem("Logout"); 
		
		logoutMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: Implement Logout Dialog
			}
		});
		
		fileMenu.add(logoutMenuItem);
		
		fileMenu.add(new JSeparator());
		
		exitMenuItem = new JMenuItem("Exit"); 
		
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.parentWindow.close();
			}
		});
		
		fileMenu.add(exitMenuItem);

		ticketMenu = new JMenu("Ticket");

		JMenuItem newTicketMenuItem = new JMenuItem("Add New Ticket");

		newTicketMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.this.parentWindow.openCreateNewTicketDialog();
				
			}
		});
		ticketMenu.add(newTicketMenuItem);

		JMenuItem updateTicketMenuItem = new JMenuItem("Update Ticket");
		
		updateTicketMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.this.parentWindow.openEditTicketDialog();
			}
		});
		ticketMenu.add(updateTicketMenuItem);

		this.add(fileMenu);
		this.add(ticketMenu);
	}

	@Override
	public void disableTicketMenu() {
		this.ticketMenu.setEnabled(false);
	}

	@Override
	public void enableTicketMenu() {
		this.ticketMenu.setEnabled(true);
	}
	
		@Override
	public void disableFileMenu() {
		for (Component c : this.fileMenu.getMenuComponents()) {
			c.setEnabled(false);
		}
		this.exitMenuItem.setEnabled(true);
	}

	@Override
	public void enableFileMenu() {
		for (Component c : this.fileMenu.getMenuComponents()) {
			c.setEnabled(true);
		}
	}

	@Override
	public void disableLoginMenuItem() {
		this.loginMenuItem.setEnabled(false);
	}

	@Override
	public void enableLoginMenuItem() {
		this.loginMenuItem.setEnabled(true);
	}

	@Override
	public void disableLogoutMenuItem() {
		this.logoutMenuItem.setEnabled(false);
	}

	@Override
	public void enableLogoutMenuItem() {
		this.logoutMenuItem.setEnabled(true);
	}
}
