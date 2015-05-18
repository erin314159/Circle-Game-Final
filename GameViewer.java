import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
/**
 * Write a description of class GameViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameViewer extends JComponent //draws all the components for the frame
{
    private ArrayList<Circle> circles = new ArrayList<Circle>();//declaring and initializing an ArrayList of circles
    static String s = "";//statics variables for showing score, can be acccessed in the Starter class 
    static String score = "";
    public GameViewer() //constructor for gameviewer class 
    {
    }
    
    
    public void paintComponent(Graphics g) //method in JComponent class that paints all the elements in the circles ArrayList, as well as drawing the strings for the score at the end
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle2D.Double(0,0,Starter.framewidth, Starter.frameheight));//draws a black rectangle as the background 
        for(Circle circle : circles) circle.paint((Graphics2D)g);
        g2.setColor(Color.WHITE);//sets color to white
        g2.setFont(new Font(Font.SERIF,Font.PLAIN, 70));//sets font to a new font 
        g2.drawString(score, 200, 400);//draws string game over at coordinates 200, 400 with the font created above
        g2.drawString(s, 300, 300);//draws string for score
    }
    
    public void add(Circle circle)//mutator method that adds a desired circle to the arraylist and repaints the JComponent
    {
        circles.add(circle);//adds circle to arraylist
        this.repaint();//repaints the game viewer 
    }
    
    public void remove(Circle circle)//mutator method that removes desired circle 
    {
        circles.remove(circle);//removes circle from arraylist 
        this.repaint();
    }
    
    public ArrayList<Circle> getArrayList()//accessor method that returns the circles array list
    {
        return circles;
    }
}
