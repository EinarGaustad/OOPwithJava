package graphicalUserInterfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MovingTest {
    
    private MovingTestComponent mtc;
    
    //private int[]               table;

    public MovingTest(int[] table) {
        //this.table = table;
        mtc = new MovingTestComponent(table);
        new Timer(100, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent actEvt) {
                boolean stop = false;
                if (!stop) {
                    mtc.moveComponent();
                    mtc.revalidate();
                    mtc.repaint();
                } else {
                    ((Timer) actEvt.getSource()).stop();
                    System.out.println("timer act stop..");
                }
            }
        }).start();
    }
    
    public void buildFrame() {
        JFrame frame = new JFrame();
        frame.setSize(600, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mtc);
        frame.repaint();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final int[] table = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new MovingTest(table).buildFrame();
            }
        });
    }
}
