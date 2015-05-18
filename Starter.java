
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
public class Starter
{
    //declaration of static field variables that can be accessed outside the class
    public static JFrame frame;
    public static GameViewer viewer;
    public static int framewidth = 1000;//declaration of static int variable framewidth and intialize it to 1000 
    public static int frameheight = 1000;

    public static MainCircle mc;
    public static int count;
    public static Timer t2;
    public static void main(String[]args)//method signature for mutator method main
    {
        //inititalize field variables
        frame = new JFrame("The Circle Game");
        frame.setSize(framewidth,frameheight);
        viewer = new GameViewer();
        mc = new MainCircle();
        viewer.add(mc);//mutator method add taking in mc invoked on viewer
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//mutator method setDefaultCloseOpertion invoked on frame
        count = 0;
        frame.add(viewer);//add viewer to the frame, mutator method add taking in viewer invoked on frame
        frame.setVisible(true);//mutator setVisible taking in boolean value true invoked on frame
        class MainCircleListener implements MouseMotionListener, ActionListener// class implements interfaces MouseMotionLIstener and ActionListener
        {
            //overriding methods declared in the interface
            public void mouseDragged(MouseEvent e){//method that allows touchscreen to work
                mc.x = e.getX() - mc.w / 2;//assign the xmouseposition minus the width/2 of the mc to the x position of the MainCircle
                mc.y = e.getY() - mc.w / 2;
            }

            public void mouseMoved(MouseEvent e)//method for regular mouse, but same code as above
            {
                mc.x = e.getX() - mc.w / 2;
                mc.y = e.getY() - mc.w / 2;

            }

            public void actionPerformed(ActionEvent e)//method signature of public mutator method actionPerformed with parameter variable e of class ActionEvent
            {

            }
        }

        class Timerloop implements ActionListener//class implements interface ActionListener
        {
            //overriding interface methods
            public void actionPerformed(ActionEvent e)//method signature for mutator actionPerformed that takes in ActionEvent e
            {
                Circle a = new Circle();//declare and initialize object reference a
                viewer.add(a);//invoke add taking in explicit parameter a on viewer 
                frame.add(a); 
                a.move();//invoke move on a
                viewer.repaint();//invoke paint on viewer
                for(int i=1;i<viewer.getArrayList().size();i++)// for loop( declare and initialize i; i is less than the size of the viewer ArrayList; increment i by i)
                {
                    if(viewer.getArrayList().get(i).getObstacle().getX() > framewidth || viewer.getArrayList().get(i).getObstacle().getY() > frameheight) viewer.remove(viewer.getArrayList().get(i));//if a circle object in the viewer ArrayList is outside the frame then remove the circle from the ArrayList

                    if(mc.getCircle().intersects(viewer.getArrayList().get(i).getObstacle().getFrame())&& viewer.getArrayList().get(i).rad <= mc.w)
                    {

                        viewer.remove(viewer.getArrayList().get(i));
                        count++;
                        mc.enlarge();
                        if (count%2 == 0)
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

                            viewer.remove(mc);
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
