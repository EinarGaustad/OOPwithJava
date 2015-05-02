package polymorphism;

/**
 * This file is part of learnJava
 * <p/>
 * there is an abstract method not implemented so this class is also a abstract class
 * <p/>
 * all abstract classes can not be created as object (constructed)
 * <p/>
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on April 29, 2015.
 */
public abstract class Bird extends Meat {

    protected String kind;
    protected String shape;
    protected String color;
    protected String size;

    public Bird(String shape, String color, String size) {
        this.shape = shape;
        this.color = color;
        this.size = size;
        this.kind = this.getClass().getSimpleName();
    }

    //    @Override
    //    public String getKind() {
    //        return kind;
    //    }

}
