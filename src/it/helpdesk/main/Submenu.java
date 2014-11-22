package it.helpdesk.main;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class Submenu extends JFrame {
	private static final long serialVersionUID = -5886246414863162329L;

	public Submenu() {
        
        initUI();
    }
    
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