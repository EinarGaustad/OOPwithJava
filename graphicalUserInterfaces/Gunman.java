package graphicalUserInterfaces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gunman extends JComponent {
    
    private static final long serialVersionUID = 1L;
    private static final int  PREF_W           = 900;
    private static final int  PREF_H           = 700;
    private static final int  TIMER_DELAY      = 30;
    public int                rectX            = 10;
    public int                rectY            = 10;
    public int                width            = 8;
    public int                height           = 10;
    
    public Gunman() {
        new Timer(TIMER_DELAY, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent actEvt) {
                System.out.println("action performed 1");
                if (rectX < PREF_W && rectY < PREF_H) {
                    rectX += 20;
                    rectY += 20;
                    System.out.println("rectX: " + rectX + " rectY: " + rectY);
                    repaint();
                } else {
                    ((Timer) actEvt.getSource()).stop();
                    System.out.println("timer act stop..");
                }
            }
        }).start();
    }
    
    @Override
    public Dimension getPreferredSize() {
        System.out.println("Dimension getPreferredSized called");
        return new Dimension(PREF_W, PREF_H);
    }
    
    public void paintComponent(Graphics g) {
        System.out.println("paint comonet called draw : rectX: " + rectX);
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawRect(rectX, rectY, width, height);
        g.fillRect(rectX, rectY, width, height);
    }
    
    //    public int getRectX() {
    //        return rectX;
    //    }
    //    
    //    public void setRectX(int rectX) {
    //        this.rectX = rectX;
    //    }
    //    
    //    public int getRectY() {
    //        return rectY;
    //    }
    //    
    //    public void setRectY(int rectY) {
    //        this.rectY = rectY;
    //    }

    private static void createAndShowGui() {
        //        System.out.println("create and show gui called");
        Gunman mainPanel = new Gunman();
        //        System.out.println("created main panel (self)");
        JFrame frame = new JFrame("Gunman");
        //        System.out.println("creaded new JFrame");
        //        frame.setSize(PREF_H, PREF_W);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        //        System.out.println("geted frame.get content pane().add(mainPanel)");
        frame.pack();
        //        System.out.println("pack() done");
        frame.setLocationByPlatform(true);
        //        System.out.println("set location by platform done");
        frame.setVisible(true);
        //        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("main method called");
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                System.out.println("void run() called");
                createAndShowGui();
            }
        });
    }

}