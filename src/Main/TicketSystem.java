/**
 * Driver class to run the app, adds panel from TicketGUI to it's Frame
 */
package Main;

import javax.swing.JFrame;

/**
 *
 * @author Craig, q5031372
 */
public class TicketSystem
{

    /**
     *
     * @param args
     */
    public static void main(String args[])
    {
        // create a new frame
        JFrame frame = new JFrame();

        // add the gui to the frame
        TicketGUI panel = new TicketGUI();
        frame.add(panel);

        // set frames properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1000);
        frame.setResizable(true);
        frame.setVisible(true); // make the frame visible 
    }
}
