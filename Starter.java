
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
        class MainCircleListener implements MouseMotionListener
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

                    if(mc.getCircle().intersects(viewer.getArrayList().get(i).getObstacle().getFrame())&& viewer.getArrayList().get(i).rad <= mc.w)//if statement to test intersection of maincircle and other circle, also checks if radius size of mc is greater than the other circle
                    {

                        viewer.remove(viewer.getArrayList().get(i));//removes the element from the viewer arraylist 
                        count++;//count increases by 1, counts the number of circles removed
                        mc.enlarge();//increases width of the circle 
                        if (count%1 == 0)//algorithm forr increases surrounding circles for every circle the main circle removes
                        {
                            Circle.ransizegen = Circle.ransizegen + 1;//increases ransizegen by 1 
                        }
                    }
                    try{//try catch statement to catch the index out of bounds expection and prevent crashing 
                        if(mc.getCircle().intersects(viewer.getArrayList().get(i).getObstacle().getFrame())&&viewer.getArrayList().get(i).rad > mc.w)//if statement to test if the circle that mc intersects is greater than mc
                        {
                            t2.stop(); //the game stops, so the timer for producing circles stops
                            viewer.s= "GAME OVER";//sets the string value to game over so that it appears on the screen once the game ends
 
                            viewer.score = "Score:" + Integer.toString(count);//same as above but displays score by converting the count into a string

                            viewer.remove(mc);//removes mc from viewer array list, no longer shown/useable 
                        }
                    }
                    catch(IndexOutOfBoundsException p){}
                }
            }
        }
        MainCircleListener listener = new MainCircleListener();//constructing new instance of maincirclelistener class
        frame.addMouseMotionListener(listener);//adds listener to the frame
         

        Timerloop tl = new Timerloop();//constructs new instance of TImerloop 
        t2 = new Timer(100, tl);//initializising timer t2
        t2.start();//starts timer 

    }
}
