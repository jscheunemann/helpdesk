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
import javax.swing.DefaultComboBoxModel;


public class Gui_UpdateTicket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldTicketID;
	private JTextField txtFldOpenedBy;
	private JTextField txtFldOpenedDate;
	private JTextField txtFldEditedBy;
	private JTextField txtFldEditedDate;
	private JTextField txtFldClient;
	private JTextField txtFldClientPhone;
	private JTextField txtFldClientEmail;
	private JTextField txtFldSummary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_UpdateTicket frame = new Gui_UpdateTicket();
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
	public Gui_UpdateTicket() {
		setType(Type.UTILITY);
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("Helpdesk Ticket Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl1 = new JPanel();
		pnl1.setBounds(0, 61, 660, 387);
		contentPane.add(pnl1);
		pnl1.setLayout(null);
		
		JLabel lblTicketId = new JLabel("Ticket ID");
		lblTicketId.setBounds(53, 17, 76, 14);
		lblTicketId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTicketId.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblTicketId);
		
		txtFldTicketID = new JTextField();
		txtFldTicketID.setBounds(139, 11, 203, 20);
		pnl1.add(txtFldTicketID);
		txtFldTicketID.setColumns(10);
		
		JLabel lblOpenedBy = new JLabel("Opened By");
		lblOpenedBy.setBounds(41, 50, 88, 14);
		lblOpenedBy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOpenedBy.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblOpenedBy);
		
		txtFldOpenedBy = new JTextField();
		txtFldOpenedBy.setBounds(139, 44, 203, 20);
		txtFldOpenedBy.setColumns(10);
		pnl1.add(txtFldOpenedBy);
		
		JLabel lblOpenedDate = new JLabel("Opened Date");
		lblOpenedDate.setBounds(41, 79, 88, 14);
		lblOpenedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOpenedDate.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblOpenedDate);
		
		txtFldOpenedDate = new JTextField();
		txtFldOpenedDate.setBounds(139, 73, 203, 20);
		txtFldOpenedDate.setColumns(10);
		pnl1.add(txtFldOpenedDate);
		
		JLabel lblEditedBy = new JLabel("Edited By");
		lblEditedBy.setBounds(41, 108, 88, 14);
		lblEditedBy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditedBy.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblEditedBy);
		
		txtFldEditedBy = new JTextField();
		txtFldEditedBy.setBounds(139, 102, 203, 20);
		txtFldEditedBy.setColumns(10);
		pnl1.add(txtFldEditedBy);
		
		JLabel lblEditedDate = new JLabel("Edited Date");
		lblEditedDate.setBounds(41, 137, 88, 14);
		lblEditedDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditedDate.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblEditedDate);
		
		txtFldEditedDate = new JTextField();
		txtFldEditedDate.setBounds(139, 131, 203, 20);
		txtFldEditedDate.setColumns(10);
		pnl1.add(txtFldEditedDate);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(41, 166, 88, 14);
		lblClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClient.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblClient);
		
		txtFldClient = new JTextField();
		txtFldClient.setBounds(139, 160, 203, 20);
		txtFldClient.setColumns(10);
		pnl1.add(txtFldClient);
		
		JLabel lblClientPhone = new JLabel("Client Phone");
		lblClientPhone.setBounds(41, 195, 88, 14);
		lblClientPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientPhone.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblClientPhone);
		
		txtFldClientPhone = new JTextField();
		txtFldClientPhone.setBounds(139, 189, 203, 20);
		txtFldClientPhone.setColumns(10);
		pnl1.add(txtFldClientPhone);
		
		JLabel lblClientEmail = new JLabel("Client Email");
		lblClientEmail.setBounds(10, 224, 119, 14);
		lblClientEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientEmail.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblClientEmail);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setBounds(41, 253, 88, 14);
		lblSummary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSummary.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblSummary);
		
		JLabel lblServiceCategory = new JLabel("Service Category");
		lblServiceCategory.setBounds(0, 282, 129, 14);
		lblServiceCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblServiceCategory.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblServiceCategory);
		
		JLabel lblUpdatePriority = new JLabel("Update Priority");
		lblUpdatePriority.setBounds(0, 314, 129, 14);
		lblUpdatePriority.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdatePriority.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblUpdatePriority);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(367, 137, 88, 14);
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setFont(new Font("Courier New", Font.PLAIN, 12));
		pnl1.add(lblDescription);
		
		JComboBox cbBoxUpdatePriority = new JComboBox();
		cbBoxUpdatePriority.setModel(new DefaultComboBoxModel(new String[] {"Low ", "Medium ", "High ", "Urgent"}));
		cbBoxUpdatePriority.setBounds(139, 315, 203, 20);
		pnl1.add(cbBoxUpdatePriority);
		
		JComboBox cbBoxServiceCategory = new JComboBox();
		cbBoxServiceCategory.setModel(new DefaultComboBoxModel(new String[] {"Access Issue", "Hardware", "Software", "Database", "Software Defect", "Inquiry"}));
		cbBoxServiceCategory.setBounds(139, 282, 203, 20);
		pnl1.add(cbBoxServiceCategory);
		
		JComboBox cbBoxUpdateStatus = new JComboBox();
		cbBoxUpdateStatus.setModel(new DefaultComboBoxModel(new String[] {"New ", "In Progress", "Wait for Process", "Withdrawn ", "Complete ", "Delete"}));
		cbBoxUpdateStatus.setBounds(139, 346, 203, 20);
		pnl1.add(cbBoxUpdateStatus);
		
		JLabel lblUpdateLog = new JLabel("Update Log");
		lblUpdateLog.setHorizontalAlignment(SwingConstants.LEFT);
		lblUpdateLog.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblUpdateLog.setBounds(367, 17, 88, 14);
		pnl1.add(lblUpdateLog);
		
		JTextArea txtAreaUpdateLog = new JTextArea();
		txtAreaUpdateLog.setBackground(Color.WHITE);
		txtAreaUpdateLog.setLineWrap(true);
		txtAreaUpdateLog.setBounds(367, 44, 278, 78);
		pnl1.add(txtAreaUpdateLog);
		
		JTextArea txtAreaDescription = new JTextArea();
		txtAreaDescription.setLineWrap(true);
		txtAreaDescription.setBackground(Color.WHITE);
		txtAreaDescription.setBounds(367, 160, 278, 78);
		pnl1.add(txtAreaDescription);
		
		txtFldClientEmail = new JTextField();
		txtFldClientEmail.setColumns(10);
		txtFldClientEmail.setBounds(139, 220, 203, 20);
		pnl1.add(txtFldClientEmail);
		
		txtFldSummary = new JTextField();
		txtFldSummary.setColumns(10);
		txtFldSummary.setBounds(139, 249, 203, 20);
		pnl1.add(txtFldSummary);
		
		JLabel lblUpdateStatus = new JLabel("Update Status");
		lblUpdateStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdateStatus.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblUpdateStatus.setBounds(0, 349, 129, 14);
		pnl1.add(lblUpdateStatus);
		
		JLabel lblUpdateDescription = new JLabel("Update Description");
		lblUpdateDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblUpdateDescription.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblUpdateDescription.setBounds(367, 253, 188, 14);
		pnl1.add(lblUpdateDescription);
		
		JTextArea txtAreaUpdateDescription = new JTextArea();
		txtAreaUpdateDescription.setLineWrap(true);
		txtAreaUpdateDescription.setBackground(Color.WHITE);
		txtAreaUpdateDescription.setBounds(367, 282, 278, 81);
		pnl1.add(txtAreaUpdateDescription);
		
		
		
		JPanel pnl2 = new JPanel();
		pnl2.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnl2.setBounds(0, 447, 660, 48);
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
		panel.setBounds(0, 0, 655, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUpdateTicket = new JLabel("Update Ticket");
		lblUpdateTicket.setForeground(new Color(255, 255, 255));
		lblUpdateTicket.setFont(new Font("Courier New", Font.PLAIN, 25));
		lblUpdateTicket.setBounds(35, 11, 620, 44);
		panel.add(lblUpdateTicket);
	}
}
