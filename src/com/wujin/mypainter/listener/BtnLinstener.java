package com.wujin.mypainter.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.wujin.mypainter.tools.Function;
import com.wujin.mypainter.ui.DrawShapes;

/*
 * Button监听，获取Button内容
 * 画相应的图形
 */
public class BtnLinstener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton target = (JButton) e.getSource();
        String actionCommand = target.getActionCommand();
        if (actionCommand.contentEquals("直线")) {
            DrawShapes.type = DrawShapes.LINE;
        }
        if (actionCommand.contentEquals("矩形")) {
            DrawShapes.type = DrawShapes.RECT;
        }
        if (actionCommand.contentEquals("圆形")) {
            DrawShapes.type = DrawShapes.CIRCLE;
        }
        if (actionCommand.contentEquals("画笔")) {
            DrawShapes.type = DrawShapes.write;
        }
        if (actionCommand.contentEquals("清空画板")) {
            Function.clear();
        }
        if (actionCommand.contentEquals("保存为图片")) {
            Function.save();
        }
        if (actionCommand.contentEquals("保存为可编辑文件")) {
            Function.saveFile();
        }
        if (actionCommand.contentEquals("打开可编辑文件")) {
            Function.openFile();
        }
    }

}
