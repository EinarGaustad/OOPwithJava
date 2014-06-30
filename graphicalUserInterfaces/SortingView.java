package graphicalUserInterfaces;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SortingView {
    
    //private int[]         table;
    private Elements      element     = new Elements(Color.WHITE,
                                              new Rectangle(10, 10));
    private MoveComponent mc          = new MoveComponent(element);
    private Control       control;
    private boolean       on;
    private final int     TIMER_DELAY = 50;
    
    /**
     * @param table
     * @param mc
     */
    public SortingView(int[] table) {
        this.on = true;
        this.control = new Control(table);


        new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actEvt) {
                if (on) {

                    actionPerform();
                    System.out.println("on");
                } else {
                    ((Timer) actEvt.getSource()).stop();
                }
            }
        }).start();


    }
    
    public void actionPerform() {
        element = new Elements(Color.red, new Rectangle(20, 50, 50, 50));
        mc = new MoveComponent(element);
        mc.validate();
        mc.repaint();
        System.out.println("action");
    }

    public void buildFrame() {
        JFrame frame = new JFrame();
        frame.setSize(600, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mc);
        frame.repaint();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final int[] table = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                SortingView sv = new SortingView(table);
                sv.buildFrame();
            }
        });
    }
}
