package it.helpdesk.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Gui_MainMenu extends JFrame {

	private JPanel contentPane;
	private JTable tableInactiveTicket;
	private JTable tableActiveTicket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_MainMenu frame = new Gui_MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_MainMenu() {
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("Helpdesk Ticket Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 633, 28);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Courier New", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Setting");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu MainMenu = new JMenu("Ticket");
		MainMenu.setFont(new Font("Courier New", Font.PLAIN, 12));
		menuBar.add(MainMenu);
		
		JMenuItem mntmAddNewTicket = new JMenuItem("Add New Ticket");
		mntmAddNewTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Gui_CreateNewTicket newTicket = new Gui_CreateNewTicket();
			}
		});
		MainMenu.add(mntmAddNewTicket);
		
		JMenuItem mntmUpdateTicket = new JMenuItem("Update Ticket");
		MainMenu.add(mntmUpdateTicket);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 28, 633, 457);
		contentPane.add(tabbedPane);
		
		JPanel pnlInactiveTicket = new JPanel();
		tabbedPane.addTab("Inactive Ticket", null, pnlInactiveTicket, null);
		pnlInactiveTicket.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 42, 469, 320);
		pnlInactiveTicket.add(scrollPane);
		
		tableInactiveTicket = new JTable();
		scrollPane.setViewportView(tableInactiveTicket);
		tableInactiveTicket.setFont(new Font("Courier New", Font.PLAIN, 12));
		tableInactiveTicket.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Priority", "Status", "Category", "Client", "Summary", "Date Opened"
			}
		));
		
		JPanel pnlActiveTicket = new JPanel();
		tabbedPane.addTab("Active Ticket", null, pnlActiveTicket, null);
		pnlActiveTicket.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(62, 36, 470, 316);
		pnlActiveTicket.add(scrollPane_1);
		
		tableActiveTicket = new JTable();
		scrollPane_1.setViewportView(tableActiveTicket);
		tableActiveTicket.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, " "},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Priority", "Status", "Category", "Client", "Summary", "Data Opened"
			}
		));
		tableActiveTicket.getColumnModel().getColumn(6).setPreferredWidth(100);
		tableInactiveTicket.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		
	}
	
	public boolean createNewTicket() {
		Gui_CreateNewTicket newTicket = new Gui_CreateNewTicket();
		return true;
	}
	
	public boolean updateTicket() {
		return true;
	}
	
	public void displayActiveTickets() {
		List<Ticket> activeTicketList = new ArrayList<Ticket>();
	}
	
	public void displayInactiveTickets() {
		List<Ticket> inActiveTicketList = new ArrayList<Ticket>();
		
	}
}
