package it.helpdesk.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Gui_MainMenu extends JFrame {
	public Gui_MainMenu() {
		
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
		
		this.setJMenuBar(createMenu());
		this.setLocationByPlatform(true);
	}
	
	private JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem settingsMenuItem = new JMenuItem("Setting");
		fileMenu.add(settingsMenuItem);
		
		JMenuItem loginMenuItem = new JMenuItem("Login");
		loginMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		fileMenu.add(loginMenuItem);
		
		JMenu ticketMenu = new JMenu("Ticket");
		
		JMenuItem newTicketMenuItem = new JMenuItem("Add New Ticket");
		newTicketMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewTicket();
			}
		});
		ticketMenu.add(newTicketMenuItem);
		
		JMenuItem updateTicketMenuItem = new JMenuItem("Update Ticket");
		 updateTicketMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateTicket();
			}
		});
		ticketMenu.add(updateTicketMenuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(ticketMenu);
		
		return menuBar;
	}
	
	public boolean login() {
		new Gui_Login(this).setVisible(true);
		return true;
	}
	
	public void accessDB() {
		
	}
	
	public boolean createNewTicket() {
		new Gui_CreateNewTicket(this).setVisible(true);
		return true;
	}
	
	public boolean updateTicket() {
		new Gui_UpdateTicket(this).setVisible(true);
		return true;
	}
	
	public void displayActiveTickets() {
		
	}
	
	public void displayInactiveTickets() {
		
		
	}
}
