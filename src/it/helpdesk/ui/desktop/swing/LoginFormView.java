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

import it.helpdesk.ui.interfaces.ILoginFormController;
import it.helpdesk.ui.interfaces.ILoginFormView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Robot;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * View class that allows the user to login to the application or request access.
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-26
 */
public class LoginFormView implements ILoginFormView {
	/**
	 * Contains an ILoginFormController object
	 */
	private ILoginFormController controller;
	
	/**
	 * Contains a JDialog box that will be used as the window for the page
	 */
	private JDialog window;
	
	/**
	 * Contains a JPanel that will be used as the content pane
	 */
	private JPanel contentPane;
	
	/**
	 * Contains a JTextField that will contian the username for the user
	 */
	private JTextField usernameTextBox;
	
	/**
	 * Contains a JPasswordField that will contian the password for the user
	 */
	private JPasswordField passwordTextBox;
	
	/**
	 * Contains a JButton that will be used to sign-in to the application
	 */
	private JButton btnSignIn;
	
	/**
	 * Contains a JButton that will be used to request access to the application
	 */
	private JButton btnCreateNewAccount;

	/**
	 * Class constructor for the login page.
	 * 
	 * @param parent contains a JFrame object
	 */
	public LoginFormView(JFrame parent) {
		window = new JDialog(parent, "Login", Dialog.ModalityType.APPLICATION_MODAL);
		window.setPreferredSize(new Dimension(400, 300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout());
		
		
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(47, 79, 79));
		pnlTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel title = new JLabel("  Login");
		title.setForeground(Color.WHITE);
		title.setFont(new Font(null, Font.PLAIN, title.getFont().getSize() * 2));
		
		pnlTitle.add(title);
		pnlTitle.setBackground(new Color(47, 79, 79));
		pnlTitle.setBorder(new EmptyBorder(10, 0, 10, 0));
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		JLabel lblUserName = new JLabel("User Name  ", SwingConstants.RIGHT);
		pnlLogin.add(lblUserName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		usernameTextBox = new JTextField();
		pnlLogin.add(usernameTextBox, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		JLabel lblPassword = new JLabel("Password  ", SwingConstants.RIGHT);
		pnlLogin.add(lblPassword, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		passwordTextBox = new JPasswordField();
		pnlLogin.add(passwordTextBox, gbc);
		
		pnlLogin.setBorder(new EmptyBorder(25, 45, 25, 45));
		
		btnSignIn = new JButton("Sign In");
		JPanel pnlButton = new JPanel(new FlowLayout());
		pnlButton.add(btnSignIn);
		
		pnlButton.setBorder(new EmptyBorder(0, 15, 15, 15));
		
		btnCreateNewAccount = new JButton("Create New Account");
		pnlLogin.add(btnCreateNewAccount);
		pnlButton.add(btnCreateNewAccount);
		
		contentPane.add(pnlTitle, BorderLayout.NORTH);
		contentPane.add(pnlLogin, BorderLayout.CENTER);
		contentPane.add(pnlButton, BorderLayout.SOUTH);
		
		window.setContentPane(contentPane);
		window.pack();
		window.setLocationRelativeTo(parent);
	}

	/**
	 * Method to set the local variable to the ILoginFormController object being
	 * passed to the method.
	 * 
	 * @param controller contains a ILoginFormController object
	 */
	@Override
	public void setController(ILoginFormController controller) {
		this.controller = controller;
	}
	
	/**
	 * Method handles the opening of the page and intialization of the local variables.
	 */
	@Override
	public void open() {
		this.window.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				LoginFormView.this.controller.closeForm();
			}
		});
		
		this.usernameTextBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = LoginFormView.this.btnSignIn.getLocationOnScreen();
			    Robot r;
				try {
					r = new Robot();
					r.mouseMove(p.x + LoginFormView.this.btnSignIn.getWidth() / 2, p.y + LoginFormView.this.btnSignIn.getHeight() / 2);
			    
				} catch (AWTException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			    
				LoginFormView.this.btnSignIn.doClick();
			}
		});
		
		this.passwordTextBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = LoginFormView.this.btnSignIn.getLocationOnScreen();
			    Robot r;
				try {
					r = new Robot();
					r.mouseMove(p.x + LoginFormView.this.btnSignIn.getWidth() / 2, p.y + LoginFormView.this.btnSignIn.getHeight() / 2);
			    
				} catch (AWTException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				LoginFormView.this.btnSignIn.doClick();
			}
		});
		
		this.btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFormView.this.controller.requestAuthentication();
			}
		});
		
		this.btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFormView.this.controller.openCreateUserForm();
			}
		});
		
		PreloadConnectionDialog dialog = new PreloadConnectionDialog(this.window);
		dialog.execute();
		
		this.window.setVisible(true);
	}

	/**
	 * Method that handles the closing of the login window. 
	 */
	@Override
	public void close() {
		window.dispose();
	}

	/**
	 * Method to retrieve the username entered by the user.
	 * 
	 * @return a String containing the username entered by the user
	 */
	@Override
	public String getUsername() {
		return this.usernameTextBox.getText();
	}

	/**
	 * Method to retrieve the password entered by the user.
	 * 
	 * @return a String containing the password entered by the user
	 */
	@Override
	public String getPassword() {
		return new String(this.passwordTextBox.getPassword());
	}
	
	/**
	 * Method to show a error message in a dialog
	 * 
	 * @param the title of the dialog
	 * @param the message to display
	 */
	@Override
	public void showValidationErrorDialog(String title, String message) {
		JOptionPane.showMessageDialog(this.window.getParent(), message, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public JDialog getWindow() {
		return this.window;
	}
}
