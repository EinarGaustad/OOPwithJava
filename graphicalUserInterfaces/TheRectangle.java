package graphicalUserInterfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class TheRectangle {
    
    private int        x, y, height;
    private Graphics2D graphysics2D;
    private Rectangle  box;
    private Color      color;
    
    /**
     * @param x
     * @param y
     * @param height
     * @param graphysics2d
     * @param box
     * @param color
     */
    public TheRectangle(int x, int y, int height, Graphics2D graphysics2d,
            Rectangle box, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.height = height;
        graphysics2D = graphysics2d;
        this.box = box;
        this.color = color;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public Graphics2D getGraphysics2D() {
        return graphysics2D;
    }
    
    public void setGraphysics2D(Graphics2D graphysics2d) {
        graphysics2D = graphysics2d;
    }
    
    public Rectangle getBox() {
        return box;
    }
    
    public void setBox(Rectangle box) {
        this.box = box;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
}