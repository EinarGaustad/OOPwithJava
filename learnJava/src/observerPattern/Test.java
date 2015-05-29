package observerPattern;

import java.io.InputStream;
import java.util.Scanner;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on May 29, 2015.
 */
public class Test {

    public static void handleInput(InputStream input, Subject subject) {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            try {
                int line = scanner.nextInt();
                subject.add(line);
            } catch (Exception e) {
                System.out.println("nothing is done! an error input occurred");
            }
        }
        scanner.close();
    }


    public static void main(String[] args) {
        Subject subject = new Subject(0);
        ConcreteObserverA a = new ConcreteObserverA();
        subject.addObserver(a);
        subject.addObserver(new ConcreteObserverB());
        InputStream input = System.in;
        System.out.println("add a number!");
        handleInput(input, subject);
    }
}
