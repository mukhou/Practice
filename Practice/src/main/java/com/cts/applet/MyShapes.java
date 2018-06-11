package com.cts.applet;

import java.awt.*;
import java.applet.*;

/*
 * <applet code = "MyShapes" width = 500 height = 500>
 * </applet>
 */

public class MyShapes extends Applet{
	
	
	private static final long serialVersionUID = 1L;
	int width, height;
	
	public void init(){
		width = getWidth();
		height = getHeight();
		setBackground(Color.ORANGE);
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.RED);
		g.drawOval(50, 10, 60, 40);
		g.setColor(Color.GREEN);
		g.fillRoundRect(20, 50, 120, 40, 30, 10);
		
	}

}
