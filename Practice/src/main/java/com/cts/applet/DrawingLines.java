package com.cts.applet;

import java.awt.*;
import java.applet.*;

/*
 <applet code ="DrawingLines" width = 300 height = 300>
 </applet>
 */

public class DrawingLines extends Applet{
	
	
	private static final long serialVersionUID = 1L;
	int width, height;
	
	public void init(){
		width = getSize().width;
		height = getSize().height;
		setBackground(Color.black);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		for(int i=0; i<10; ++i){
			g.drawLine(width, height, i * width / 10, 0);
		}
	}

}
