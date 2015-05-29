package polymorphism;

import org.junit.Assert;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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
class Polymorphism {

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

        Tomato tomato = new Tomato(shape, color, size, 10);
        print(tomato);
        try {
            tomato.add(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        print(tomato);
        tomato.consume(19);
        print(tomato);
        try {
            //            tomato.add(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //        tomato.add(-1); //Will not execute future when the exception is thrown
        print(tomato);

        // tomato handling:
        System.out.println("add-consume");
        InputStream input = System.in;
        //        tomatoHandling(input, tomato);
        // -----
        InputStream readInput;
        try {
            PrintWriter writer = new PrintWriter("x.txt");
            writer.println("6-0");
            writer.println("10-9");
            writer.println("20-19");
            writer.println("0-2");
            writer.close();
            System.out.println("print writer: ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //            readInput = new FileInputStream("x.txt");
            readInput = new FileInputStream(new File("x.txt"));
            System.out.println("read input:");
            tomatoHandling(readInput, tomato);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {

            InputStream is =  new ByteArrayInputStream("200-2".getBytes(StandardCharsets.UTF_8));
            Assert.assertEquals( 2, 4);
            Assert.assertEquals( 2, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tomatoHandling(InputStream input, Tomato tomato) {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int dashPos = line.indexOf('-');
            try {
                int add = Integer.parseInt(line.substring(0, dashPos));
                int consume = Integer.parseInt(line.substring(dashPos + 1));
                if (add != 0 && consume != 0) {
                    tomato.add(add);
                    print(tomato);
                    tomato.consume(consume);
                    print(tomato);
                }
            } catch (Exception e) {
                System.out.println("nothing is done! an error input occurred");
            }
        }
        scanner.close();
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
