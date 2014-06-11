package graphicalUserInterfaces;

import java.awt.Color;

import javax.swing.JFrame;

public class LayoutManager {
    
    public static void main(String[] args) {
        String title = "Title";
        // construct an object of the JFrame class:
        JFrame frame = new JFrame();
        //set the size of the frame:
        frame.setSize(600, 400);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        RectangleComponent component = new RectangleComponent(5, 10, 10, 100,
                new Color(0, 255, 255));
        frame.add(component);

        frame.setVisible(true);
    }
}
