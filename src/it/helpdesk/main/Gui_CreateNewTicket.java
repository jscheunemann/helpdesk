package it.helpdesk.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;


public class Gui_CreateNewTicket extends JFrame {

	/**
	 * 
	 */
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_CreateNewTicket frame = new Gui_CreateNewTicket();
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
	public Gui_CreateNewTicket() {
		setType(Type.UTILITY);
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("Helpdesk Ticket Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl1 = new JPanel();
		pnl1.setBounds(0, 80, 671, 525);
		contentPane.add(pnl1);
		pnl1.setLayout(null);
		
		JLabel lblTicketID = new JLabel("Ticket ID");
		lblTicketID.setBounds(53, 29, 76, 14);
		lblTicketID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTicketID.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblTicketID);
		
		txtFldTicketID = new JTextField();
		txtFldTicketID.setEditable(false);
		txtFldTicketID.setBounds(139, 23, 203, 20);
		pnl1.add(txtFldTicketID);
		txtFldTicketID.setColumns(10);
		
		JLabel lblOpenedBy = new JLabel("Opened By");
		lblOpenedBy.setBounds(41, 62, 88, 14);
		lblOpenedBy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOpenedBy.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblOpenedBy);
		
		txtFldOpenedBy = new JTextField();
		txtFldOpenedBy.setEditable(false);
		txtFldOpenedBy.setBounds(139, 56, 203, 20);
		txtFldOpenedBy.setColumns(10);
		pnl1.add(txtFldOpenedBy);
		
		JLabel lblOpenedDate = new JLabel("Opened Date");
		lblOpenedDate.setBounds(360, 62, 88, 14);
		lblOpenedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOpenedDate.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblOpenedDate);
		
		txtFldOpenedDate = new JTextField();
		txtFldOpenedDate.setEditable(false);
		txtFldOpenedDate.setBounds(458, 56, 203, 20);
		txtFldOpenedDate.setColumns(10);
		pnl1.add(txtFldOpenedDate);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(41, 93, 88, 14);
		lblClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClient.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblClient);
		
		txtFldClient = new JTextField();
		txtFldClient.setBounds(139, 87, 203, 20);
		txtFldClient.setColumns(10);
		pnl1.add(txtFldClient);
		
		JLabel lblClientPhone = new JLabel("Client Phone");
		lblClientPhone.setBounds(41, 122, 88, 14);
		lblClientPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientPhone.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblClientPhone);
		
		txtFldClientPhone = new JTextField();
		txtFldClientPhone.setBounds(139, 116, 203, 20);
		txtFldClientPhone.setColumns(10);
		pnl1.add(txtFldClientPhone);
		
		JLabel lblClientEmail = new JLabel("Client Email");
		lblClientEmail.setBounds(360, 122, 88, 14);
		lblClientEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientEmail.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblClientEmail);
		
		txtFldClientEmail = new JTextField();
		txtFldClientEmail.setBounds(458, 116, 203, 20);
		txtFldClientEmail.setColumns(10);
		pnl1.add(txtFldClientEmail);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setBounds(41, 153, 88, 14);
		lblSummary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSummary.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblSummary);
		
		txtFldSummary = new JTextField();
		txtFldSummary.setBounds(139, 147, 203, 20);
		txtFldSummary.setColumns(10);
		pnl1.add(txtFldSummary);
		
		JLabel lblServiceCategory = new JLabel("Service Category");
		lblServiceCategory.setBounds(10, 182, 119, 14);
		lblServiceCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblServiceCategory.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblServiceCategory);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(360, 178, 88, 14);
		lblPriority.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPriority.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblPriority);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(41, 209, 88, 14);
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblStatus);
		
		JLabel lblCompletedDate = new JLabel("Completed Date");
		lblCompletedDate.setBounds(329, 213, 119, 14);
		lblCompletedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompletedDate.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblCompletedDate);
		
		txtFldComplDate = new JTextField();
		txtFldComplDate.setBounds(458, 207, 203, 20);
		txtFldComplDate.setColumns(10);
		pnl1.add(txtFldComplDate);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(41, 234, 88, 14);
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblDescription);
		
		JComboBox cbBoxPriority = new JComboBox();
		cbBoxPriority.setModel(new DefaultComboBoxModel(new String[] {"Low ", "Medium ", "High ", "Urgent"}));
		cbBoxPriority.setBounds(458, 174, 203, 20);
		pnl1.add(cbBoxPriority);
		
		JButton btnAddInformation = new JButton("Add Information");
		btnAddInformation.setBounds(139, 323, 196, 26);
		btnAddInformation.setFont(new Font("Courier New", Font.PLAIN, 14));
		pnl1.add(btnAddInformation);
		
		JComboBox cbBoxSerCategory = new JComboBox();
		cbBoxSerCategory.setModel(new DefaultComboBoxModel(new String[] {"Access Issue", "Hardware", "Software", "Database", "Software Defect", "Inquiry"}));
		cbBoxSerCategory.setBounds(139, 174, 203, 20);
		pnl1.add(cbBoxSerCategory);
		
		JComboBox cbBoxStatus = new JComboBox();
		cbBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"New ", "In Progress", "Wait for Process", "Withdrawn ", "Complete ", "Delete"}));
		cbBoxStatus.setBounds(139, 207, 203, 20);
		pnl1.add(cbBoxStatus);
		
		JLabel lblLog = new JLabel("Log");
		lblLog.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLog.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblLog.setBounds(73, 355, 55, 14);
		pnl1.add(lblLog);
		
		JTextArea txtAreaLog = new JTextArea();
		txtAreaLog.setBackground(Color.WHITE);
		txtAreaLog.setLineWrap(true);
		txtAreaLog.setBounds(64, 380, 278, 132);
		pnl1.add(txtAreaLog);
		
		JTextArea txtAreaDescription = new JTextArea();
		txtAreaDescription.setLineWrap(true);
		txtAreaDescription.setBackground(Color.WHITE);
		txtAreaDescription.setBounds(139, 238, 203, 74);
		pnl1.add(txtAreaDescription);
		
		
		
		JPanel pnl2 = new JPanel();
		pnl2.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnl2.setBounds(0, 605, 660, 64);
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
		panel.setBounds(0, 0, 660, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCreateTicket = new JLabel("New Helpdesk Ticket ");
		lblCreateTicket.setForeground(new Color(255, 255, 255));
		lblCreateTicket.setFont(new Font("Courier New", Font.PLAIN, 30));
		lblCreateTicket.setBounds(22, 22, 623, 42);
		panel.add(lblCreateTicket);
	}
	
	public void SaveTicket() {
		Ticket newTicket = new Ticket();
	}
}
