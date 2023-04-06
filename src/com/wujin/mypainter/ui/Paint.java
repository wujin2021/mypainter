package com.wujin.mypainter.ui;

import java.awt.*;

import javax.swing.*;

import com.wujin.mypainter.listener.BtnLinstener;

import com.wujin.mypainter.listener.PaintPanel;

public class Paint extends JFrame{
	JPanel pnlCommandArea = new JPanel(new FlowLayout());
	public static PaintPanel pnlDisplayArea = new PaintPanel();//画板
	ShapeButton sbtn = new ShapeButton();//图形选择panel

	JButton clearbtn = new JButton("清空画板");
	JButton savebtn = new JButton("保存为图片");
	JButton savefilebtn = new JButton("保存为可编辑文件");
	JButton openfilebtn = new JButton("打开可编辑文件");
	private JToolBar toolbar = new JToolBar();
	public Paint() {
		pnlCommandArea.setLayout(new FlowLayout());		
		BtnLinstener btns = new BtnLinstener();
		JFrame jf = new JFrame("画图板");
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		toolbar.add(clearbtn);
		toolbar.add(savebtn);
		toolbar.add(savefilebtn);
		toolbar.add(openfilebtn);
		clearbtn.addActionListener(btns);
		savebtn.addActionListener(btns);
		savefilebtn.addActionListener(btns);
		openfilebtn.addActionListener(btns);
		jp.setBackground(Color.WHITE);
		jp.setLayout(new BorderLayout());
		jp.add(toolbar,BorderLayout.NORTH);
		jp1.add(sbtn);
		jp.add(jp1);
		jf.add(jp,BorderLayout.NORTH);
		jf.add(pnlDisplayArea);
		jf.setSize(800, 700);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
