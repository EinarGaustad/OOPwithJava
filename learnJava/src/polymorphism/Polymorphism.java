package polymorphism;

/**
 * This file is part of learnJava
 * <p/>
 * polymorphism.Polymorphism:
 * <p/>
 * - multiple objects carry out a task, each object des so in its own way
 * <p/>
 * Wikipedia:
 * <p/>
 * - polymorphism is the provision of a single interface to entities of different types.
 * <p/>
 * - A polymorphism type is a type whose operations can also be applied to values of some other type, or types
 * <p/>
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on April 29, 2015.
 */
public class Polymorphism {

    public static void main(String[] args) {
        String shape = "round";
        String color = "green", size = "5";


        Fruit fruit = new Fruit(shape, color, size);

        print(fruit);
        System.out.println("apple: ");

        fruit = new Apple(shape, color, size);
        print(fruit);

        //        polymorphism.Food:
        Food food = new Vegetable(shape, color, size);
        print(food);

        food = new Chicken(shape, color, size);
        print(food);

        food = new Rooster(shape, color, size);
        print(food);
    }

    /**
     * dynamic method lookup:
     * <p/>
     * - determined by the type of the actual object, not the type of variable
     *
     * @param fruit
     */
    public static void print(Food fruit) {
        System.out.println(fruit.getClass().getSimpleName() + " - " + fruit.display());
    }
}
