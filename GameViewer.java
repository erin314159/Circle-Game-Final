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
    private ArrayList<Circle> circles = new ArrayList<Circle>();
    String s = "";
    String score = "";
    public GameViewer() 
    {
    }
    
    
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle2D.Double(0,0,Starter.framewidth, Starter.frameheight));
        for(Circle circle : circles) circle.paint((Graphics2D)g);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font(Font.SERIF,Font.PLAIN, 70));
        g2.drawString(score, 200, 400);
        g2.drawString(s, 300, 300);
    }
    
    public void add(Circle circle)
    {
        circles.add(circle);
        this.repaint();
    }
    
    public void remove(Circle circle)
    {
        circles.remove(circle);
        this.repaint();
    }
    
    public ArrayList<Circle> getArrayList()
    {
        return circles;
    }
}
