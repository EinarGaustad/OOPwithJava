package observerPattern;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on May 29, 2015.
 */
public class ConcreteObserverB implements Observer{

    public void action(Subject subject, String s) {
        System.out.println("Concrete Observer B: " + s + "; new sum: " + subject.getSum());
    }

    @Override
    public void fireChanged(Subject subject, String s) {
        action(subject, s);
    }
}
