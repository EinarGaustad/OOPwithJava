package graphicalUserInterfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class MoveComponent extends JComponent {
    
    private static final long serialVersionUID = 1L;
    private Rectangle         rectangle;
    private Color             color;
    

    /**
     * @param rectangle
     * @param color
     */
    public MoveComponent(Elements element) {
        super();
        this.rectangle = element.getRectangle();
        this.color = element.getColor();
    }


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(color);
        ((Graphics2D) g).fill(rectangle);
    }
}
