package it.helpdesk.ui.desktop.swing;

import it.helpdesk.main.DBInterface;
import it.helpdesk.main.Ticket;
import it.helpdesk.ui.interfaces.IMain;
import it.helpdesk.ui.interfaces.IMainMenu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Main extends JFrame implements IMain {
	private IMainMenu mainMenu;
	private boolean firstLoad = true;
	DBInterface dbInterface = new DBInterface();

	public Main() {

		JPanel contentPane;
		JTable tableInactiveTicket;
		JTable tableActiveTicket;

		
		//Set graphical elements
		setTitle("Helpdesk Ticket Tracker");

		//Main panel to hold window's content
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		setContentPane(contentPane);
		FlowLayout layout = new FlowLayout();
		contentPane.setLayout(layout);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		JPanel pnlActiveTicket = new JPanel();
		tabbedPane.addTab("Active Tickets", null, pnlActiveTicket, null);
		pnlActiveTicket.setLayout(layout);

		JScrollPane scrollPane_1 = new JScrollPane();
		pnlActiveTicket.add(scrollPane_1);

		tableActiveTicket = new JTable();
		scrollPane_1.setViewportView(tableActiveTicket);
		tableActiveTicket.setModel(new DefaultTableModel(
				new Object[][] {
						{},
				},

				new String[] {
						"ID", "Priority", "Status", "Category", "Client", "Summary", "Data Opened"
				}
				));

		JPanel pnlInactiveTicket = new JPanel();
		tabbedPane.addTab("Inactive Tickets", null, pnlInactiveTicket, null);
		pnlInactiveTicket.setLayout(layout);

		JScrollPane scrollPane = new JScrollPane();
		pnlInactiveTicket.add(scrollPane);

		tableInactiveTicket = new JTable();
		scrollPane.setViewportView(tableInactiveTicket);
		tableInactiveTicket.setModel(new DefaultTableModel(
				new Object[][] {
						{},
				},
				new String[] {
						"ID", "Priority", "Status", "Category", "Client", "Summary", "Date Opened"
				}
				));

		this.pack();

		mainMenu = new MainMenu(this);

		this.setJMenuBar((JMenuBar) mainMenu);
		this.setLocationByPlatform(true);

		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				if (firstLoad) {
					Main.this.openLoginDialog();
					firstLoad = false;
				}
			}
		});
	}

	public void displayActiveTickets() {

	}

	public void displayInactiveTickets() {

	}

	@Override
	public void openLoginDialog() {
		new Login(this).setVisible(true);
	}

	@Override
	public void openLogoutDialog() {
		// TODO Auto-generated method stub
	}

	@Override
	public void openCreateNewTicketDialog() {
		//new AddEditTicket(this).setVisible(true);
		AddEditTicket newTicketDialog = new AddEditTicket(this);
		newTicketDialog.setVisible(true);
		Ticket newTicket = newTicketDialog.getNewTicket();
		if(newTicket != null){
			dbInterface.addNewTicket(newTicket);
			// Testing to make sure new ticket data is correct
			System.out.println("ID: " + newTicket.getID());
			System.out.println("OpenedBy: " + newTicket.getOpenedBy());
			System.out.println("OpenDate: " + newTicket.getOpenedDate());
			System.out.println("Client: " + newTicket.getClient());
			System.out.println("Client Email: " + newTicket.getClientEmail());
			System.out.println("Client Phone: " + newTicket.getClientPhone());
			System.out.println("Priority: " + newTicket.getPriority());
			System.out.println("Service Category: " + newTicket.getServiceCat());
			System.out.println("Status: " + newTicket.getStatus());
			System.out.println("Summary: " + newTicket.getSummary());
			System.out.println("Description: " + newTicket.getDescription());
			System.out.println("Log: " + newTicket.getLog());

		}
		
	}

	@Override
	public void openEditTicketDialog() {
		new AddEditTicket(this).setVisible(true);
	}

	@Override
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
