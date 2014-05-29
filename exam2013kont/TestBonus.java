package exam2013kont;


public class TestBonus implements ScoreCardListener {
    
    @Override
    public void scoreCardChanged(ScoreCard scorecard) {
        System.out.println(scorecard.toString());
    }
    
    public static void main(String[] args) {
        Dice dice = new Dice();
        BonusScoreCard bsc = new BonusScoreCard();
        System.out.println("length: " + bsc.getScores().length);
        System.out.println(dice.toString());
        for (int i = 0; i < bsc.getScores().length; i++) {
            bsc.setScore(dice, Score.values()[i + 6]);
        }
        TestBonus tb = new TestBonus();
        tb.scoreCardChanged(bsc);
    }
}
