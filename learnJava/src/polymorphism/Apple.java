package polymorphism;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on April 29, 2015.
 */
public class Apple extends Fruit {


    public Apple(String shape, String color, String size) {
        super(shape, color, size);
    }

    public String display() {
        return "polymorphism.Apple: " + "shape: " + getShape() + "; color: " + getColor() + "; size: " + getSize();
    }
}
