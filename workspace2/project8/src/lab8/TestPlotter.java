package lab8;
import java.awt.Point;
import java.util.*;
import java.awt.*;

import plotter.Plotter;
import plotter.Polyline;

public class TestPlotter
{
  public static void main(String[] args)
  {   
	 ArrayList<Polyline> arrPol = new ArrayList<>(); 
    // make a red square using default line width of one pixel
    Polyline pl = new Polyline("red");
    pl.addPoint(new Point(100, 100));
    pl.addPoint(new Point(200, 100));
    pl.addPoint(new Point(200, 200));
    pl.addPoint(new Point(100, 200));
    pl.addPoint(new Point(100, 100));
    
    // make a blue triangle with a line width of 2 pixels
    Polyline pl2 = new Polyline("blue", 2);
    pl2.addPoint(new Point(250, 100));
    pl2.addPoint(new Point(400, 350));
    pl2.addPoint(new Point(100, 350));
    pl2.addPoint(new Point(250, 100));
    
    // make some green zig-zags with a thick line
    Polyline pl3 = new Polyline("green", 6);
    pl3.addPoint(new Point(100, 400));
    pl3.addPoint(new Point(200, 450));
    pl3.addPoint(new Point(300, 400));
    pl3.addPoint(new Point(400, 450));
    arrPol.add(pl3);
    
    // plot the three polylines using the plotter
    Plotter plotter = new Plotter();
    System.out.println(pl);
    plotter.plot(pl);
    plotter.plot(pl2);
    plotter.plot(pl3);
  }
}