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

import it.helpdesk.datasources.hibernate.HibernateDatasourceConfiguration;
import it.helpdesk.main.*;
import it.helpdesk.ui.controllers.LoginFormController;
import it.helpdesk.ui.interfaces.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.*;

import java.util.Collections;
import java.util.List;

/**
 * View class containing the Main form for the application containing the list of 
 * Active and Archive tickets.
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-26
 */
public class MainForm extends JFrame implements IMain {
	
	/**
	 * Contains the serial version number for the application.
	 */
	private static final long serialVersionUID = 5596361278718314710L;

	/**
	 * Contains a IDatasourceConfiguration object.
	 */
	private IDatasourceConfiguration datasourceConfiguration;
	
	/**
	 * Contains a IViewConfiguration object.
	 */
	private IViewConfiguration viewConfiguration;
	
	/**
	 * Contains a IMainMenu object.
	 */
	private IMainMenu mainMenu;
	
	/**
	 * Variables reflects whether this is the first load of the page.
	 */
	private boolean firstLoad = true;
	
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
	 * Contains a unique ticket ID to be used by the application.
	 */
	private int uniqueTicketId = 1;
	
	
	/**
	 * Class constructor that builds a tabbed ticket view contains active/archived tickets.
	 */
	public MainForm() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewConfiguration = new SwingViewConfiguration(this);
		datasourceConfiguration = new HibernateDatasourceConfiguration();
		JPanel contentPane;
		//JTable tableInactiveTicket;
		//JTable tableActiveTicket;


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
						"ID", "Priority", "Status", "Category", "Client", "Summary", "Date Opened"
				}
				));

		tableActiveTicket.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableActiveTicket.setEnabled(false);
		tableActiveTicket.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int rowNum = tableActiveTicket.rowAtPoint(e.getPoint());
				tableActiveTicket.clearSelection();
				tableActiveTicket.addRowSelectionInterval(rowNum, rowNum);
				// Right click or double click 
				if(SwingUtilities.isRightMouseButton(e) == true
						|| e.getClickCount() == 2){
					DefaultTableModel model = (DefaultTableModel) tableActiveTicket
							.getModel(); // Set value to table
					Object id = model.getValueAt(rowNum, 0);
					if(id != null){
						int ticketId = Integer.valueOf(id.toString());
						openEditTicketDialog(ticketId);
					}
				}
			}
		});
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
				updateActiveTable();
				updateInactiveTable();
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
		tableInactiveTicket.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int rowNum = tableInactiveTicket.rowAtPoint(e.getPoint());
				tableInactiveTicket.clearSelection();
				tableInactiveTicket.addRowSelectionInterval(rowNum, rowNum);
				// Right click or double click 
				if(SwingUtilities.isRightMouseButton(e) == true
						|| e.getClickCount() == 2){
					DefaultTableModel model = (DefaultTableModel) tableInactiveTicket
							.getModel(); // Set value to table
					Object id = model.getValueAt(rowNum, 0);
					if(id != null){
						int ticketId = Integer.valueOf(id.toString());
						openEditTicketDialog(ticketId);
					}
				}
			}
		});

		this.pack();

		mainMenu = new MainMenu(this);

		this.setJMenuBar((JMenuBar) mainMenu);
		this.setLocationByPlatform(true);

		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				if (firstLoad) {
					MainForm.this.openLoginDialog();
					firstLoad = false;
				}
			}
		});
	}

	/**
	 * Method used to display the active ticket in the JTable object.
	 */
	public void displayActiveTickets() {

	}

	/**
	 * Method used to display the archived ticket in the JTable object.
	 */
	public void displayInactiveTickets() {

	}

	/**
	 * Method to open the login window prior to displaying any ticket information.
	 */
	@Override
	public void openLoginDialog() {
		ILoginFormController controller = new LoginFormController(viewConfiguration, datasourceConfiguration);
		controller.openForm();
	}

	/**
	 * Method to display a logout message to the user.
	 */
	@Override
	public void openLogoutDialog() {
		// TODO Auto-generated method stub
	}

	/**
	 * Method to open a new window in which the user can create a new ticket.
	 */
	@Override
	public void openCreateNewTicketDialog() {
		AddEditTicket newTicketDialog = new AddEditTicket(this, uniqueTicketId, true);
		newTicketDialog.setVisible(true);
		Ticket newTicket = newTicketDialog.getSaveTicket();
		if(newTicket != null){
			dbInterface.addNewTicket(newTicket);
			uniqueTicketId++;
			
		}
		updateActiveTable();
		updateInactiveTable();
	}

	/**
	 * Method to open a new window in which the user can edit an existing ticket.
	 */
	@Override
	public void openEditTicketDialog(int ticketId) {
		AddEditTicket newTicketDialog = new AddEditTicket(this, ticketId, false);
		int editedTicketIdx = 0;
		List<Ticket> currentTicketList = dbInterface.queryActiveTicket();
		if(currentTicketList != null){
			for(int i = 0; i < currentTicketList.size(); i++){
				Ticket t = currentTicketList.get(i);
				if(t.getID() == ticketId){
					editedTicketIdx = i;
					newTicketDialog.displayTicketInfo(t);
					break;
				}
			}
		}
		newTicketDialog.setVisible(true);
		Ticket editTicket = newTicketDialog.getSaveTicket();
		if(editTicket != null){
			dbInterface.updateActiveTicket(editTicket);
			
		}
		updateActiveTable();
		updateInactiveTable();
	}

	/**
	 * Method to close the active window.
	 */
	@Override
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	/**
	 * Method to update the active ticket table.
	 */
	public void updateActiveTable(){
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableActiveTicket
				.getDefaultRenderer(String.class);
		renderer.setHorizontalAlignment(JLabel.RIGHT); // Format value in table
		// to right
		DefaultTableModel model = (DefaultTableModel) tableActiveTicket
				.getModel(); // Set value to table
		List<Ticket> currentTicketList = dbInterface.queryActiveTicket();

		int newSize = (int) currentTicketList.size();
		int rowIndex =0;
		while(rowIndex < newSize){  
			if(!(rowIndex < model.getRowCount())){ //Adds row if needed
				model.addRow(new Object[] { null, null, null, null, null, null, null });
			}
			// Updates existing row if a row already exists. If new row was created, that will be updated here. 
			model.setValueAt(currentTicketList.get(rowIndex).getID(), rowIndex,0 );
			model.setValueAt(currentTicketList.get(rowIndex).getPriority(), rowIndex,1 );
			model.setValueAt(currentTicketList.get(rowIndex).getStatus(), rowIndex,2 );
			model.setValueAt(currentTicketList.get(rowIndex).getServiceCat(), rowIndex,3 );
			model.setValueAt(currentTicketList.get(rowIndex).getClient(), rowIndex,4 );
			model.setValueAt(currentTicketList.get(rowIndex).getSummary(), rowIndex,5 );
			model.setValueAt(currentTicketList.get(rowIndex).getOpenedDate(), rowIndex,6 );
			rowIndex++;
		}
		
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
	 * Method to update the active ticket table.
	 */
	public void updateInactiveTable(){
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableInactiveTicket
				.getDefaultRenderer(String.class);
		renderer.setHorizontalAlignment(JLabel.RIGHT); // Format value in table
		// to right
		DefaultTableModel model = (DefaultTableModel) tableInactiveTicket
				.getModel(); // Set value to table

		List<Ticket> currentTicketList = dbInterface.queryInactiveTicket();

		int newSize = (int) currentTicketList.size();
		int rowIndex =0;
		while(rowIndex < newSize){  
			if(!(rowIndex < model.getRowCount())){ //Adds row if needed
				model.addRow(new Object[] { null, null, null, null, null, null, null });
			}
			// Updates existing row if a row already exists. If new row was created, that will be updated here. 
			model.setValueAt(currentTicketList.get(rowIndex).getID(), rowIndex,0 );
			model.setValueAt(currentTicketList.get(rowIndex).getPriority(), rowIndex,1 );
			model.setValueAt(currentTicketList.get(rowIndex).getStatus(), rowIndex,2 );
			model.setValueAt(currentTicketList.get(rowIndex).getServiceCat(), rowIndex,3 );
			model.setValueAt(currentTicketList.get(rowIndex).getClient(), rowIndex,4 );
			model.setValueAt(currentTicketList.get(rowIndex).getSummary(), rowIndex,5 );
			model.setValueAt(currentTicketList.get(rowIndex).getOpenedDate(), rowIndex,6 );
			rowIndex++;
		}
		 

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
		
		updateActiveTable();
		updateInactiveTable();
	}
}
