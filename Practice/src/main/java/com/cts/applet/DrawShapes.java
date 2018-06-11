package com.cts.applet;

import java.awt.*;
import java.applet.*;

/*
 <applet code = "DrawShapes" width=300 height=50>
 </applet>
 */

public class DrawShapes extends Applet{
	
	
	private static final long serialVersionUID = 1L;
	int x=300,y=100,r=50;
	
	public void paint(Graphics g){
		
		g.drawLine(3, 300, 200, 10);
		g.drawString("Line",100,100);
		g.drawOval(x-r,y-r,100,100);
		g.drawString("Circle",275,100);
		g.drawRect(400,50,200,100);
		g.drawString("Rectangle",450,100);


	}

}
