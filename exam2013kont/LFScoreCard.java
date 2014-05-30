package exam2013kont;

public class LFScoreCard {
    
    /**
     * int vs Integer
     * Newbies are often confused by the difference between int and Integer,
     * boolean vs Boolean, char vs Character, short vs Short, long vs Long,
     * float vs Float or double vs Double.
     * To properly understand the difference, you should read an introductory
     * textbook on Java. I will make a small stab at answering here.
     * 
     * Everything I say here applies analogously to char and Character, short
     * and Short, long and Long, float and Float, double and Double.
     * 
     * Definitions
     * 
     * An int is a primitive. It is not an Object. An int is a high performance,
     * streamlined beast for calculating numbers in the range -2,147,483,648
     * [-231] aka Integer.MIN_VALUE to +2,147,483,647 [2 31-1] aka
     * Integer.MAX_VALUE. An int is a bare bones 32-bit chunk of information.
     * int variables are mutable. Unless you mark them final, you can change
     * their value at any time.
     * An Integer, is a Object that contains a single int field. An Integer is
     * much bulkier than an int. It is sort like a Fedex box to contain the int.
     * Integers are immutable. If you want to affect the value of a Integer
     * variable, the only way is to create a new Integer object and discard the
     * old one.
     */
    private Integer[] scores;
    
    public LFScoreCard() {
        this.scores = new Integer[Combinations.values().length];
    }
    
    enum Combinations {
        ONES, TWOS, THREES, FOURS, FIVES, SIXES, PAIR, TWO_PAIRS, THREE_OF_A_KIND, FOUR_OF_A_KIND, SMALL_STRAIGHT, LARGE_STRAIGHT, FULL_HOUSE, CHANCE, YATZY;
    }
    
    public int getScore(LFDice dice, Combinations combination) {
        switch (combination) {
            case PAIR:
                return dice.getHighestValueOfSame(2, 0) * 2;
            case TWO_PAIRS:
                return dice.getDualCountScore(2, 2);
            case THREE_OF_A_KIND:
                return dice.getHighestValueOfSame(3, 0) * 3;
            case FOUR_OF_A_KIND:
                return dice.getHighestValueOfSame(4, 0) * 4;
            case SMALL_STRAIGHT:
                return dice.getStraightSum(1, 5);
            case LARGE_STRAIGHT:
                return dice.getStraightSum(2, 6);
            case FULL_HOUSE:
                return dice.getDualCountScore(3, 2);
            case CHANCE:
                return dice.getSum();
            case YATZY:
                return dice.getHighestValueOfSame(5, 0) > 0 ? 50 : 0;
            default: {
                int value = combination.ordinal() + 1;
                return dice.getValueCount(value) * value;
            }
        }
    }

    public void setScore(LFDice dice, Combinations combination) {
        int score = getScore(dice, combination);
        scores[combination.ordinal()] = score;
    }

}
