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

import it.helpdesk.main.*;
import it.helpdesk.ui.controllers.MainFormController;
import it.helpdesk.ui.interfaces.*;
import it.helpdesk.ui.interfaces.models.ITicket;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
	 * Contains a DBInterface object.
	 */
	private DBInterface dbInterface = new DBInterface();

	/**
	 * Contains a JTable object holding a list of archived tickets.
	 */
	private JTable tableInactiveTicket;

	/**
	 * Contains a JTable object holding a list of active tickets.
	 */
	private JTable tableActiveTicket;


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
						"ID", "Priority", "Status", "Category", "Client", "Summary", "Date Opened"
				}
				));

		tableActiveTicket.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableActiveTicket.setEnabled(false);
		
		JTableHeader activeHeader = tableActiveTicket.getTableHeader();
		activeHeader.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int colNum = tableActiveTicket.columnAtPoint(e.getPoint());
				System.out.println(colNum);
				sortTable(colNum, true);
			}
		});

		JPanel pnlInactiveTicket = new JPanel();
		tabbedPane.addTab("Archive Tickets", null, pnlInactiveTicket, null);
		pnlInactiveTicket.setLayout(layout);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event){
//				updateActiveTable();
//				updateInactiveTable();
			}
		});

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

	/**
	 * Method to grab the selected ticket ID and return it to the calling method.
	 * 
	 * @return ID for the currently selected ticket
	 */
	public int getActiveSelectedRow() {
		int selectedRow = tableActiveTicket.getSelectedRow();
		return Integer.valueOf(tableActiveTicket.getValueAt(selectedRow, 0).toString());
	}


	/**
	 * Method to grab the selected ticket ID and return it to the calling method.
	 * 
	 * @return ID for the currently selected ticket
	 */
	public int getInactiveSelectedRow() {
		int selectedRow = tableInactiveTicket.getSelectedRow();
		return Integer.valueOf(tableInactiveTicket.getValueAt(selectedRow, 0).toString());
	}

	/**
	 * Method to sort the view of active ticket list.
	 * 
	 */
	public void sortTable(int column, boolean active) {
		switch(column){
		case 0:
			dbInterface.sortByID(active);
			break;
		case 1:
			dbInterface.sortByPriority(active);
			break;
		case 2:
			dbInterface.sortByStatus(active);
			break;
		case 3:
			dbInterface.sortByCategory(active);
			break;
		case 4:
			dbInterface.sortByClient(active);
			break;
		case 6:
			dbInterface.sortByOpenedDate(active);
			break;
		}
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
				// Right click or double click 
				if(SwingUtilities.isRightMouseButton(e) == true || e.getClickCount() == 2) {
					DefaultTableModel model = (DefaultTableModel) tableActiveTicket.getModel(); // Set value to table
					Object id = model.getValueAt(rowNum, 0);
					if(id != null){
						MainForm.this.controller.updateSelectedTicket((Long) id);
						MainForm.this.mainMenu.enableEditTicketMenuItem();

						MainForm.this.controller.openTicketForm();
					}
				}
				else if (SwingUtilities.isLeftMouseButton(e) == true) {
					DefaultTableModel model = (DefaultTableModel) tableActiveTicket.getModel(); // Set value to table
					Object id = model.getValueAt(rowNum, 0);
					
					if(id != null){
						MainForm.this.controller.updateSelectedTicket((Long) id);
						MainForm.this.mainMenu.enableEditTicketMenuItem();
					}
				}
				else {
					MainForm.this.controller.clearSelectedTicket();
					MainForm.this.mainMenu.disableEditTicketMenuItem();
				}
			}
		});

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
			model.setValueAt(ticket.getId(), rowIndex,0 );
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
			model.setValueAt(ticket.getId(), rowIndex,0 );
			model.setValueAt(ticket.getPriority(), rowIndex,1 );
			model.setValueAt(ticket.getStatus(), rowIndex,2 );
			model.setValueAt(ticket.getServiceCategory(), rowIndex,3 );
			model.setValueAt(String.format("%s %s", ticket.getCustomer().getFirstName(), ticket.getCustomer().getLastName()), rowIndex,4 );
			model.setValueAt(ticket.getSummary(), rowIndex,5 );
			model.setValueAt(ticket.getOpenedOn(), rowIndex,6 );
			rowIndex++;
		}
	}
}
