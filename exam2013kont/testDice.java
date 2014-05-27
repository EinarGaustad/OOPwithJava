package exam2013kont;

public class testDice {
    
    public static void main(String[] args) {
        Dice t = new Dice(5);
        System.out.println(t.toString());
        System.out.println(t.numberSumString());
        System.out.println("highest same value: "
                + t.getHighestValueOfSame(2, 6));
        System.out.println("get straight sum1,2,3: " + t.getStraightSum(1, 3));
        System.out.println("get straight sum2,3,4: " + t.getStraightSum(2, 4));
        System.out.println("---");
        System.out.println("COOOOKKIIIESSSSS");
        t.roll();
        System.out.println(t.toString());
        System.out.println(t.numberSumString());
        System.out.println("highest same value: "
                + t.getHighestValueOfSame(2, 6));
        System.out.println("get straight sum1,2,3: " + t.getStraightSum(1, 3));
        System.out.println("get straight sum2,3,4: " + t.getStraightSum(2, 4));
        System.out.println("\n" + "rol [1,2] : ");
        int[] v = { 1, 2 };
        t.roll(v);
        System.out.println(t.toString());
        System.out.println(t.numberSumString());
        System.out.println("highest same value: "
                + t.getHighestValueOfSame(2, 6));
        System.out.println("get straight sum1,2,3: " + t.getStraightSum(1, 3));
        System.out.println("get straight sum2,3,4: " + t.getStraightSum(2, 4));

        System.out.println("\n" + " --- continue && break ---");
        for (int i = 5; i > -1; i--) {
            System.out.println(i);
            if (i == 4) {
                System.out.println("brake" + i);
                break;
            }
            System.out.println("next: ");
        }
        System.out.println("---");
        for (int i = 5; i > -1; i--) {
            System.out.println(i);
            if (i == 4) {
                System.out.println("continue" + i);
                continue;
            }
            System.out.println("cnext: " + i);
        }
    }
}
