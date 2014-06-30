package test.recursion;



public class Triangle {
    
    private int width;
    
    public Triangle(int aWidth) {
        if (aWidth <= 0) {
            throw new IllegalArgumentException();
        }
        width = aWidth;
    }
    
    public int getArea() {
        if (width ==1){
            System.out.println("if width == 1 ; width: " + width);
            return 1;
        } else {
            System.out.println("smallerTriangle width: " + (width - 1));
            Triangle smallerTriangle = new Triangle(width - 1);
            System.out.println("smallerArea: getArea()");
            int smallerArea = smallerTriangle.getArea();
            System.out.println("return: " + (smallerArea + width));
            return smallerArea + width;
        }
        //return (int) (width * Math.sin(60) * width / 2);
    }
}
