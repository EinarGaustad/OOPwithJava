package graphicalUserInterfaces;

import javax.swing.JFrame;

public class Drawing {
    
    public static void main(String[] args) {
        String title = "Title";
        int[] table = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        //        int[] table = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6,
        //                5, 4, 3, 2, 1 };
        //        int LENGTH = 40;
        //        int[] table = new int[LENGTH];
        //        for (int i = 0; i < LENGTH; i++) {
        //            table[i] = (int) (Math.random() * 40);
        //        }
        // construct an object of the JFrame class:
        JFrame frame = new JFrame();
        //set the size of the frame:
        frame.setSize(600, 420);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MoveableRectangle c1 = new MoveableRectangle(table);
        frame.add(c1);
        //c1.moveComponent();
        frame.repaint();
        frame.setVisible(true);
    }
}
