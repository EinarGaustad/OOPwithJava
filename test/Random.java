package test;


public class Random {
    
    public static void main(String[] args) {
        System.out.println(Math.random());
        System.out.println(Math.random() * 10);
        System.out.println((int) (Math.random() * 5) * 2);
        int[] t = new int[10];
        for (int i = 0; i < 100; i++) {
            t[((int) (Math.random() * 5) * 2)] += 1;
        }
        System.out.println("  even: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + t[i]);
        }
        //
        int[] todd = new int[10];
        for (int i = 0; i < 1000; i++) {
            todd[((int) (Math.random() * 5) * 2) + 1] += 1;
        }
        System.out.println("  Odd: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + todd[i]);
        }
    }
}
