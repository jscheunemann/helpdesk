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

package it.helpdesk.main;

import it.sauronsoftware.junique.*;

import java.awt.event.*;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		String appId = Main.class.getName();
		boolean alreadyRunning = false;
		
		try {
			JUnique.acquireLock(appId, new MessageHandler() {
				public String handle(String message) {
					if (message.equalsIgnoreCase("signal")) {
						System.out.println("A signal received");
					}	
					return null;
				}
			});
		} catch (AlreadyLockedException e) {
			alreadyRunning = true;
		}
		
		if (!alreadyRunning) {
			try {
				System.setProperty("apple.laf.useScreenMenuBar", "true");
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(ClassNotFoundException e) {
				System.out.println("ClassNotFoundException: " + e.getMessage());
			}
			catch(InstantiationException e) {
				System.out.println("InstantiationException: " + e.getMessage());
			}
			catch(IllegalAccessException e) {
				System.out.println("IllegalAccessException: " + e.getMessage());
			}
			catch(UnsupportedLookAndFeelException e) {
				System.out.println("UnsupportedLookAndFeelException: " + e.getMessage());
			}
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					it.helpdesk.ui.desktop.swing.MainForm mainScreen = new it.helpdesk.ui.desktop.swing.MainForm();
					mainScreen.setVisible(true);
					mainScreen.addWindowListener(new WindowAdapter() {

						@Override
						public void windowClosing(WindowEvent e) {
							e.getWindow().dispose();
						}
					});
				}
			});
		} 
		else {
			JUnique.sendMessage(appId, "signal");
			for (int i = 0; i < args.length; i++) {
				JUnique.sendMessage(appId, args[i]);
			}
		}
	}
}