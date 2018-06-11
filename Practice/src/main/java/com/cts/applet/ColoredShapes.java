package com.cts.applet;

import java.awt.*;
import java.applet.*;

/*
 <applet code = "ColoredShapes" width = 300 height = 400>
 </applet>
 */

public class ColoredShapes extends Applet{
	
	private static final long serialVersionUID = 1L;
	int wid, ht;
	
	public void init(){		
		wid = getSize().width;
		ht = getSize().height;
		setBackground(Color.BLACK);
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.RED);
		g.drawRect(10, 10, 80, 15);
		g.setColor(Color.PINK);
		g.fillRect(250, 10, 100, 20);
		
		
		g.setColor(Color.BLUE);
		g.drawOval( 80, 225, 100, 50 );
	    g.setColor( Color.orange );
	    g.fillOval( 100, 37, 50, 25 );


	}
	
	

}
