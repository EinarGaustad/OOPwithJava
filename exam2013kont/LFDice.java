package exam2013kont;

import java.util.Random;

public class LFDice extends Dice {
    
    /**
     * A static variable belongs to the class, not to any object of the class.
     * 
     * static variables should always be declared as private to ensure that
     * methods of other classes do not change their values.
     * 
     * However, static constants may be either private or public.
     * 
     * A typical example of a static method is the sqrt method in the Math
     * class. Because numbers aren’t objects, you can’t invoke methods on them.
     * For example, if x is a number, then the call x.sqrt() is not legal in
     * Java. Therefore, the Math class provides a static method that is
     * invoked as Math.sqrt(x).
     * 
     * In object-oriented programming, static methods are not very common.
     * Nevertheless, the main method is always static. When the program starts,
     * there aren’t any objects. Therefore, the first method of a program must
     * be a static method.
     * 
     * static og final modifikatorene brukes for å deklarere konstanter.
     * Disse kan så refereres til med klassenavn.feltnavn, idette tilfellet:
     */
    public static final int MAX_DIE_VALUE = 6;
    
    private final int[]     dice;
    
    public LFDice(int diceCount) {
        dice = new int[diceCount];
    }
    
    public String toString() {
        String result = "";
        for (int value : dice) {
            if (result.length() > 0) {
                result += "-";
            }
            result += value;
        }
        return result;
    }
    
    public int getValueCount(int value) {
        int count = 0;
        for (int v : dice) {
            if (v == value) {
                count++;
            }
        }
        return count;
    }
    
    public int getHighestValueOfSame(int count, int butNot) {
        for (int value = LFDice.MAX_DIE_VALUE; value >= 1; value--) {
            if (value != butNot && getValueCount(value) >= count) {
                return value;
            }
        }
        return 0;
    }
    
    private Random random = new Random();
    
    private int getRandomDieValue() {
        return random.nextInt(MAX_DIE_VALUE) + 1;
    }
    
    private void roll(boolean[] indices) {
        for (int die = 0; die < dice.length; die++) {
            //indices == null roll() || indices[die] roll(int[] v)
            if (indices == null || indices[die]) {
                dice[die] = getRandomDieValue();
            }
        }
    }
    
    public void roll(int[] values) {
        boolean[] indices = new boolean[dice.length];
        for (int value : values) {
            System.out.println("(int value : values):" + value);
            int die = 0;
            while (die < dice.length) {
                System.out.println(indices[die] + "; " + dice[die]);
                if ((!indices[die]) && value == dice[die]) {
                    break;
                }
                die++;
            }
            if (die < dice.length) {
                indices[die] = true;
                System.out.println("die < dice.length: " + indices[die]);
            } else {
                throw new IllegalArgumentException("No die with value " + value);
            }
        }
        roll(indices);
    }
    
    public void roll() {
        roll((boolean[]) null);
    }
    
    // helper method, used by getScore for the two pairs and full house cases 
    public int getDualCountScore(int count1, int count2) {
        int value1 = getHighestValueOfSame(count1, 0);
        int value2 = getHighestValueOfSame(count2, value1);
        return (value1 > 0 && value2 > 0 ? value1 * count1 + value2 * count2
                : 0);
    }

    public int[] getDicetable() {
        return dice;
    }

    public static void main(String[] args) {
        LFDice dice = new LFDice(5);
        System.out.println(dice.toString());
        dice.roll();
        System.out.println(dice.toString());
        dice.roll(dice.getDicetable());
        System.out.println(dice.toString());
    }
}
