package exam2013kont;

/**
 * Klassen ScoreCard skal holde orden på alle poengene til én spiller, altså
 * informasjon tilsvarende tabellen vist i figuren i introduksjonen. En
 * ScoreCard-instans skal altså kunne lagre ett tall pr. terningkombinasjon
 * f.eks. 4 for ”enere”, 18 for ”to par”, nulling av ”liten straight” og
 * (foreløpig) ingenting/tomt for yatzy. I tillegg skal den kunne beregne og
 * evt. sette poengene en får for terningene for en bestemt kombinasjon.
 * 
 * @author GuoJunjun
 * 
 * 
 *         a) Forklar hvordan du vil lagre poeng-dataene i ScoreCard-klassen.
 *         Hint: Det kan være nyttig med en enum-klasse som representerer hver
 *         av de 15 terningskombinasjonene og ordinal()- metoden for indeksering
 *         i en tabell. Lag en passende konstruktør, slik at dataene er riktig
 *         initialisert, samt metoden getScore for å hente ut (lese) poeng
 *         knyttet til en bestemt kombinasjon. Velg selv passende parametre og
 *         returtype.
 */
public class ScoreCard {
    
    private Integer[] scores;
    
    //private Score         combination;
    public ScoreCard() {
        this.scores = new Integer[Score.values().length];
    }
    
    /**
     * 
     * @return scores table
     */
    public Integer[] getScores() {
        return scores;
    }
    /**
     * b) Implementer to metoder, getScore og setScore, den første for å
     * beregne hvor mange poeng en får for å registrere terningene
     * (Dice-instans) på en bestemt terningkombinasjon og den andre for å
     * faktisk registrere terningene på en bestemt kombinasjon. Merk at disse
     * metoden må håndtere tilfellet hvor en får 0 poeng, altså nuller ut
     * kombinasjonen. Velg selv passende parametre og returtype.
     */
    /**
     * 
     * @return
     *         beregne hvor mange poeng en får for å registrere terningene
     *         (Dice-instans) på en bestemt terningkombinasjon
     */
    public int getScore(Dice dice, Score score) {
        switch (score) {
            case ONEPAIR:
                return dice.getHighestValueOfSame(2, 0)*2;
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
                int value = score.ordinal() + 1;
                return dice.getValueCount(value) * value;
            }
        }
    }
    
    /**
     * 
     * @param score
     * 
     *            faktisk registrere terningene på en bestemt kombinasjon
     */
    public void setScore(Dice dice, Score score) {
        int points = getScore(dice, score);
        scores[score.ordinal()] = points;
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < scores.length; i++) {
            s += Score.values()[i] + ": " + scores[i] + "\n";
        }
        return s;
    }

}
