package com.cts.applet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

/*
 * <applet code = "MyEventListener" width=500 height=500 >
 * </applet>
 */


public class MyEventListener extends Applet implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	int x=50, y=25, sum=0, sub=0, mult=0, div=0;
	//String Add, Subtract, Multiply, Divide;
	TextArea txtarea;
	
	public void init(){
		txtarea = new TextArea();
		add(txtarea);
		Button addBtn = new Button("Add");
		Button subBtn = new Button("Subtract");
		Button multBtn = new Button("Multiply");
		Button divBtn = new Button("Divide");
		
		addBtn.addActionListener(this);
		subBtn.addActionListener(this);
		multBtn.addActionListener(this);
		divBtn.addActionListener(this);
		
		add(addBtn);
		add(subBtn);
		add(multBtn);
		add(divBtn);
		
		addBtn.setBackground(Color.RED);
		subBtn.setBackground(Color.BLUE);
		multBtn.setBackground(Color.PINK);
		divBtn.setBackground(Color.GREEN);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		txtarea.append("x: " + x + "\n" + "y: " + y +"\n");
		sum = x+y;
		mult = x*y;
		if(x>y){
			sub = x-y;
		}else{
			sub = y-x;
		}
		if(x>y){
			div = x/y;
		}else{
			div = y/x;
		}		
		
		Button src = (Button)e.getSource();
		
		if(src.getLabel().equalsIgnoreCase("Add")){
			txtarea.append("Sum :" + sum + "\n");
		}else if(src.getLabel().equalsIgnoreCase("Subtract")){
			txtarea.append("Subtraction :" + sub + "\n");
		}else if(src.getLabel().equalsIgnoreCase("Multiply")){
			txtarea.append("Multiplication :" + mult + "\n");			
		}else if(src.getLabel().equalsIgnoreCase("Divide")){
			txtarea.append("Division :" + div + "\n");
		}
		
		
	}
	
	

}
