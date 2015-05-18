
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

public class Circle extends JComponent implements ActionListener//class Circle is a type of JComponent and implements the interface ActionListener
{
    //declare field variables 
    double posx;
    double posy;
    double rad;

    Ellipse2D.Double obstacles;
    Random gen = new Random();
    int posxran = gen.nextInt(5);//declare field variables and initialize it to a randomly generated integer between 0 and 4 (inclusive)
    int posyran = gen.nextInt(5);
    static int ransizegen = 60;
    int startpos;
    int starty;
    int startx;

   
    public Circle()//Circle constructor 
    {

        startpos = gen.nextInt(4);//initialize field variable startpos

        int size = gen.nextInt(ransizegen);//declare and initialize int size to the mutator method nextInt taking in variable ransizegen invoked on gen
        rad = size+5;//assign int size plus five to rad

       //switch statement for randomly generated starting location of circles
        switch(startpos)//take in int startpos
        {
            //case for north frame border
            case 0://if case is 0
            {
                starty = 0;//assign 0 to starty
                startx = gen.nextInt(Starter.framewidth);//assign a random integer between 0(inclusive) and the framewidth(exclusive) to 0
                break;//break
            }
            //case for south frame border
            case 1: 
            {
                starty = Starter.frameheight; 
                startx = gen.nextInt(Starter.framewidth);
                break; 
            }
            //case for west frame border
            case 2: 
            {
                startx = 0;
                starty = gen.nextInt(Starter.frameheight);
                break;
            }
            //case for east start border
            case 3: 
            {
                startx = Starter.framewidth;
                starty = gen.nextInt(Starter.frameheight);
                break;
            }
            //default case that sets the position to 0,0
            default: 
            {
                startx = 0;
                starty = 0;
                break;
            }
        }
        posx = startx;//assign startx to posx
        posy = starty;//assign starty to posy
        obstacles = new Ellipse2D.Double(startx, starty, rad, rad);//assign a newly construted object of Ellipse2D.Double with coordinates startx, starty and width and height rad to obstacles
    }

    public void move()//method signature for mutator method move
    {
        //if statements to make directions of circles different
        //if statements for corners not necessary because else if statements, so method will be determined by whichever if statement requirement is met first
        //if making circles starting on north border to travel diagonally down right
        if(starty == 0)//if starty is 0 including both corners
        {
            posx = posx+posxran +1;//assign posx + posxran + 1 to posx
            posy = posy + posyran +1; 
        }
        //else if statement for circles starting from the south border including both corners to travel diagonally up right
        else if (starty == Starter.frameheight)
        {
            posx = posx + posxran +1;
            posy = posy - posyran -1;
        }
        //else if statement for circles starting from the east border except for corners to travel diagonally left down
        else if(startx == Starter.framewidth)
        {
            posx = posx - posxran - 1;
            posy = posy + posyran +1;
        }
        //else if statement for circles starting from the west border except for corners to travel disagonally 
        else if (startx ==0)
        {
            posx = posx + posxran +1;
            posy = posy - posyran - 1;
        }
        
    }

    public void paint(Graphics2D g2)//mutator method paint that takes in an instance of the Graphics2D class as an explicit parameter
    {
        Random col = new Random();//declare col of class Random and initialize it to a newly constructed object of class Random
        int r= col.nextInt(255);//declare int r and initialize it to a generated int between 0 (inclusive) nd 255(exclusive)
        int g= col.nextInt(255);
        int b= col.nextInt(255);

        g2.setColor(new Color(r,g,b));//mutator method setColor taking in a newly constructed instance of class Color invoked on g2  
        obstacles.setFrame(posx, posy, rad, rad);//mutator method setFrame taking in explicit parameters of a x and y coordinate an rad width and rad height invoked on obstacles
        g2.draw(obstacles);//invoke mutator draw with explicit parameter obstacles on g2
        g2.fill(obstacles);//invoke fill on g2 with explict parameter obstacles
        move();//call upon the move method

       
    }

    public void paintComponent(Graphics g)//overriding mutator paintComponent of the JComponenent lass
    {
        Graphics2D g2 = (Graphics2D) g;//assign g type casted as a Graphics2D to an instance g2 of the Graphics2D class

        paint(g2);//call upon method paint taking in g2

    }

    public void actionPerformed(ActionEvent e)//overriding public mutator method actionPerformed from the ActionListener interface with parameter variable e of class ActionEvent
    {
       

    }

    public Ellipse2D getObstacle()//method declaration for an accesor method returning an Ellipse2D
    {
        return obstacles;//return Ellipse2D.Double obstacles
    }


}

