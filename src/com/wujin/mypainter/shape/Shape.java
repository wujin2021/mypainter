package com.wujin.mypainter.shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/*
 * Shape图形类
 *
 *
 */

public class Shape {
    protected Vector<ScreenPoint> points = new Vector<ScreenPoint>();
    protected Color color; //颜色
    protected int Thickness; //粗细
    protected Point min; //
    protected int w; //宽度
    protected int h; //高度

    public Shape(Color color, int Thickness, int x1, int y1, int x2, int y2) {
        min = new Point(Math.min(x1, x2), Math.min(y1, y2));
        this.color = color;
        this.Thickness = Thickness;
        points.add(new ScreenPoint(x1, y1));
        points.add(new ScreenPoint(x2, y2));
        w = Math.abs(x2 - x1);
        h = Math.abs(y2 - y1);
    }

    public Shape(FileReader fileReader) throws IOException {
        char[] c = new char[10];
        fileReader.read(c, 0, 10);
        color = new Color(Integer.parseInt(new String(c)));
        fileReader.read(c, 0, 10);
        Thickness = Integer.parseInt(new String(c));
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
        w = Math.abs(x2 - x1);
        h = Math.abs(y2 - y1);
        min = new Point(Math.min(x1, x2), Math.min(y1, y2));
    }

    public Shape() {

    }

    //public void print(PrintWriter pWriter) {/*打印图形信息*/
    //	pWriter.printf("%010d%010d%010d%010d%010d%010d\r\n", color.getRGB(),Thickness,points.elementAt(0).x,
    //			points.elementAt(0).y, points.elementAt(1).x, points.elementAt(1).y);
    //}
    public void DrawShape(Graphics2D g) {/*画图*/

    }

    public void output(PrintWriter printWriter) {
        printWriter.printf("%010d%010d%010d%010d%010d%010d\r\n", color.getRGB(), Thickness, points.elementAt(0).x,
                points.elementAt(0).y, points.elementAt(1).x, points.elementAt(1).y);

    }
}