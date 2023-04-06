package com.wujin.mypainter.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.wujin.mypainter.ui.DrawShapes;
import com.wujin.mypainter.shape.Shape;

public class SaveFile {
    FileWriter fileWriter;
    PrintWriter printWriter;
    JFileChooser jFileChooser;
    public static boolean hassave=true;
    public SaveFile() {
        // TODO Auto-generated constructor stub
        jFileChooser=new JFileChooser();
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
        //设置文件路径
        jFileChooser.setCurrentDirectory(new File("./"));
        //设置默认文件名
        jFileChooser.setSelectedFile(new File("未命名.txt"));
        //jFileChooser.setFileFilter(filenameFilter);
        jFileChooser.showSaveDialog(null);
        try {
            fileWriter =new FileWriter(jFileChooser.getSelectedFile());
            printWriter = new PrintWriter(fileWriter);
            for (Shape s : DrawShapes.shapes)
                s.output(printWriter);
            printWriter.close();
            fileWriter.close();
            hassave=true;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

