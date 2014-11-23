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

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import it.helpdesk.ui.interfaces.*;

public class UserFormView implements IUserFormView {
	private IUserFormController controller;
	private JDialog window;
	private JTextField usernameTextBox;
	private JPasswordField passwordTextBox;
	private JPasswordField passwordConfirmationTextBox;
	private JTextField firstNameTextBox;
	private JTextField lastNameTextBox;
	private JTextField emailTextBox;
	private JButton okButton;
	
	public UserFormView(JFrame parent) {
		window = new JDialog(parent, null, Dialog.ModalityType.APPLICATION_MODAL);
		
		JPanel usernamePanel = new JPanel();
		usernamePanel.add(new JLabel("Username"));
		usernameTextBox = new JTextField(15);
		usernamePanel.add(usernameTextBox);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.add(new JLabel("Password"));
		passwordTextBox = new JPasswordField(15);
		passwordPanel.add(passwordTextBox);
		
		JPanel passwordConfirmationPanel = new JPanel();
		passwordConfirmationPanel.add(new JLabel("Password (Confirm)"));
		passwordConfirmationTextBox = new JPasswordField(15);
		passwordConfirmationPanel.add(passwordConfirmationTextBox);
		
		JPanel firstNamePanel = new JPanel();
		firstNamePanel.add(new JLabel("First Name"));
		firstNameTextBox = new JTextField(15);
		firstNamePanel.add(firstNameTextBox);

		JPanel lastNamePanel = new JPanel();
		lastNamePanel.add(new JLabel("Last Name"));
		lastNameTextBox = new JTextField(15);
		lastNamePanel.add(lastNameTextBox);
		
		JPanel emailPanel = new JPanel();
		emailPanel.add(new JLabel("Email"));
		emailTextBox = new JTextField(15);
		emailPanel.add(emailTextBox);

		okButton = new JButton("OK");

		window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));

		
		window.add(usernamePanel);
		window.add(passwordPanel);
		window.add(passwordConfirmationPanel);
		window.add(firstNamePanel);
		window.add(lastNamePanel);
		window.add(emailPanel);
		window.add(okButton);

		window.pack();
	}

	@Override
	public void setController(IUserFormController controller) {
		this.controller = controller;
	}

	@Override
	public void open() {
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserFormView.this.controller.saveButtonPressed();
			}
		});
		
		this.window.setVisible(true);
	}
	
	@Override
	public void close() {
		this.window.dispose();
	}

	@Override
	public String getUsername() {
		return this.usernameTextBox.getText();
	}

	@Override
	public void setUsername(String username) {
		this.usernameTextBox.setText(username);
	}

	@Override
	public String getPassword() {
		return new String(this.passwordTextBox.getPassword());
	}
	
	@Override
	public String getPasswordConfirmation() {
		return this.passwordConfirmationTextBox.getPassword().toString();
	}

	@Override
	public String getFirstName() {
		return this.firstNameTextBox.getText();
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstNameTextBox.setText(firstName);
	}

	@Override
	public String getLastName() {
		return this.lastNameTextBox.getText();
	}

	@Override
	public void setLastName(String lastName) {
		this.lastNameTextBox.setText(lastName);
	}

	@Override
	public String getEmailAddress() {
		return this.emailTextBox.getText();
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		this.emailTextBox.setText(emailAddress);
	}

	@Override
	public void showValidationErrorDialog() {
		
	}
}
