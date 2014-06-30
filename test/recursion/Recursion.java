package test.recursion;


public class Recursion {
    
    public static void main(String[] args) {
        Triangle t = new Triangle(5);
        t.getArea();
        Square s = new Square(10);
        System.out.println(s.getArea());
    }
}
