package exam2013kont;

import java.util.ArrayList;


public class BonusScoreCard extends ScoreCard implements PointRule {
    
    public BonusScoreCard() {
        this.scores = new Integer[9];
        this.listeners = new ArrayList<ScoreCardListener>();
    }
    
    @Override
    public int getScore(Dice dice, Score score) {
        switch (score) {
            case ONEPAIR:
                return dice.getHighestValueOfSame(2, 0) * 2;
            case TWOPAIRS:
                return dice.getTwoPairPoints();
            case THREEOFAKIND:
                return dice.getHighestValueOfSame(3, 0) * 3;
            case FOUROFAKIND:
                return dice.getHighestValueOfSame(4, 0) * 4;
            case SMALLSTRAIGHT:
                return dice.getStraightSum(1, 5);
            case LARGESTRAIGHT:
                return dice.getStraightSum(2, 6);
            case HOUSE:
                return dice.getHousePoints();
                //chance: simply total all the die faces values.
            case CHANCE:
                return dice.getSum();
            case YATZY:
                return dice.getHighestValueOfSame(5, 0) != 0 ? 50 : 0;
            default: {
                System.out.println("It's an Error here !");
                return 0;
            }
        }
    }
    
    @Override
    public void setScore(Dice dice, Score score) {
        int points = getScore(dice, score);
        scores[score.ordinal() - 6] = points;
        scoreCardChanged();
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < scores.length; i++) {
            s += Score.values()[i + 6] + ": " + scores[i] + "\n";
        }
        return s;
    }
}
