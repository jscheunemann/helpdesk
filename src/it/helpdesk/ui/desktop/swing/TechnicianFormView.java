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

import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import it.helpdesk.ui.interfaces.*;

public class TechnicianFormView implements ITechnicianFormView {
	private ITechnicianFormController controller;
	private JDialog window;
	private JTextField usernameTextBox;
	private JPasswordField passwordTextBox;
	private JPasswordField passwordConfirmationTextBox;
	private JTextField firstNameTextBox;
	private JTextField lastNameTextBox;
	private JTextField phoneNumberTextBox;
	private JTextField emailTextBox;
	private JButton okButton;
	
	public TechnicianFormView(JFrame parent) {
		window = new JDialog(parent, null, Dialog.ModalityType.APPLICATION_MODAL);
		
		usernameTextBox = new JTextField(15);
		passwordTextBox = new JPasswordField(15);
		passwordConfirmationTextBox = new JPasswordField(15);
		firstNameTextBox = new JTextField(15);
		lastNameTextBox = new JTextField(15);
		phoneNumberTextBox = new JTextField(15);
		emailTextBox = new JTextField(15);
		okButton = new JButton("OK");

		window.getContentPane().setLayout(new GridBagLayout());
		
		((JComponent)window.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		window.add(new JLabel("Username ", SwingConstants.RIGHT), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		window.add(this.usernameTextBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		window.add(new JLabel("Password ", SwingConstants.RIGHT), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		window.add(this.passwordTextBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		window.add(new JLabel("Confirm ", SwingConstants.RIGHT), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		window.add(this.passwordConfirmationTextBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		window.add(new JLabel("First Name ", SwingConstants.RIGHT), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		window.add(this.firstNameTextBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		window.add(new JLabel("Last Name ", SwingConstants.RIGHT), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		window.add(this.lastNameTextBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		window.add(new JLabel("Phone ", SwingConstants.RIGHT), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		window.add(this.phoneNumberTextBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		window.add(new JLabel("Email ", SwingConstants.RIGHT), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		window.add(this.emailTextBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 7;
		window.add(new JLabel(" "), c);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 2;
		window.add(okButton, c);

		window.pack();
	}

	@Override
	public void setController(ITechnicianFormController controller) {
		this.controller = controller;
	}

	@Override
	public void open() {
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TechnicianFormView.this.controller.saveButtonPressed();
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
	public String getPhoneNumber() {
		return this.phoneNumberTextBox.getText();
	}
	
	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumberTextBox.setText(phoneNumber);
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
