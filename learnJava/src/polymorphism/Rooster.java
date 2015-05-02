package polymorphism;

/**
 * This file is part of learnJava
 * <p/>
 * final class :
 * <p/>
 * - so no body can extends
 * <p/>
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on April 29, 2015.
 */
public final class Rooster extends Chicken {
    private boolean egg;

    public Rooster(String shape, String color, String size) {
        super(shape, color, size);
        this.egg = false;
    }

    @Override
    public String display() {
        return getKind() + " - shape: " + shape + "; color: " + color + "; size: " + size +
               (egg ? " can" : " cannot ") + "produce egg.";
    }
}
