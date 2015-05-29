package polymorphism;

/**
 * This file is part of learnJava
 * <p/>
 * Protected data in an object can be accessed by the methods of the object’s class and all its subclasses.
 * <p/>
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on April 29, 2015.
 */
public class Fruit extends Food {

    private String shape;
    private String color;
    private String size;

    public Fruit(String shape, String color, String size) {
        this.shape = shape;
        this.color = color;
        this.size = size;
    }

    public String display() {
        return "polymorphism.Fruit: " + "shape: " + shape + "; color: " + color + "; size: " + size;
    }

    public String getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }
}
