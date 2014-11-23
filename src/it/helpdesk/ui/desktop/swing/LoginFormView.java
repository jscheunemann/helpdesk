/*
 * Copyright (C) 2014  Helpdesk Tracker Group, Fall Semester, UMUC
 * 
 * This software is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 */

package it.helpdesk.ui.desktop.swing;

import it.helpdesk.ui.interfaces.ILoginFormController;
import it.helpdesk.ui.interfaces.ILoginFormView;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginFormView implements ILoginFormView {
	private ILoginFormController controller;
	private JDialog window;
	private JPanel contentPane;
	private JTextField usernameTextBox;
	private JPasswordField passwordTextBox;
	private JButton btnSignIn;
	private JButton btnCreateNewAccount;

	public LoginFormView(JFrame parent) {
		window = new JDialog(parent, "Login", Dialog.ModalityType.APPLICATION_MODAL);
		//window.setLocationRelativeTo(parent);
		window.setBounds(100, 100, 450, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		window.setContentPane(contentPane);
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
		
		usernameTextBox = new JTextField();
		usernameTextBox.setBounds(137, 108, 273, 20);
		contentPane.add(usernameTextBox);
		usernameTextBox.setColumns(10);
		
		passwordTextBox = new JPasswordField();
		passwordTextBox.setColumns(10);
		passwordTextBox.setBounds(137, 143, 273, 20);
		contentPane.add(passwordTextBox);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(109, 211, 99, 24);
		contentPane.add(btnSignIn);
		
		btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.setBounds(218, 211, 192, 24);
		contentPane.add(btnCreateNewAccount);	
		
		window.setLocationRelativeTo(parent);
	}

	@Override
	public void setController(ILoginFormController controller) {
		this.controller = controller;
	}

	@Override
	public void open() {
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFormView.this.controller.requestAuthentication();
			}
		});
		
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFormView.this.controller.openCreateUserForm();
			}
		});
		window.setVisible(true);
	}

	@Override
	public void close() {
		window.dispose();
	}

	@Override
	public String getUsername() {
		return this.usernameTextBox.getText();
	}

	@Override
	public String getPassword() {
		return new String(this.passwordTextBox.getPassword());
	}

	@Override
	public void showValidationErrorDialog() {
		
	}
}
