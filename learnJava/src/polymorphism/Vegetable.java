package polymorphism;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on April 29, 2015.
 */
public class Vegetable extends Food {

    protected String shape;
    protected String color;
    protected String size;

    public Vegetable(String shape, String color, String size) {
        this.shape = shape;
        this.color = color;
        this.size = size;
    }


    public String display() {
        return "shape: " + shape + "; color: " + color + "; size: " + size;
    }
}



