package com.wujin.mypainter.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/*
 * 圆形
 */

public class DrawCircle extends Shape {
    public DrawCircle(Color color, int Thickness, int x1, int y1, int x2, int y2) {
        super(color, Thickness, x1, y1, x2, y2);
    }

    //public void print(PrintWriter pWriter) {
    //	super.print(pWriter);
    //}
    public DrawCircle(FileReader fileReader) throws IOException {
        super(fileReader);
    }

    public void DrawShape(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(Thickness));
        g.drawOval(min.x, min.y, w, h);
    }

    public void output(PrintWriter printWriter) {
        printWriter.printf("C");
        super.output(printWriter);

    }
}
