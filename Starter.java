
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
public class Starter
{
    public static JFrame frame;//declare public static variable frame of class JFrame
    public static GameViewer viewer;
    public static int framewidth = 1000;
    public static int frameheight = 1000;
    //public static Circle c;
    public static MainCircle mc;
    public static int count;
    public static Timer t2;
    public static void main(String[]args)
    {
        frame = new JFrame("The Circle Game");
        frame.setSize(framewidth,frameheight);
        viewer = new GameViewer();
        mc = new MainCircle();
        viewer.add(mc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        count = 0;

        frame.add(viewer);
        //frame.setResizable(false);
        frame.setVisible(true);
        class MainCircleListener implements MouseMotionListener, ActionListener
        {
            public void mouseDragged(MouseEvent e){
                mc.x = e.getX() - mc.w / 2;
                mc.y = e.getY() - mc.w / 2;
            }

            public void mouseMoved(MouseEvent e)
            {
                mc.x = e.getX() - mc.w / 2;
                mc.y = e.getY() - mc.w / 2;

            }
            public void actionPerformed(ActionEvent e)//method signature of public mutator method actionPerformed with parameter variable e of class ActionEvent
            {

            }
        }

        class Timerloop implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Circle a = new Circle();
                viewer.add(a);
                frame.add(a); 
                a.move();
                viewer.repaint();
                for(int i=1;i<viewer.getArrayList().size();i++)
                {
                    //                     if(c.getX()>800||c.getX()<0)
                    //                     {
                    //                         viewer.remove(c);
                    //                         frame.remove(c);
                    //                     }
                    //                     if(c.getY()>800||c.getY()<0)
                    //                     {
                    //                         viewer.remove(c);
                    //                         frame.remove(c);
                    //                     }
                    if(viewer.getArrayList().get(i).getObstacle().getX() > framewidth || viewer.getArrayList().get(i).getObstacle().getY() > frameheight) viewer.remove(viewer.getArrayList().get(i));
                    
                    if(mc.getCircle().intersects(viewer.getArrayList().get(i).getObstacle().getFrame())&& viewer.getArrayList().get(i).rad <= mc.w)
                    {
                     
                        viewer.remove(viewer.getArrayList().get(i));
                        count++;
                        mc.enlarge();
                        if (count%5 == 0)
                        {
                       Circle.ransizegen = Circle.ransizegen + 1;
                    }
                    }
                    try{
                    if(mc.getCircle().intersects(viewer.getArrayList().get(i).getObstacle().getFrame())&&viewer.getArrayList().get(i).rad > mc.w)
                    {
                        t2.stop(); 
                        viewer.s= "GAME OVER";
                         
                         
                         
                        
                          
                         viewer.score = "Score:" + Integer.toString(count);
                         
                         //viewer.remove(mc);
                    }
                }
                catch(IndexOutOfBoundsException p){}
                }
               
                
            }

        }
        
        MainCircleListener listener = new MainCircleListener();
        frame.addMouseMotionListener(listener);
        Timer t = new Timer(100,listener);
        t.start(); 

        Timerloop tl = new Timerloop();
        t2 = new Timer(100, tl);
        t2.start();

      
    }

}

