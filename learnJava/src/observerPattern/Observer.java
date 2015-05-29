package observerPattern;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on May 29, 2015.
 */
public interface Observer {

    void fireChanged(Subject subject, String s);
}
