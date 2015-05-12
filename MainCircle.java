
/**
 * Write a description of class MainCircle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JComponent;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import java.awt.Color;
public class MainCircle extends Circle
{
   public int x;
   public int y;
   public int w;
   public Ellipse2D.Double mCircle;
   public MainCircle()
   {
       x = Starter.framewidth/2;
       y = Starter.frameheight/2;
       w=20;
    }
    public void paint(Graphics2D g)
    {
        Graphics2D g2 = (Graphics2D) g;
         mCircle = new Ellipse2D.Double(x,y,w,w);
        g2.setColor(Color.WHITE);
        g2.fill(mCircle);
    }
    public void enlarge()
    {
        w=w+1;
    }
    public Ellipse2D getCircle()
    {
        return mCircle;
    }
}
