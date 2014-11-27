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

package it.helpdesk.ui;

import java.awt.Dialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;

/**
 * View class that allows the user to update an existing ticket.
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-26
 */
public class Gui_UpdateTicket extends JDialog {
	/**
	 * Contains the serial version number for the application.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Contains a JPanel object used as the content pane.
	 */
	private JPanel contentPane;
	
	/**
	 * Contains a JTextField object containing the ticket ID.
	 */
	private JTextField txtFldTicketID;
	
	/**
	 * Contains a JTextField object containing the name of the user who opened the ticket.
	 */
	private JTextField txtFldOpenedBy;
	
	/**
	 * Contains a JTextField object containing the date the ticket was opened.
	 */
	private JTextField txtFldOpenedDate;
	
	/**
	 * Contains a JTextField object containing the name of the client.
	 */
	private JTextField txtFldClient;
	
	/**
	 * Contains a JTextField object containing the client phone number.
	 */
	private JTextField txtFldClientPhone;
	
	/**
	 * Contains a JTextField object containing the client email.
	 */
	private JTextField txtFldClientEmail;
	
	/**
	 * Contains a JTextField object containing the summary of the ticket.
	 */
	private JTextField txtFldSummary;
	
	/**
	 * Contains a JTextField object containing the date the ticket was completed.
	 */
	private JTextField txtFldComplDate;

	/**
	 * Class constructor to build the form used to update an existing ticket in 
	 * the system.
	 * 
	 * @param parent contains a JFrame object
	 */
	public Gui_UpdateTicket(JFrame parent) {
		super(parent, "", Dialog.ModalityType.DOCUMENT_MODAL);
		setType(Type.UTILITY);
		setTitle("Helpdesk Ticket Tracker");
		setBounds(100, 100, 687, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(33, 80, 88, 14);
		lblClient.setHorizontalAlignment(SwingConstants.RIGHT);
		pnl1.add(lblClient);
		
		txtFldClient = new JTextField();
		txtFldClient.setBounds(131, 75, 515, 20);
		txtFldClient.setColumns(10);
		pnl1.add(txtFldClient);
		
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
		lblStatus.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblStatus);
		
		JLabel lblCompletedDate = new JLabel("Completed Date");
		lblCompletedDate.setBounds(331, 202, 106, 14);
		lblCompletedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompletedDate.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblCompletedDate);
		
		txtFldComplDate = new JTextField();
		txtFldComplDate.setEditable(false);
		txtFldComplDate.setBounds(440, 198, 206, 20);
		txtFldComplDate.setColumns(10);
		pnl1.add(txtFldComplDate);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(2, 227, 119, 14);
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblDescription);
		
		JComboBox<String> cbBoxPriority = new JComboBox<String>();
		cbBoxPriority.setModel(new DefaultComboBoxModel<String>(new String[] {"Low ", "Medium ", "High ", "Urgent"}));
		cbBoxPriority.setBounds(440, 167, 206, 20);
		pnl1.add(cbBoxPriority);
		
		JButton btnAddInformation = new JButton("Add Information");
		btnAddInformation.setBounds(131, 344, 196, 26);
		btnAddInformation.setFont(new Font("Courier New", Font.PLAIN, 14));
		pnl1.add(btnAddInformation);
		
		JComboBox<String> cbBoxSerCategory = new JComboBox<String>();
		cbBoxSerCategory.setModel(new DefaultComboBoxModel<String>(new String[] {"Access Issue", "Hardware", "Software", "Database", "Software Defect", "Inquiry"}));
		cbBoxSerCategory.setBounds(131, 167, 203, 20);
		pnl1.add(cbBoxSerCategory);
		
		JComboBox<String> cbBoxStatus = new JComboBox<String>();
		cbBoxStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"New ", "In Progress", "Wait for Process", "Withdrawn ", "Complete ", "Delete"}));
		cbBoxStatus.setBounds(131, 198, 203, 20);
		pnl1.add(cbBoxStatus);
		
		JLabel lblLog = new JLabel("Log");
		lblLog.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLog.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblLog.setBounds(66, 369, 55, 14);
		pnl1.add(lblLog);
		
		JTextArea txtAreaLog = new JTextArea();
		txtAreaLog.setLineWrap(true);
		txtAreaLog.setToolTipText("");
		txtAreaLog.setEditable(false);
		txtAreaLog.setBackground(SystemColor.controlHighlight);
		txtAreaLog.setBounds(131, 381, 515, 130);
		pnl1.add(txtAreaLog);
		
		JTextArea txtAreaDescription = new JTextArea();
		txtAreaDescription.setLineWrap(true);
		txtAreaDescription.setBackground(Color.WHITE);
		txtAreaDescription.setBounds(131, 240, 515, 93);
		pnl1.add(txtAreaDescription);
		
		
		
		JPanel pnl2 = new JPanel();
		pnl2.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnl2.setBounds(0, 568, 671, 44);
		contentPane.add(pnl2);
		pnl2.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnSave.setBounds(473, 11, 80, 26);
		pnl2.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnCancel.setBounds(563, 11, 87, 26);
		pnl2.add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 671, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUpdateTicket = new JLabel("Update Helpdesk Ticket ");
		lblUpdateTicket.setForeground(new Color(255, 255, 255));
		lblUpdateTicket.setFont(new Font("Courier New", Font.PLAIN, 30));
		lblUpdateTicket.setBounds(27, 27, 623, 31);
		panel.add(lblUpdateTicket);
		
		this.setLocationRelativeTo(parent);
	}
	
	/**
	 * Method to save the ticket information to the database.
	 */
	public void SaveTicket() {
		
	}
}
