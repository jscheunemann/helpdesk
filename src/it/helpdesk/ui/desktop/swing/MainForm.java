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
import javax.swing.table.*;

import java.util.List;

public class MainForm extends JFrame implements IMain {
	private static final long serialVersionUID = 5596361278718314710L;

	private IDatasourceConfiguration datasourceConfiguration;
	private IViewConfiguration viewConfiguration;
	private IMainMenu mainMenu;
	private boolean firstLoad = true;
	private DBInterface dbInterface = new DBInterface();
	private JTable tableInactiveTicket;
	private JTable tableActiveTicket;

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
					MainForm.this.openLoginDialog();
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
		ILoginFormController controller = new LoginFormController(viewConfiguration, datasourceConfiguration);
		controller.openForm();
	}

	@Override
	public void openLogoutDialog() {
		// TODO Auto-generated method stub
	}

	@Override
	public void openCreateNewTicketDialog() {
		AddEditTicket newTicketDialog = new AddEditTicket(this);
		newTicketDialog.setVisible(true);
		Ticket newTicket = newTicketDialog.getNewTicket();
		if(newTicket != null){
			dbInterface.addNewTicket(newTicket);

			updateActiveTable();
		}
	}

	@Override
	public void openEditTicketDialog() {
		AddEditTicket newTicketDialog = new AddEditTicket(this);

		List<Ticket> currentTicketList = dbInterface.queryActiveTicket();

		newTicketDialog.displayTicketInfo(currentTicketList.get(0));

		newTicketDialog.setVisible(true);

	}


	@Override
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	public void updateActiveTable(){
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableActiveTicket
				.getDefaultRenderer(String.class);
		renderer.setHorizontalAlignment(JLabel.RIGHT); // Format value in table
		// to right
		DefaultTableModel model = (DefaultTableModel) tableActiveTicket
				.getModel(); // Set value to table

		List<Ticket> currentTicketList = dbInterface.queryActiveTicket();

		int a = model.getRowCount();
		int b = (int) currentTicketList.size();

		if (a < b) {
			for (int i = 0; i < (b - a); i++)
				model.addRow(new Object[] { null, null, null, null, null, null, null }); // Add
			// more
			// rows
		}

		for (int i = 0; i < a; i++) { // Clear table

			model.setValueAt("", i, 0);
			model.setValueAt("", i, 1);
			model.setValueAt("", i, 2);
			model.setValueAt("", i, 3);
			model.setValueAt("", i, 4);
			model.setValueAt("", i, 5);
		}

		if (b > 0) {

			for (int i = 0; i < b; i++) { // UPdate values into table

				model.setValueAt(currentTicketList.get(i).getID(), i,0 );
				model.setValueAt(currentTicketList.get(i).getPriority(), i,1 );
				model.setValueAt(currentTicketList.get(i).getStatus(), i,2 );
				model.setValueAt(currentTicketList.get(i).getServiceCat(), i,3 );
				model.setValueAt(currentTicketList.get(i).getClient(), i,4 );
				model.setValueAt(currentTicketList.get(i).getSummary(), i,5 );
				model.setValueAt(currentTicketList.get(i).getOpenedDate(), i,6 );

			}
		}
	}
}
