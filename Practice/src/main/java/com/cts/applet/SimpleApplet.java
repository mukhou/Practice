package com.cts.applet;


import java.awt.*;
import java.applet.*;


/*
<applet code = "DrawShapes" width=300 height=50>
</applet>
*/

public class SimpleApplet extends Applet{
	
	
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g){
		g.drawString("My first Applet", 20, 20);
	}

}
