
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
   public int x;//instance field variables 
   public int y;
   public static int w;//static variable for main circle size, able to access from 
   public Ellipse2D.Double mCircle;
   public MainCircle()
   {
       x = Starter.framewidth/2;
       y = Starter.frameheight/2;
       w=20;
    }
    public void paint(Graphics2D g)//method that paints the main Circle
    {
        Graphics2D g2 = (Graphics2D) g;
         mCircle = new Ellipse2D.Double(x,y,w,w);
        g2.setColor(Color.WHITE);
        g2.fill(mCircle);
    }
    public void enlarge()//mutator method for increasing the width of the circle
    {
        w=w+1;//adds 1 to w, or the height and width 
    }
    public Ellipse2D getCircle()//accessor method to return the Ellipse2D mCircle 
    {
        return mCircle;
    }
}
