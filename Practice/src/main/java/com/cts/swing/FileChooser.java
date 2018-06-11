package com.cts.swing;
import javax.swing.JFileChooser;
import java.io.File;

public class FileChooser {
	
	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		File f = new File("E:/pics");
		chooser.setCurrentDirectory(f);
		chooser.showOpenDialog(null);
		File f2 = chooser.getSelectedFile();
		

	}

}
