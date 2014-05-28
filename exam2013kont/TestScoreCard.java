package exam2013kont;


public class TestScoreCard {
    
    public static void main(String[] args) {
        ScoreCard sc = new ScoreCard();
        System.out.println(sc.getScores().toString());
        System.out.println(sc.getScores().length);
        Dice dice = new Dice();
        System.out.println(dice.toString());
        for (Score s : Score.values()) {
            sc.setScore(dice, s);
        }
        
        System.out.println(sc.toString());
    }
}
