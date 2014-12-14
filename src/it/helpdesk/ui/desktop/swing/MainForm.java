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

import it.helpdesk.ui.controllers.MainFormController;
import it.helpdesk.ui.interfaces.*;
import it.helpdesk.ui.interfaces.models.ITicket;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.util.List;

/**
 * View class containing the Main form for the application containing the list of 
 * Active and Archive tickets.
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-26
 */
public class MainForm implements IMainFormView {

	private JFrame window;

	private IMainFormController controller;

	/**
	 * Contains a IMainMenu object.
	 */
	private IMainMenu mainMenu;

	/**
	 * Contains a JTable object holding a list of archived tickets.
	 */
	private JTable tableInactiveTicket;

	/**
	 * Contains a JTable object holding a list of active tickets.
	 */
	private JTable tableActiveTicket;
	
	private JButton searchButton;
	
	private JTextField searchBox;


	/**
	 * Class constructor that builds a tabbed ticket view contains active/archived tickets.
	 */
	public MainForm() {
		JPanel contentPane;

		this.window = new JFrame();

		this.window.setTitle("Helpdesk Ticket Tracker");

		this.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.window.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		//Main panel to hold window's content
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		this.window.setContentPane(contentPane);
		
		//FlowLayout layout = new FlowLayout();
		
		GridBagLayout layout = new GridBagLayout();
		contentPane.setLayout(layout);
		
		JPanel searchPanel = new JPanel();
		
		searchBox = new JTextField(15);
		searchBox.setUI(new HintTextFieldUI("Search by Ticket ID", true));
		searchPanel.add(searchBox);
		
		searchButton = new JButton("Search");
		searchPanel.add(searchButton);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		contentPane.add(searchPanel, gbc);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		contentPane.add(new JLabel(" "), gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		contentPane.add(tabbedPane, gbc);
		
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
						"ID", "Priority", "Status", "Category", "Client", "Summary", "Date Opened"
				}
				));

		tableActiveTicket.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableActiveTicket.setAutoCreateRowSorter(true);
		tableActiveTicket.setEnabled(false);

		JPanel pnlInactiveTicket = new JPanel();
		tabbedPane.addTab("Archive Tickets", null, pnlInactiveTicket, null);
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

		tableInactiveTicket.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableInactiveTicket.setAutoCreateRowSorter(true);
		tableInactiveTicket.setEnabled(false);

		this.window.pack();

		mainMenu = new MainMenu();

		this.window.setJMenuBar((JMenuBar) mainMenu);
		this.window.setLocationByPlatform(true);
	}

	/**
	 * Method to open the login window prior to displaying any ticket information.
	 */
	@Override
	public void openLoginForm() {
		this.controller.openLoginForm();
		
	}

	/**
	 * Method to display a logout message to the user.
	 */
	@Override
	public void openLogoutDialog() {
		this.controller.openLoginForm();
	}

	/**
	 * Method to open a new window in which the user can create a new ticket.
	 */
	@Override
	public void openTicketForm() {
		this.controller.openTicketForm();
	}

	/**
	 * Method to close the active window.
	 */
	@Override
	public void close() {
		this.window.dispatchEvent(new WindowEvent(this.window, WindowEvent.WINDOW_CLOSING));
	}

	@Override
	public void setController(IMainFormController controller) {
		this.controller = controller;
	}

	@Override
	public void open() {
		((MainFormController)this.controller).setApplicationParentFrame(this.window);
		((MainMenu) this.mainMenu).setController(this.controller);
		this.mainMenu.disableEditTicketMenuItem();

		this.window.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				MainForm.this.openLoginForm();
				MainForm.this.controller.loadActiveTickets();
				MainForm.this.controller.loadInactiveTickets();
			}
		});

		tableActiveTicket.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int rowNum = tableActiveTicket.rowAtPoint(e.getPoint());
				tableActiveTicket.clearSelection();
				tableActiveTicket.addRowSelectionInterval(rowNum, rowNum);

				int index = tableActiveTicket.convertRowIndexToModel(rowNum);
				// Right click or double click 
				if(SwingUtilities.isRightMouseButton(e) == true || (SwingUtilities.isLeftMouseButton(e) == true && e.getClickCount() == 2)) {
					if(index > -1){
						MainForm.this.controller.updateSelectedActiveTicketIndex(index);
						MainForm.this.mainMenu.enableEditTicketMenuItem();
				
						MainForm.this.controller.openTicketForm();
						MainForm.this.controller.clearSelectedTicket();
						MainForm.this.mainMenu.disableEditTicketMenuItem();
					}
				}
				else if (SwingUtilities.isLeftMouseButton(e)) {
					MainForm.this.controller.updateSelectedActiveTicketIndex(index);
					MainForm.this.mainMenu.enableEditTicketMenuItem();
				}
				else {
					MainForm.this.controller.clearSelectedTicket();
					MainForm.this.mainMenu.disableEditTicketMenuItem();
				}
			}
		});
		
		tableInactiveTicket.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int rowNum = tableInactiveTicket.rowAtPoint(e.getPoint());
				tableInactiveTicket.clearSelection();
				tableInactiveTicket.addRowSelectionInterval(rowNum, rowNum);

				int index = tableInactiveTicket.convertRowIndexToModel(rowNum);
				// Right click or double click 
				if(SwingUtilities.isRightMouseButton(e) == true || (SwingUtilities.isLeftMouseButton(e) == true && e.getClickCount() == 2)) {

					if(index > -1){
						MainForm.this.controller.updateSelectedInactiveTicketIndex(index);
						MainForm.this.mainMenu.enableEditTicketMenuItem();
				
						MainForm.this.controller.openTicketForm();
						MainForm.this.controller.clearSelectedTicket();
						MainForm.this.mainMenu.disableEditTicketMenuItem();
					}
				}
				else if (SwingUtilities.isLeftMouseButton(e)) {
					MainForm.this.controller.updateSelectedInactiveTicketIndex(index);
					MainForm.this.mainMenu.enableEditTicketMenuItem();
				}
				else {
					MainForm.this.controller.clearSelectedTicket();
					MainForm.this.mainMenu.disableEditTicketMenuItem();
				}
			}
		});
		
		this.searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainForm.this.controller.searchByTicket();
			}
		});
		
		this.searchBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				MainForm.this.searchButton.doClick();
			}
		});

		this.searchButton.requestFocus();
		this.window.setVisible(true);
	}

	@Override
	public void displayActiveTickets(List<ITicket> activeTickets) {
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableActiveTicket
				.getDefaultRenderer(String.class);
		renderer.setHorizontalAlignment(JLabel.RIGHT); // Format value in table
		// to right
		DefaultTableModel model = (DefaultTableModel) tableActiveTicket.getModel();

		int rowCount = model.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		int rowIndex =0;

		for (ITicket ticket : activeTickets) {
			model.addRow(new Object[] { null, null, null, null, null, null, null });

			// Updates existing row if a row already exists. If new row was created, that will be updated here. 
			model.setValueAt(String.format("%04d", ticket.getId()), rowIndex,0 );
			model.setValueAt(ticket.getPriority(), rowIndex,1 );
			model.setValueAt(ticket.getStatus(), rowIndex,2 );
			model.setValueAt(ticket.getServiceCategory(), rowIndex,3 );
			model.setValueAt(String.format("%s %s", ticket.getCustomer().getFirstName(), ticket.getCustomer().getLastName()), rowIndex,4 );
			model.setValueAt(ticket.getSummary(), rowIndex,5 );
			model.setValueAt(ticket.getOpenedOn(), rowIndex,6 );
			rowIndex++;
		}
	}

	@Override
	public void displayInactiveTickets(List<ITicket> inactiveTickets) {
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableInactiveTicket
				.getDefaultRenderer(String.class);
		renderer.setHorizontalAlignment(JLabel.RIGHT); // Format value in table
		// to right
		DefaultTableModel model = (DefaultTableModel) tableInactiveTicket.getModel();

		int rowCount = model.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		int rowIndex = 0;

		for (ITicket ticket : inactiveTickets) {
			model.addRow(new Object[] { null, null, null, null, null, null, null });

			// Updates existing row if a row already exists. If new row was created, that will be updated here. 
			model.setValueAt(String.format("%04d", ticket.getId()), rowIndex,0 );
			model.setValueAt(ticket.getPriority(), rowIndex,1 );
			model.setValueAt(ticket.getStatus(), rowIndex,2 );
			model.setValueAt(ticket.getServiceCategory(), rowIndex,3 );
			model.setValueAt(String.format("%s %s", ticket.getCustomer().getFirstName(), ticket.getCustomer().getLastName()), rowIndex,4 );
			model.setValueAt(ticket.getSummary(), rowIndex,5 );
			model.setValueAt(ticket.getOpenedOn(), rowIndex,6 );
			rowIndex++;
		}
	}

	@Override
	public String getSearchByTicketText() {
		return this.searchBox.getText();
	}
	
	@Override
	public void showDialog(String title, String message) {
		JOptionPane.showMessageDialog(this.window, message, title, JOptionPane.OK_OPTION);
	}
}
