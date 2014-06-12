package graphicalUserInterfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

public class MoveableRectangle extends JComponent {
    
    private static final long          serialVersionUID = 1L;
    private int[]                      table;
    private int                        CalculateHighUnit;
    private int                        width;
    private final int                  START_X          = 2, START_Y = 10;
    private ArrayList<TheRectangle>    gtable           = new ArrayList<TheRectangle>();
    private Map<Integer, TheRectangle> gmap             = new HashMap<Integer, TheRectangle>();
    
    public MoveableRectangle(int[] table) {
        this.table = table;
        int max = 0;
        int min = 99999;
        for (int nr : table) {
            if (nr > max) {
                max = nr;
            }
            if (nr < min) {
                min = nr;
            }
        }
        this.CalculateHighUnit = (400 - 10 - 10) / max;
        this.width = ((600 - 5 - 5) / table.length) - 2;
        System.out.println(CalculateHighUnit);
    }

    public void paintComponent(Graphics g) {
        int x = START_X;
        int y = START_Y;
        for (int i = 0; i < table.length; i++) {
            int colorz = 0, colory = 0, colorx = 0;
            int high = table[i] * CalculateHighUnit;
            Graphics2D g2 = (Graphics2D) g;
            Rectangle box = new Rectangle(x, 390 - high, width, high);
            System.out.println("x, y, width, high: " + x + " " + y + " "
                    + width + " " + high);
            g2.draw(box);

            //--------COLOR:
            int colorS = high * 100 + 255;
            colorx = colorS / (255 * 255);
            if (colorx > 255) {
                colorx = 0;
            }
            colory = colorS / 255;
            if (colory > 255) {
                colory = 0;
                colorz++;
            }
            colorz = colorS % 255;
            Color newColor = new Color(colorx, colory, colorz);
            System.out.println(colorx + " " + colory + " " + colorz);
            //---------COLOR END;

            g2.setColor(newColor);
            g2.fill(box);
            TheRectangle tr = new TheRectangle(x, 390 - high, g2, box, newColor);
            gtable.add(tr);
            x += (width + 2);
        }
        moveComponent();
    }
    
    public void moveComponent() {
        gtable.get(1).getGraphysics2D()
                .translate(gtable.get(8).getX() - 2, gtable.get(1).getY());
        gtable.get(1).getGraphysics2D().setColor(gtable.get(1).getColor());
        gtable.get(1).getGraphysics2D().fill(gtable.get(1).getBox());
        System.out.println(gtable.get(0).getX());
        System.out.println(gtable.get(0).getY());
        System.out.println(gtable.get(8).getX());
        System.out.println(gtable.get(8).getY());
    }
}