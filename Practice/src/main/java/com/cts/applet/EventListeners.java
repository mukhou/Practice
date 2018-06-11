package com.cts.applet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

/*
 *<applet code ="EventListeners" width = 500 height = 500 >
 *<applet>
 */

public class EventListeners extends Applet implements ActionListener {

	private static final long serialVersionUID = 1L;
	TextArea textArea;	
	int i = 10, j = 20, sum = 0, sub = 0;

	public void init() {
		textArea = new TextArea(50, 80);
		textArea.setEditable(false);
		add(textArea);
		Button b = new Button("Add");
		Button c = new Button("Subtract");
		b.addActionListener(this);
		c.addActionListener(this);
		add(b);
		add(c);
	}

	public void actionPerformed(ActionEvent e) {
		sum = i + j;
		textArea.append("i= " + i + "\t" + "j= " + j + "\n");
		Button source = (Button) e.getSource();
		if (source.getLabel().equalsIgnoreCase("Add")) {
			textArea.append("Sum :" + sum + "\n");
		}
		if (i > j) {
			sub = i - j;

		} else {
			sub = j - i;
		}
		if (source.getLabel().equalsIgnoreCase("Subtract")) {
			textArea.append("Sub :" + sub + "\n");
		}

	}

}
