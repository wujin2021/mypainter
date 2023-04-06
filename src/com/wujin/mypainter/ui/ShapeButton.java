package com.wujin.mypainter.ui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import com.wujin.mypainter.listener.BtnLinstener;

public class ShapeButton extends JPanel{
	
	BtnLinstener btns = new BtnLinstener();
	
	private JButton
		btn1 = new JButton( "矩形"),
		btn2 = new JButton("圆形"),
		btn3 = new JButton("直线"),
		btn4 = new JButton("画笔");
	
	public ShapeButton() {
		super(new GridLayout(1, 1));
		setPreferredSize(new Dimension(300, 30));
		btn1.addActionListener(btns);
		btn2.addActionListener(btns);
		btn3.addActionListener(btns);
		btn4.addActionListener(btns);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
	}
}
