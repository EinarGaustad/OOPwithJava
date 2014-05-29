package exam2013kont;

import java.util.ArrayList;

public class PrimaryScoreCard extends ScoreCard implements PointRule {
    
    public PrimaryScoreCard() {
        this.scores = new Integer[6];
        this.listeners = new ArrayList<ScoreCardListener>();
    }

    @Override
    public int getScore(Dice dice, Score score) {
        int value = score.ordinal() + 1;
        return dice.getValueCount(value) * value;
    }
}
