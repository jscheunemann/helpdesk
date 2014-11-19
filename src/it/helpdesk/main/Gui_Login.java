package it.helpdesk.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Gui_Login extends JDialog {
	
	private String userName;
	private String password;

	private JPanel contentPane;
	private JTextField txtFieldUserName;
	private JTextField txtFldPassword;

	/**
	 * Create the frame.
	 */
	public Gui_Login(JFrame parent) {
		super(parent, "", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setLocationRelativeTo(parent);
		setTitle("Login");
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
		lblLogin.setFont(new Font(lblLogin.getName(), Font.PLAIN, lblLogin.getFont().getSize() * 2));
		lblLogin.setBounds(15, 15, 168, 30);
		pnlLogin.add(lblLogin);
		
		JLabel lblUserName = new JLabel(" User Name");
		lblUserName.setBounds(42, 106, 85, 24);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel(" Password");
		lblPassword.setBounds(42, 141, 85, 24);
		contentPane.add(lblPassword);
		
		txtFieldUserName = new JTextField();
		txtFieldUserName.setBounds(137, 108, 273, 20);
		contentPane.add(txtFieldUserName);
		txtFieldUserName.setColumns(10);
		
		txtFldPassword = new JPasswordField();
		txtFldPassword.setColumns(10);
		txtFldPassword.setBounds(137, 143, 273, 20);
		contentPane.add(txtFldPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(109, 211, 99, 24);
		contentPane.add(btnSignIn);
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.setBounds(218, 211, 192, 24);
		contentPane.add(btnCreateNewAccount);	
		
		this.setLocationRelativeTo(parent);
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
