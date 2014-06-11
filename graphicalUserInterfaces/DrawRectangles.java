package graphicalUserInterfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;


@SuppressWarnings("serial")
public class DrawRectangles extends JComponent {
    
    private int[] table;
    private int   CalculateHighUnit;
    
    public DrawRectangles(int[] table) {
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
        System.out.println(CalculateHighUnit);
    }

    public void paintComponent(Graphics g) {
        int width = ((600 - 5 - 5) / table.length) - 2;
        int x = 5;
        int y = 10;

        for (int i = 0; i < table.length; i++) {
            int colorz = 0, colory = 0, colorx = 0;
            int high = table[i] * CalculateHighUnit;
            Graphics2D g2 = (Graphics2D) g;
            Rectangle box = new Rectangle(x, 390 - high, width, high);
            System.out.println("x, y, width, high: " + x + " " + y + " "
                    + width + " " + high);
            g2.draw(box);
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
            System.out.println(colorx + " " + colory + " " + colorz);
            g2.setColor(new Color(colorx, colory, colorz));
            g2.fill(box);
            x += (width + 2);
        }
    }
}
