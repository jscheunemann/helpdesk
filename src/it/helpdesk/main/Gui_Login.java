package it.helpdesk.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Gui_Login extends JFrame {
	
	private String userName;
	private String password;

	private JPanel contentPane;
	private JTextField txtFieldUserName;
	private JTextField txtFldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Login frame = new Gui_Login();
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
	public Gui_Login() {
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setTitle("Helpdesk Ticket Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setBackground(new Color(47, 79, 79));
		pnlLogin.setBounds(0, 0, 434, 67);
		contentPane.add(pnlLogin);
		pnlLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Courier New", Font.PLAIN, 40));
		lblLogin.setBounds(22, 22, 168, 45);
		pnlLogin.add(lblLogin);
		
		JLabel lblUserName = new JLabel(" User Name");
		lblUserName.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblUserName.setBounds(42, 106, 85, 24);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel(" Password");
		lblPassword.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblPassword.setBounds(42, 141, 85, 24);
		contentPane.add(lblPassword);
		
		txtFieldUserName = new JTextField();
		txtFieldUserName.setBounds(137, 108, 273, 20);
		contentPane.add(txtFieldUserName);
		txtFieldUserName.setColumns(10);
		
		txtFldPassword = new JTextField();
		txtFldPassword.setColumns(10);
		txtFldPassword.setBounds(137, 143, 273, 20);
		contentPane.add(txtFldPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnSignIn.setBounds(109, 211, 99, 24);
		contentPane.add(btnSignIn);
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnCreateNewAccount.setBounds(218, 211, 192, 24);
		contentPane.add(btnCreateNewAccount);	
	}

	public boolean attemptLogin() {
		// TODO 
		return true;
	}
	
	public boolean confirmCredentials() {
		// TODDO
		return true;
	}
	
	boolean ProcessLogin() {
		// TODO process login
		return false;
	}
	
	
}
