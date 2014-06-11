package graphicalUserInterfaces;


import javax.swing.JFrame;

public class Drawing {
    
    public static void main(String[] args) {
        String title = "Title";
        int[] table = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
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
        
        DrawRectangles c1 = new DrawRectangles(table);
        frame.add(c1);
        
        frame.setVisible(true);
    }
}
