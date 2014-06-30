package graphicalUserInterfaces;

import java.awt.Color;
import java.awt.Rectangle;

public class Elements {
    
    Color     color;
    Rectangle rectangle;
    
    /**
     * @param color
     * @param rectangle
     */
    public Elements(Color color, Rectangle rectangle) {
        super();
        this.color = color;
        this.rectangle = rectangle;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public Rectangle getRectangle() {
        return rectangle;
    }
    
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    
}
