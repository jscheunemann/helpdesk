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

/**
 * View class that allows a user to create a new login for the application.
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-26
 */
public class TechnicianFormView implements ITechnicianFormView {
	/**
	 * Contains a ITechnicianFormController object.
	 */
	private ITechnicianFormController controller;
	
	/**
	 * Contains a JDialog object for the current window
	 */
	private JDialog window;
	
	/**
	 * Contains a JTextField object containing the username enterd by the user.
	 */
	private JTextField usernameTextBox;
	
	/**
	 * Contains a JPasswordField object containing the password enterd by the user.
	 */
	private JPasswordField passwordTextBox;
	
	/**
	 * Contains a JPasswordField object containing the password verification enterd by the user.
	 */
	private JPasswordField passwordConfirmationTextBox;
	
	/**
	 * Contains a JTextField object containing the first name enterd by the user.
	 */
	private JTextField firstNameTextBox;
	
	/**
	 * Contains a JTextField object containing the last name enterd by the user.
	 */
	private JTextField lastNameTextBox;
	
	/**
	 * Contains a JTextField object containing the phone number enterd by the user.
	 */
	private JTextField phoneNumberTextBox;
	
	/**
	 * Contains a JTextField object containing the email enterd by the user.
	 */
	private JTextField emailTextBox;
	
	/**
	 * Contains a JButton object allowing the user to submit their request.
	 */
	private JButton okButton;
	
	/**
	 * Class constructor creating the form for the user to setup a new login account.
	 * 
	 * @param parent contains a JFrame object referencing the parent window
	 */
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

	/**
	 * Method to set the local controller object to the ITechnicianFormController passed
	 * to the method.
	 * 
	 * @param controller contains a ITechnicianFormController object
	 */
	@Override
	public void setController(ITechnicianFormController controller) {
		this.controller = controller;
	}

	/**
	 * Method to open the form and instantiate the Action Listener for the button-click event.
	 */
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
	
	/**
	 * Method to close the window.
	 */
	@Override
	public void close() {
		this.window.dispose();
	}

	/**
	 * Method to retrieve the username entered by the user on the form.
	 * 
	 * @return a String containing the username entered by the user
	 */
	@Override
	public String getUsername() {
		return this.usernameTextBox.getText();
	}

	/**
	 * Method to set the local username variable entered by the user on the form.
	 * 
	 * @param username contains the username value entered on the form
	 */
	@Override
	public void setUsername(String username) {
		this.usernameTextBox.setText(username);
	}

	/**
	 * Method to retrieve the password entered by the user on the form.
	 * 
	 * @return a String containing the password entered by the user
	 */
	@Override
	public String getPassword() {
		return new String(this.passwordTextBox.getPassword());
	}
	
	/**
	 * Method to retrieve the password confirmation entered by the user on the form.
	 * 
	 * @return a String containing the password confirmation entered by the user
	 */
	@Override
	public String getPasswordConfirmation() {
		return this.passwordConfirmationTextBox.getPassword().toString();
	}

	/**
	 * Method to retrieve the first name entered by the user on the form.
	 * 
	 * @return a String containing the first name entered by the user
	 */
	@Override
	public String getFirstName() {
		return this.firstNameTextBox.getText();
	}

	/**
	 * Method to set the local first name variable entered by the user on the form.
	 * 
	 * @param firstName contains the first name value entered on the form
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstNameTextBox.setText(firstName);
	}

	/**
	 * Method to retrieve the last name entered by the user on the form.
	 * 
	 * @return a String containing the last name entered by the user
	 */
	@Override
	public String getLastName() {
		return this.lastNameTextBox.getText();
	}

	/**
	 * Method to set the local last name variable entered by the user on the form.
	 * 
	 * @param lastName contains the last name value entered on the form
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastNameTextBox.setText(lastName);
	}
	
	/**
	 * Method to retrieve the phone number entered by the user on the form.
	 * 
	 * @return a String containing the phone number entered by the user
	 */
	@Override
	public String getPhoneNumber() {
		return this.phoneNumberTextBox.getText();
	}
	
	/**
	 * Method to set the local phone number variable entered by the user on the form.
	 * 
	 * @param phoneNumber contains the phone number value entered on the form
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumberTextBox.setText(phoneNumber);
	}

	/**
	 * Method to retrieve the email entered by the user on the form.
	 * 
	 * @return a String containing the email entered by the user
	 */
	@Override
	public String getEmailAddress() {
		return this.emailTextBox.getText();
	}

	/**
	 * Method to set the local email address variable entered by the user on the form.
	 * 
	 * @param emailAddress contains the email address value entered on the form
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		this.emailTextBox.setText(emailAddress);
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
}
