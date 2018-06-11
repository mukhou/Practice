package com.cts.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuDemo {
	JTextArea output;
	JScrollPane scrollPane;

	public JMenuBar createMenuBar() {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		// Create the menu bar
		menuBar = new JMenuBar();

		// First menu

		menu = new JMenu("Collections");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
		// menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem);		
		
		//a group of radio button menu items
		menu.addSeparator();
		ButtonGroup buttonGroup = new ButtonGroup();
		
		rbMenuItem = new JRadioButtonMenuItem("ICG");
		rbMenuItem.setSelected(false);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		buttonGroup.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("ICA");		
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		buttonGroup.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		//Checkbox menu items
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("Business divs");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);
		
		cbMenuItem = new JCheckBoxMenuItem("Shared services");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);
		
		//submenu
		submenu = new JMenu("Observations");
		submenu.setMnemonic(KeyEvent.VK_S);
		
		menuItem = new JMenuItem("Recommendations");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Issues");
        submenu.add(menuItem);
        menu.add(submenu);
        
        //Build second menu in the menu bar.
        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
        menuBar.add(menu);
		
        return menuBar;
        
	}
	
	public Container createContentPane(){
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setOpaque(true);
		
		output = new JTextArea(5,10);
		output.setEditable(false);
		scrollPane = new JScrollPane(output);
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		return contentPane;
		
	}
	
	//Create the GUI and show it
	private static void createAndShowGUI(){
		
		//create and setup the window
		JFrame frame = new JFrame("Menudemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	   //Create and set up the content pane.
		MenuDemo demo = new MenuDemo();
		frame.setJMenuBar(demo.createMenuBar());
		frame.setContentPane(demo.createContentPane());
		frame.setSize(450, 260);
        frame.setVisible(true);
		
	}
	
	 public static void main(String[] args){
		 
		 SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGUI();
				
			}
		});
	 }
	
	

}
