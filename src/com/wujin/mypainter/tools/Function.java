package com.wujin.mypainter.tools;

import java.util.Stack;

import javax.swing.JOptionPane;

import com.wujin.mypainter.shape.Shape;
import com.wujin.mypainter.ui.DrawShapes;
import com.wujin.mypainter.ui.Paint;

/*
 * Function工具栏
 * 
 */
public class Function {
	/*
	 * redo栈
	 */
	public static Stack<Shape> rshape = new Stack<Shape>();
	/*
	 * save 方法 用于将画布保存成图片
	 */		
	public static void save() {
		Save s= new Save();
	}
	/*
	 * saveFile 方法 用于将画布保存成可编辑文件
	 */
	public static void saveFile() {
		SaveFile sa= new SaveFile();
	}
	/*
	 * openFile 方法 用于打开可编辑文件
	 */
	public static void openFile() {
		OpenFile op= new OpenFile();
	}

	/*
	 * clear 清空画板
	 * 清空shapes
	 */
	public static void clear() {
		
		if(!DrawShapes.shapes.isEmpty()) {
			int res = JOptionPane.showConfirmDialog(null, "是否清空画板？","",JOptionPane.YES_NO_OPTION);
			if(res == JOptionPane.YES_OPTION) {
				DrawShapes.shapes.clear();
				rshape.clear();
				Paint.pnlDisplayArea.repaint();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "画板为空！");
		}
	}
}
