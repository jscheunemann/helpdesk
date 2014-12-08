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

import it.helpdesk.main.Ticket;
import it.helpdesk.main.Ticket.PriorityEnum;
import it.helpdesk.main.Ticket.ServiceCatEnum;
import it.helpdesk.main.Ticket.StatusEnum;
import it.helpdesk.ui.interfaces.ITicketFormController;
import it.helpdesk.ui.interfaces.ITicketFormView;

import java.awt.Dialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View class that allows the user to add a new ticket to the system or update
 * an existing ticket.
 * 
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-26
 */
public class AddEditTicket extends JDialog implements ITicketFormView {
	/**
	 * Variable contains static version number of the page
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Variable for the view's controller
	 */
	private ITicketFormController controller;
	
	/**
	 * Variable for the view's window
	 */
	private JDialog window;
	
	/**
	 * Variable contains a JPanel used for the content pane
	 */
	private JPanel contentPane;
	
	/**
	 * Variable contains a JTextField holding the ticket ID
	 */
	private JTextField txtFldTicketID;
	
	/**
	 * Variable contains a JTextField holding the user who opened the ticket
	 */
	private JTextField txtFldOpenedBy;
	
	/**
	 * Variable contains a JTextField holding the date the ticket was created
	 */
	private JTextField txtFldOpenedDate;
	
	/**
	 * Variable contains a JTextField holding the client's first name
	 */
	private JTextField txtFldClientFirstName;
	
	/**
	 * Variable contains a JTextField holding the client's last name
	 */
	private JTextField txtFldClientLastName;
	
	/**
	 * Variable contains a JTextField holding the client's phone number
	 */
	private JTextField txtFldClientPhone;
	
	/**
	 * Variable contains a JTextField holding the client's email address
	 */
	private JTextField txtFldClientEmail;
	
	/**
	 * Variable contains a JTextField holding the ticket summary information
	 */
	private JTextField txtFldSummary;
	
	/**
	 * Variable contains a JTextField holding the date the ticket was completed
	 */
	private JTextField txtFldComplDate;
	
	/**
	 * Variable contains a String JComboBox holding the list of priorities
	 */
	private JComboBox<String> cbBoxPriority;
	
	/**
	 * Variable contains a String JComboBox holding the list of service categories
	 */
	private JComboBox<String> cbBoxSerCategory;
	
	/**
	 * Variable contains a String JComboBox holding the list of statuses
	 */
	private JComboBox<String> cbBoxStatus;
	
	/**
	 * Variable contains a JTextArea holding the ticket history
	 */
	private JTextArea txtAreaLog;
	
	/**
	 * Variable contains a JTextArea holding the ticket update information
	 */
	private JTextArea txtAreaDescription;
	
	/**
	 * Class constructor for the Add/Edit ticket View page.
	 * 
	 * @param parent contains a JFrame object
	 * @param ticketId contains the Ticket ID of the current ticket
	 * @param newTicket contains a boolean value indicating whether this is a new ticket 
	 */
	public AddEditTicket(JFrame parent) {
		window = new JDialog(parent, "", Dialog.ModalityType.APPLICATION_MODAL);
		window.setTitle("Helpdesk Ticket Tracker");
		window.setBounds(100, 100, 687, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		window.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl1 = new JPanel();
		pnl1.setBounds(0, 58, 671, 512);
		contentPane.add(pnl1);
		pnl1.setLayout(null);
		
		JLabel lblTicketID = new JLabel("Ticket ID");
		lblTicketID.setBounds(45, 15, 76, 14);
		lblTicketID.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblTicketID);
		
		txtFldTicketID = new JTextField();
		txtFldTicketID.setEditable(false);
		txtFldTicketID.setBounds(131, 11, 515, 20);
		pnl1.add(txtFldTicketID);
		txtFldTicketID.setColumns(10);
		txtFldTicketID.setText(String.valueOf(0));
		
		JLabel lblOpenedBy = new JLabel("Opened By");
		lblOpenedBy.setBounds(33, 47, 88, 14);
		lblOpenedBy.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblOpenedBy);
		
