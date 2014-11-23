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

import java.awt.Dialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

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
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddEditTicket extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtFldTicketID;
	private JTextField txtFldOpenedBy;
	private JTextField txtFldOpenedDate;
	private JTextField txtFldClient;
	private JTextField txtFldClientPhone;
	private JTextField txtFldClientEmail;
	private JTextField txtFldSummary;
	private JTextField txtFldComplDate;
	
	private JComboBox<String> cbBoxPriority;
	private JComboBox<String> cbBoxSerCategory;
	private JComboBox<String> cbBoxStatus;
	
	private JTextArea txtAreaLog;
	private JTextArea txtAreaDescription;

	private Ticket newTicket;
	
	public AddEditTicket(JFrame parent, boolean newTicket) {
		super(parent, "", Dialog.ModalityType.DOCUMENT_MODAL);
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
		cbBoxPriority.setModel(new DefaultComboBoxModel<String>(new String[] {"Low ", "Medium ", "High ", "Urgent"}));
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
		cbBoxSerCategory.setModel(new DefaultComboBoxModel<String>(new String[] {"Access Issue", "Hardware", "Software", "Database", "Software Defect", "Inquiry"}));
		cbBoxSerCategory.setBounds(131, 167, 203, 20);
		pnl1.add(cbBoxSerCategory);
		
		cbBoxStatus = new JComboBox<String>();
		cbBoxStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"New ", "In Progress", "Wait for Process", "Withdrawn ", "Complete ", "Delete"}));
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
		txtAreaDescription.setLineWrap(true);
		txtAreaDescription.setBounds(131, 252, 515, 93);
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
				saveTicket();
				AddEditTicket.this.dispose();
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
		
		String nameLbl;
		if(newTicket)
			nameLbl = "New Helpdesk Ticket ";
		else
			nameLbl = "Update Helpdesk Ticket ";
			
		JLabel lblCreateTicket = new JLabel(nameLbl);
		lblCreateTicket.setForeground(Color.WHITE);
		lblCreateTicket.setFont(new Font(lblCreateTicket.getName(), Font.PLAIN, lblCreateTicket.getFont().getSize() * 2));
		lblCreateTicket.setBounds(15, 15, this.getSize().width, 30);
		panel.add(lblCreateTicket);
		
		this.setLocationRelativeTo(parent);
	}
	
	public void saveTicket() {
		newTicket = new Ticket();
		//newTicket.setID(Long.valueOf((txtFldTicketID).toString())) ;			
		//newTicket.setOpenedBy(txtFldOpenedBy.toString());
		newTicket.setOpenedDate(new Date());
		newTicket.setClient(txtFldClient.getText());
		newTicket.setClientEmail(txtFldClientEmail.getText());
		newTicket.setClientPhone(txtFldClientPhone.getText());
		//newTicket.setCompleteDate(Date.valueOf(txtFldComplDate.toString()));
		newTicket.setPriority(PriorityEnum.fromInt(cbBoxPriority.getSelectedIndex()));
		newTicket.setServiceCat(ServiceCatEnum.fromInt(cbBoxSerCategory.getSelectedIndex()));
		newTicket.setStatus(StatusEnum.fromInt(cbBoxStatus.getSelectedIndex()));
		newTicket.setDescription(txtAreaDescription.getText());
		newTicket.setLog(txtAreaLog.getText());
		newTicket.setSummary(txtFldSummary.getText());	
	}
	
	public Ticket getNewTicket()
	{
		return newTicket;
	}	
	
	public void displayTicketInfo(Ticket ticket){
		txtFldTicketID.setText(String.valueOf(ticket.getID()));
		txtFldOpenedBy.setText(ticket.getOpenedBy());
		txtFldOpenedDate.setText(String.valueOf(ticket.getOpenedDate()));
		txtFldClient.setText(ticket.getClient());
		txtFldClientPhone.setText(ticket.getClientPhone());		
		txtFldClientEmail.setText(ticket.getClientEmail());
		
		txtFldSummary.setText(ticket.getSummary());
		txtFldComplDate.setText(String.valueOf(ticket.getCompleteDate()));
	
		cbBoxPriority.setSelectedItem(ticket.getPriority());
		cbBoxSerCategory.setSelectedItem(ticket.getServiceCat());
		cbBoxStatus.setSelectedItem(ticket.getStatus());
		
		txtAreaLog.setText(ticket.getLog());
		txtAreaDescription.setText(ticket.getDescription());
	}
}
