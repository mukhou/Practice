package com.cts.swing;

import javax.swing.*;

public class HelloWorldSwing {
	
	private static void createGUI(){
		
		//create window
		JFrame frame = new JFrame("Hello World Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Hello World-----------Java Tutorials");
		frame.getContentPane().add(label);
		
		//display window
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable() {
			
			
			public void run() {
				createGUI();
				
			}
		});
	}

}
