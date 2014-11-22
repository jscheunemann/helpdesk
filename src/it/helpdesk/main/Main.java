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