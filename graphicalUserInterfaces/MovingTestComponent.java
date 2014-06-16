package graphicalUserInterfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

public class MovingTestComponent extends JComponent {
    
    private static final long          serialVersionUID = 1L;
    private int[]                      table;
    private int                        CalculateHighUnit;
    private int                        width;
    private final int                  START_X          = 2, START_Y = 10;
    private ArrayList<TheRectangle>    gtable           = new ArrayList<TheRectangle>();
    private Map<Integer, TheRectangle> gmap             = new HashMap<Integer, TheRectangle>();

    public MovingTestComponent(int[] table) {
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
    }
    
    public void paintComponent(Graphics g) {
        int x = START_X;
        int y = START_Y;
        for (int i = 0; i < table.length; i++) {
            int colorz = 0, colory = 0, colorx = 0;
            int high = table[i] * CalculateHighUnit;
            Graphics2D g2 = (Graphics2D) g;
            //g2.draw(box);
            
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
            //---------COLOR END;
            
            Rectangle box = new Rectangle(x, 390 - high, width, high);
            g2.setColor(newColor);
            g2.fill(box);
            TheRectangle tr = new TheRectangle(x - 2, 390 - high, high, g2,
                    box, newColor);
            gtable.add(tr);
            x += (width + 2);
        }
        //moveComponent();
    }
    
    public void moveComponent() {
        System.out.println("moveComponent called");
        int from = 2;
        int to = 7;
        
        gtable.get(from)
                .getGraphysics2D()
                .clearRect(gtable.get(from).getX() + 2,
                        gtable.get(from).getY(),
                        (int) gtable.get(from).getBox().getWidth(),
                        gtable.get(from).getHeight());
        gtable.get(from).getGraphysics2D().translate(gtable.get(to).getX(), 0);
        gtable.get(from).getGraphysics2D()
                .setColor(gtable.get(from).getColor());
        gtable.get(from).getGraphysics2D().fill(gtable.get(from).getBox());
    }
}
