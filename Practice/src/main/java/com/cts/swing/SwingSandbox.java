package com.cts.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SwingSandbox {
	private File file;

	  public SwingSandbox() {
	    final JFrame frame = new JFrame("Hello");

	    JButton btnFile = new JButton("Select Excel File");
	    btnFile.addActionListener(new ActionListener() {
	        //Handle open button action.
	        public void actionPerformed(ActionEvent e) {
	            final JFileChooser fc = new JFileChooser(); 
	            int returnVal = fc.showOpenDialog(frame);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                file = fc.getSelectedFile();
	                //This is where a real application would open the file.
	                System.out.println("File: " + file.getName() + ".");    
	            } else {
	                System.out.println("Open command cancelled by user.");
	            }
	            System.out.println(returnVal);
	        }
	    });

	    frame.getContentPane().add(btnFile);
	    frame.setSize(100, 100);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	  }


	  public static void main(String[] args) throws Exception {
	    new SwingSandbox();
	  }

}
