package observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on May 29, 2015.
 */
public class Subject {
    private int sum;
    private List<Observer> observers = new ArrayList<Observer>();

    public Subject(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
        broadcastChanges("set sum " + sum);
    }

    public void add(int sum) {
        this.sum += sum;
        broadcastChanges("add " + sum);
    }

    /**
     * add a concrete observer to observers list
     *
     * @param observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * remove the concrete observer to observers list
     *
     * @param observer
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * tell all observers changes has been made
     */
    private void broadcastChanges(String what) {
        for (Observer o : observers) {
            o.fireChanged(this, what);
        }
    }
}
