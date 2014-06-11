package graphicalUserInterfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class RectangleComponent extends JComponent {
    
    private int x, y, width, high;
    private Color color;
    
    /**
     * @param x
     * @param y
     * @param width
     * @param high
     */
    public RectangleComponent(int x, int y, int width, int high, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.high = high;
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
        Rectangle box = new Rectangle(x, y, width, high);
        g2.draw(box);
        g2.setColor(color);
        g2.fill(box);
    }
}
