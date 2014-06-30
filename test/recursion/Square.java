package test.recursion;

public class Square {
    
    private int length;
    
    public Square(int length) {
        this.length = length;
    }
    
    public int getArea() {
        if (length == 1) {
            return 1;
        } else {
            Square smallerSquare = new Square(length - 1);
            int smallerArea = smallerSquare.getArea();
            System.out.println(smallerArea + (length * 2) - 1);
            return smallerArea + length * 2 - 1;
        }
    }
}
