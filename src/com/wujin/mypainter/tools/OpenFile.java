package com.wujin.mypainter.tools;

import com.wujin.mypainter.listener.PaintPanel;
import com.wujin.mypainter.ui.DrawShapes;
import com.wujin.mypainter.shape.DrawCircle;
import com.wujin.mypainter.shape.DrawDot;
import com.wujin.mypainter.shape.DrawLine;
import com.wujin.mypainter.shape.DrawRect;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.wujin.mypainter.ui.Paint.pnlDisplayArea;

public class OpenFile {
	FileReader fileReader;
	JFileChooser jFileChooser;

	public OpenFile() {
		// TODO Auto-generated constructor stub
		jFileChooser = new JFileChooser();
		jFileChooser.setCurrentDirectory(new File("./"));
		FileFilter filenameFilter=new FileFilter() {
			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return false;
				}
				if (f.getName().endsWith("txt")){
					return true;
				}
				else {
					return false;
				}
			}

			@Override
			public String getDescription() {
				return null;
			}
		};
		jFileChooser.setFileFilter(filenameFilter);
		jFileChooser.showOpenDialog(null);
		DrawShapes.shapes.clear();
		try {
			fileReader = new FileReader(jFileChooser.getSelectedFile());
			while (fileReader.ready()) {
				switch (fileReader.read()) {
				case 'C':
					DrawShapes.shapes.add(new DrawCircle(fileReader));
					break;
				case 'L':
					DrawShapes.shapes.add(new DrawLine(fileReader));
					break;
				case 'R':
					DrawShapes.shapes.add(new DrawRect(fileReader));
					break;
				case 'D':
					DrawDot dot = new DrawDot(fileReader);
					int a = 'G';
					fileReader.read();
					fileReader.read();
					while (a == fileReader.read()) {
						dot.readmore(fileReader);
						fileReader.read();
						fileReader.read();
					}
					DrawShapes.shapes.add(dot);
				}
			}
			fileReader.close();
			pnlDisplayArea.updateGraphics(); // 刷新画布
			JOptionPane.showMessageDialog(null, "Open Success", "Message", 1);

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//
			e.printStackTrace();
		}
	}

}