		txtFldOpenedBy = new JTextField();
		txtFldOpenedBy.setEditable(false);
		txtFldOpenedBy.setBounds(131, 42, 203, 22);
		txtFldOpenedBy.setColumns(10);
		pnl1.add(txtFldOpenedBy);
		
		JLabel lblOpenedDate = new JLabel("Opened Date");
		lblOpenedDate.setBounds(344, 47, 88, 14);
		lblOpenedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblOpenedDate);
		
		txtFldOpenedDate = new JTextField();
		txtFldOpenedDate.setEditable(false);
		txtFldOpenedDate.setBounds(442, 43, 203, 20);
		txtFldOpenedDate.setColumns(10);
		pnl1.add(txtFldOpenedDate);
		
		JLabel lblClientFirst = new JLabel("Client First Name");
		lblClientFirst.setBounds(33, 80, 88, 14);
		lblClientFirst.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblClientFirst);
		
		txtFldClientFirstName = new JTextField();
		txtFldClientFirstName.setBounds(131, 75, 203, 20);
		txtFldClientFirstName.setColumns(10);
		pnl1.add(txtFldClientFirstName);
		
		JLabel lblClientLast = new JLabel("Last Name");
		lblClientLast.setBounds(344, 80, 88, 14);
		lblClientLast.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblClientLast);

		txtFldClientLastName = new JTextField();
		txtFldClientLastName.setBounds(442, 75, 203, 20);
		txtFldClientLastName.setColumns(10);
		pnl1.add(txtFldClientLastName);		
		
		JLabel lblClientPhone = new JLabel("Client Phone");
		lblClientPhone.setBounds(33, 109, 88, 14);
		lblClientPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblClientPhone);
		
		txtFldClientPhone = new JTextField();
		txtFldClientPhone.setBounds(131, 104, 203, 20);
		txtFldClientPhone.setColumns(10);
		pnl1.add(txtFldClientPhone);
		
		JLabel lblClientEmail = new JLabel("Client Email");
		lblClientEmail.setBounds(344, 109, 88, 14);
		lblClientEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblClientEmail);
		
		txtFldClientEmail = new JTextField();
		txtFldClientEmail.setBounds(440, 104, 206, 20);
		txtFldClientEmail.setColumns(10);
		pnl1.add(txtFldClientEmail);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setBounds(33, 140, 88, 14);
		lblSummary.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblSummary);
		
		txtFldSummary = new JTextField();
		txtFldSummary.setBounds(131, 136, 515, 20);
		txtFldSummary.setColumns(10);
		pnl1.add(txtFldSummary);
		
		JLabel lblServiceCategory = new JLabel("Service Category");
		lblServiceCategory.setBounds(2, 167, 119, 14);
		lblServiceCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblServiceCategory);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(344, 167, 88, 14);
		lblPriority.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblPriority);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(2, 202, 119, 14);
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblStatus);
		
		JLabel lblCompletedDate = new JLabel("Completed Date");
		lblCompletedDate.setBounds(331, 202, 106, 14);
		lblCompletedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblCompletedDate);
		
		txtFldComplDate = new JTextField();
		txtFldComplDate.setEditable(false);
		txtFldComplDate.setBounds(440, 198, 206, 20);
		txtFldComplDate.setColumns(10);
		pnl1.add(txtFldComplDate);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(2, 227, 119, 14);
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblDescription);
		
		
		
		cbBoxPriority = new JComboBox<String>();
		cbBoxPriority.setBounds(440, 167, 206, 20);
		pnl1.add(cbBoxPriority);
		
		JButton btnAddInformation = new JButton("Add Information");
		btnAddInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//JTextField txtLogInfo = new JTextField();
				String s = (String)JOptionPane.showInputDialog(
									AddEditTicket.this,
				                    "",
				                    "Add Information",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    null,
				                    "");

				//If a string was returned, say so.
				if ((s != null) && (s.length() > 0)) {
					DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
					// Current date + log string
					String logStr = dateFormat.format(new Date()) + " : " + s + "\n";
					txtAreaLog.append(logStr);
					return;
				}

				
			}
		});
		btnAddInformation.setBounds(131, 344, 196, 26);
		pnl1.add(btnAddInformation);
		
		cbBoxSerCategory = new JComboBox<String>();
		cbBoxSerCategory.setBounds(131, 167, 203, 20);
		pnl1.add(cbBoxSerCategory);
		
		cbBoxStatus = new JComboBox<String>();
		cbBoxStatus.setBounds(131, 198, 203, 20);
		pnl1.add(cbBoxStatus);
		
		JLabel lblLog = new JLabel("Log");
		lblLog.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLog.setBounds(66, 369, 55, 14);
		pnl1.add(lblLog);
		
				
		txtAreaLog = new JTextArea();
		txtAreaLog.setLineWrap(true);
		txtAreaLog.setToolTipText("");
		txtAreaLog.setEditable(false);
		txtAreaLog.setBounds(131, 381, 515, 130);
		pnl1.add(txtAreaLog);
		
		txtAreaDescription = new JTextArea();
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
		txtAreaDescription.setBorder(border);
		txtAreaDescription.setLineWrap(true);
		txtAreaDescription.setBounds(131, 252, 515, 92);
		pnl1.add(txtAreaDescription);
		
		
		
		JPanel pnl2 = new JPanel();
		pnl2.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnl2.setBounds(0, 568, 671, 44);
		contentPane.add(pnl2);
		pnl2.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(473, 11, 80, 26);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEditTicket.this.saveButtonPressed();
			}
		});
		pnl2.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(563, 11, 87, 26);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddEditTicket.this.dispose();
			}
			
		});
		pnl2.add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, this.getWidth(), 58);
		contentPane.add(panel);
		panel.setLayout(null);
			
		String nameLbl = "this title";
		JLabel lblCreateTicket = new JLabel(nameLbl);
		lblCreateTicket.setForeground(Color.WHITE);
		lblCreateTicket.setFont(new Font(lblCreateTicket.getName(), Font.PLAIN, lblCreateTicket.getFont().getSize() * 2));
		lblCreateTicket.setBounds(15, 15, this.getSize().width, 30);
		panel.add(lblCreateTicket);
		
		window.setLocationRelativeTo(parent);
		
		this.open();
	}

	@Override
	public void setController(ITicketFormController controller) {
		this.controller = controller;
	}

	@Override
	public void open() {
		List<String> statuses = new ArrayList<String>();
		statuses.add("New");
		statuses.add("In Progress");
		statuses.add("Wait For Process");
		statuses.add("Withdrawn");
		statuses.add("Complete");
		statuses.add("Delete");
		
		this.setStatuses(statuses);
		
		List<String> priorities = new ArrayList<String>();
		priorities.add("Low");
		priorities.add("Medium");
		priorities.add("High");
		priorities.add("Urgent");

		this.setPriorities(priorities);
		
		List<String> serviceCategories = new ArrayList<String>();
		serviceCategories.add("Access Issue");
		serviceCategories.add("Hardware");
		serviceCategories.add("Software");
		serviceCategories.add("Database");
		serviceCategories.add("Software Defect");
		serviceCategories.add("Inquity");

		this.setServiceCategories(serviceCategories);
		this.window.setVisible(true);
	}

	@Override
	public void close() {
		this.dispose();
	}

	@Override
	public void saveButtonPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelButtonPressed() {
		this.close();
	}

	@Override
	public void addInformationPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServiceCategories(List<String> categories) {
		for (String category : categories) {
			this.cbBoxSerCategory.addItem(category);
		}
	}

	@Override
	public void setPriorities(List<String> priorities) {
		for (String priority : priorities) {
			this.cbBoxPriority.addItem(priority);
		}
	}

	@Override
	public void setStatuses(List<String> statuses) {
		for (String status : statuses) {
			this.cbBoxStatus.addItem(status);
		}
	}

	@Override
	public void setSelectedServiceCategory(String selectedServiceCategory) {
		int index = 0;
		if(selectedServiceCategory.equalsIgnoreCase("Access Issue"))
			index = 0;
		else if(selectedServiceCategory.equalsIgnoreCase("Hardware"))
			index = 1;
		else if(selectedServiceCategory.equalsIgnoreCase("Software"))
			index = 2;
		else if(selectedServiceCategory.equalsIgnoreCase("Database"))
			index = 3;
		else if(selectedServiceCategory.equalsIgnoreCase("Software Defect"))
			index = 4;
		else if(selectedServiceCategory.equalsIgnoreCase("Inquity"))
			index = 5;
		this.cbBoxSerCategory.setSelectedIndex(index);
	}

	@Override
	public String getSelectedServiceCategory() {
		return this.cbBoxSerCategory.getSelectedItem().toString();
	}

	@Override
	public void setSelectedPriority(String selectedPriority) {
		int index = 0;
		if(selectedPriority.equalsIgnoreCase("Low"))
			index = 0;
		else if(selectedPriority.equalsIgnoreCase("Medium"))
			index = 1;
		else if(selectedPriority.equalsIgnoreCase("High"))
			index = 2;
		else if(selectedPriority.equalsIgnoreCase("Urgent"))
			index = 3;
		this.cbBoxPriority.setSelectedIndex(index);
		
	}

	@Override
	public String getSelectedPriority() {
		return this.cbBoxPriority.getSelectedItem().toString();
	}

	@Override
	public void setSelectedStatus(String selectedStatus) {
		int index = 0;
		if(selectedStatus.equalsIgnoreCase("New"))
			index = 0;
		else if(selectedStatus.equalsIgnoreCase("In Progress"))
			index = 1;
		else if(selectedStatus.equalsIgnoreCase("Wait For Process"))
			index = 2;
		else if(selectedStatus.equalsIgnoreCase("Withdrawn"))
			index = 3;
		else if(selectedStatus.equalsIgnoreCase("Complete"))
			index = 4;
		else if(selectedStatus.equalsIgnoreCase("Delete"))
			index = 5;
		this.cbBoxStatus.setSelectedIndex(index);		
	}

	@Override
	public String getSelectedStatus() {
		return this.cbBoxStatus.getSelectedItem().toString();
	}

	@Override
	public void setDateOpened(String dateEntered) {
		this.txtFldOpenedDate.setText(dateEntered);
	}

	@Override
	public void setClientFirstName(String clientFirstName) {
		this.txtFldClientFirstName.setText(clientFirstName);
	}

	@Override
	public String getClientFirstName() {
		return this.txtFldClientFirstName.getText();
	}

	@Override
	public void setClientLastName(String clientLastName) {
		this.txtFldClientLastName.setText(clientLastName);
	}

	@Override
	public String getClientLastName() {
		return this.txtFldClientLastName.getText();
	}

	@Override
	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.txtFldClientPhone.setText(clientPhoneNumber);
	}

	@Override
	public String getClientPhoneNumber() {
		return this.txtFldClientPhone.getText();
	}

	@Override
	public void setClientEmailAddress(String clientEmailAddress) {
		this.txtFldClientEmail.setText(clientEmailAddress);
	}

	@Override
	public String getClientEmailAddress() {
		return this.txtFldClientEmail.getText();
	}

	@Override
	public void setSummary(String summary) {
		this.txtFldSummary.setText(summary);
	}

	@Override
	public String getSummary() {
		return this.txtFldSummary.getText();
	}

	@Override
	public String getInformationToAddText() {
		return this.txtAreaDescription.getText();
	}

	@Override
	public void setLogText(String logText) {
		this.txtAreaLog.setText(logText);
	}

	@Override
	public void showValidationErrorDialog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setViewTitle(String title) {
		this.setTitle(title);
	}
}
