package polymorphism;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on April 29, 2015.
 */
public class Chicken extends Bird {
    public Chicken(String shape, String color, String size) {
        super(shape, color, size);
    }

    @Override
    public String getKind() {
        return kind;
    }

    /**
     * a final method
     * <p/>
     * nobody can override this method
     *
     * @return
     */
    public final String chicken() {
        return "chicken is a kind of bird";
    }

    @Override
    public String display() {
        return "not implemented :)";
    }
}
