package com.cts.swing;

import javax.swing.*;

import java.awt.*;

public class MyApp {
	
	JTextArea area;
	JScrollPane pane;
	
	public JMenuBar createMenuBar(){
		
		JMenuBar menuBar;
		JMenu menu, submenu, submenu1;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
		
		//Menubar
		menuBar = new JMenuBar();
		
		//Menu
		menu = new JMenu("Collections");
		menuBar.add(menu);
		
		//Menuitems
		menuItem = new JMenuItem("Control services");
		menu.add(menuItem);
		
		//a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("ICG");
		rbMenuItem.setSelected(true);
		rbMenuItem.setToolTipText("Issue Creator Group");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("ICA");	
		rbMenuItem.setToolTipText("Issue Creator Assignment");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("ICR");
		rbMenuItem.setToolTipText("Issue Creator Recruitor");
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
		
		//checkbox menuitems
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("Business");
		cbMenuItem.setSelected(true);
		menu.add(cbMenuItem);
		
		cbMenuItem = new JCheckBoxMenuItem("Services");		
		menu.add(cbMenuItem);
		
		cbMenuItem = new JCheckBoxMenuItem("Regions");		
		menu.add(cbMenuItem);
		
		//add submenu
		submenu = new JMenu("Observations");
		
		menuItem = new JMenuItem("MyObs");
		submenu.add(menuItem);
		
		menuItem = new JMenuItem("Obs1");
		submenu.add(menuItem);
		menu.add(submenu);
		
		//add submenu of submenu
		submenu1 = new JMenu("recommendations");
		
		menuItem = new JMenuItem("MyReco");
		submenu1.add(menuItem);
		submenu.add(submenu1);
		
		
		return menuBar;
		
	}
	
	public Container createContentPane(){
		
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		
		area = new JTextArea(10, 20);
		area.setEditable(false);
		pane = new JScrollPane(area);
		
		panel.add(pane, BorderLayout.CENTER);
		return panel;
	}
	
	//Create the GUI and show it
	private static void createAndShowGUI(){
		
		JFrame frame = new JFrame("MyDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyApp app = new MyApp();
		frame.setJMenuBar(app.createMenuBar());
		frame.setContentPane(app.createContentPane());
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
