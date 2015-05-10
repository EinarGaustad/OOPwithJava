package polymorphism;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on May 10, 2015.
 */
public class Tomato extends Vegetable {
    private int totalAmount;

    public Tomato(String shape, String color, String size) {
        super(shape, color, size);
        this.totalAmount = 0;
    }

    public Tomato(String shape, String color, String size, int totalAmount) {
        super(shape, color, size);
        this.totalAmount = totalAmount;
    }

    @Override
    public String display() {
        return super.display() + " storage: " + totalAmount;
    }

    /**
     * @param amount
     *
     * @exception Exception "throws Exception" to throw it again, and let others to deal with it.
     */
    public void add(int amount) throws Exception {
        storageOverflow(amount);
        check(amount);
        this.totalAmount += amount;
    }

    public void consume(int amount) {
        check(amount);
        this.totalAmount -= amount;
    }

    /**
     * Will not executed when the exception is thrown.
     */
    public void check(int nr) {
        if (nr < 0) {
            throw new IllegalArgumentException("Not valid number : " + nr);
        }
    }

    /**
     * assume storage can store max 100 tomato
     * <p/>
     * "throws Exception" to throw it again, and let others to deal with it.
     *
     * @param nr
     */
    public void storageOverflow(int nr) throws Exception {
        if (totalAmount + nr > 100) {
            throw new Exception("storage overflow ! :)");
        }
    }
}
