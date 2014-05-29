package exam2013kont;


public class TestPrimary implements ScoreCardListener {
    
    @Override
    public void scoreCardChanged(ScoreCard scorecard) {
        System.out.println(scorecard.toString());
    }
    
    public static void main(String[] args) {
        Dice dice = new Dice();
        PrimaryScoreCard psc = new PrimaryScoreCard();
        System.out.println("length: " + psc.getScores().length + "\n"
                + dice.toString());

        for (int i = 0; i < psc.scores.length; i++) {
                psc.setScore(dice, Score.values()[i]);
        }
        TestPrimary tp = new TestPrimary();
        tp.scoreCardChanged(psc);
    }
}
