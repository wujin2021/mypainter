package com.wujin.mypainter.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 随手写（连续画出鼠标点）
 */
public class DrawDot extends Shape {
    //private int num;
    public DrawDot() {
        // TODO Auto-generated constructor stub
    }

    public DrawDot(Color color, int Thickness, int x1, int y1, int x2, int y2) {
        super(color, Thickness, x1, y1, x2, y2);
    }

    public DrawDot(FileReader fileReader) throws IOException {
        super(fileReader);

    }


    public void DrawShape(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(Thickness));
        int i = 0, j = 1;
        while (points.size() > i) {
            g.drawLine(points.elementAt(i).x, points.elementAt(i).y, points.elementAt(j).x, points.elementAt(j).y);
            i = i + 2;
            j = j + 2;
        }

    }

    public void output(PrintWriter printWriter) {
        printWriter.printf("D");
        printWriter.printf("%010d%010d%010d%010d%010d%010d\r\n", color.getRGB(), Thickness, points.elementAt(0).x,
                points.elementAt(0).y, points.elementAt(1).x, points.elementAt(1).y);
        int i = 2, j = 3;
        while (points.size() > i) {
            printWriter.printf("G");
            printWriter.printf("%010d%010d%010d%010d\r\n", points.elementAt(i).x,
                    points.elementAt(i).y, points.elementAt(j).x, points.elementAt(j).y);
            i = i + 2;
            j = j + 2;
        }
        printWriter.printf("F\r\n");
    }

    //public void print(PrintWriter pWriter) {
    //	super.print(pWriter);
    //}
    public void addpoint(int x1, int y1, int x2, int y2) {
        // TODO Auto-generated method stub
        points.add(new ScreenPoint(x1, y1));
        points.add(new ScreenPoint(x2, y2));
    }

    public void setcolorthick(Color color0, int thick) {
        Thickness = thick;
        color = color0;
    }

    public void readmore(FileReader fileReader) throws IOException {
        char[] c = new char[10];
        fileReader.read(c, 0, 10);
        int x1 = Integer.parseInt(new String(c));
        fileReader.read(c, 0, 10);
        int y1 = Integer.parseInt(new String(c));
        points.add(new ScreenPoint(x1, y1));
        fileReader.read(c, 0, 10);
        int x2 = Integer.parseInt(new String(c));
        fileReader.read(c, 0, 10);
        int y2 = Integer.parseInt(new String(c));
        points.add(new ScreenPoint(x2, y2));
    }
}
