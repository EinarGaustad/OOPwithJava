package graphicalUserInterfaces;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Moving extends JComponent {
    
    private int   x, y, width, height;
    private Color color;
    
    /**
     * @param x
     * @param y
     * @param width
     * @param high
     */
    public Moving(int x, int y, int width, int high, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = high;
        this.color = color;
    }
    
    /**
     * 
     * You cannot draw directly onto a frame. Instead, drawing happens in a
     * component object. In the Swing toolkit, the JComponent class represents a
     * blank component.
     */
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(x, y, width, height);
        g2.setColor(color);
        g2.fill(box);
        g2.clearRect(x, y, width, height);
        g2.translate(200, 200);
        g2.fill(box);
    }
    
    public static void main(String[] args) {
        Moving m = new Moving(10, 10, 30, 40, new Color(0, 255, 255));
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(m);

        frame.setVisible(true);

    }
}
