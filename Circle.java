
/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import javax.swing.JComponent;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Rectangle2D.Double;

public class Circle extends JComponent implements ActionListener
{
    double posx;
    double posy;
    double rad;

    Ellipse2D.Double obstacles;
    Random gen = new Random();
    int posxran = gen.nextInt(5);
    int posyran = gen.nextInt(5);
    static int ransizegen = 60;
    int startpos;
    int starty;
    int startx;

   
    public Circle()
    {

        startpos = gen.nextInt(4);

        int size = gen.nextInt(ransizegen);
        rad = size+5;

       
        switch(startpos)
        {
            case 0:
            {
                starty = 0;
                startx = gen.nextInt(Starter.framewidth);
                break;
            }
            case 1: 
            {
                starty = Starter.frameheight; 
                startx = gen.nextInt(Starter.framewidth);
                break; 
            }
            case 2: 
            {
                startx = 0;
                starty = gen.nextInt(Starter.frameheight);
                break;
            }
            case 3: 
            {
                startx = Starter.framewidth;
                starty = gen.nextInt(Starter.frameheight);
                break;
            }
            default: 
            {
                startx = 0;
                starty = 0;
                break;
            }
        }
        posx = startx;
        posy = starty;
        obstacles = new Ellipse2D.Double(startx, starty, rad, rad);
    }

    public void move()
    {

        if(starty == 0)
        {
            posx = posx+posxran +1;
            posy = posy + posyran +1; 
        }
        else if (starty == Starter.frameheight)
        {
            posx = posx + posxran +1;
            posy = posy - posyran -1;
        }
        else if(startx == Starter.framewidth)
        {
            posx = posx - posxran - 1;
            posy = posy + posyran +1;
        }
        else if (startx ==0)
        {
            posx = posx + posxran +1;
            posy = posy - posyran - 1 ;
        }

    }

    public  void paint(Graphics2D g2)
    {
        Random col = new Random();
        int r= col.nextInt(255);
        int g= col.nextInt(255);
        int b= col.nextInt(255);

        g2.setColor(new Color(r,g,b));
        obstacles.setFrame(posx, posy, rad, rad);
        g2.draw(obstacles);
        g2.fill(obstacles);
        move();

        //}
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        paint(g2);

    }

    public void actionPerformed(ActionEvent e)//method signature of public mutator method actionPerformed with parameter variable e of class ActionEvent
    {
        //move(obstacles);
        // if(obstacles.getX() > Starter.framewidth || obstacles.getY() > Starter.frameheight) repaint();

    }

    public Ellipse2D getObstacle()
    {
        return obstacles;
    }

    //      public void increaseSizeRange()
    //      {
    //          sizeRangeStart+=2;
    //      }

}

