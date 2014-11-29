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

package it.helpdesk.main;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * View class that allows the user to select sub-menu items within the application.
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class Submenu extends JFrame {
	
	/**
	 * Contains the serial version number of the application.
	 */
	private static final long serialVersionUID = -5886246414863162329L;

	/**
	 * Default class constructor which initializes the user interface.
	 */
	public Submenu() {
        	initUI();
	}
    
	/**
	 * Method to initialize the application with the sub-menu options.
	 */
	private void initUI() {
	        JMenuBar menubar = new JMenuBar();
	        
	        JMenu filem = new JMenu("Tickets");
	        JMenu viewm = new JMenu("Current");
	        JMenu toolsm = new JMenu("Status");
	        JMenu helpm = new JMenu("Help");
	
	        menubar.add(filem);
	        menubar.add(viewm);
	        menubar.add(toolsm);        
	        menubar.add(Box.createHorizontalGlue());
	        menubar.add(helpm);
	
	        setJMenuBar(menubar);
	
	        setTitle("Welcom to Ticket Tracking App");
	        setSize(600, 200);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);        
	}
}
