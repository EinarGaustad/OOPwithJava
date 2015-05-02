package polymorphism;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on April 29, 2015.
 */
public class Hen extends Chicken {

    public Hen(String shape, String color, String size) {
        super(shape, color, size);
    }

    @Override
    public String display() {
        return getKind() + " - shape: " + shape + "; color: " + color + "; size: " + size + " " +
               chicken();
    }
}
