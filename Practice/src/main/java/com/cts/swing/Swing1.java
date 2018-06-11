package com.cts.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Swing1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Swing1() {
		setTitle("First Swing Example");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable() {			
			
			public void run() {
				Swing1 swing1 = new Swing1();
				swing1.setVisible(true);
				
			}
		});
	}

}
