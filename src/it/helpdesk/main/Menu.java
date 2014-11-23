package it.helpdesk.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1541453486039339656L;

	public Menu() {
        initUI();
    }

    private void initUI() {
        JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon("exit.png");

        JMenu file = new JMenu("Main Menu");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit", icon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);

        setTitle("Welcome to Ticketing Tracking System");
        setSize(456, 326);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}