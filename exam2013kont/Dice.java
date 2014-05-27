package exam2013kont;

import java.util.Arrays;

public class Dice {
    
    private int   totalDice;
    private int[] dice;
    private int[] numberSum;
    
    public Dice(int totalDice) {
        this.totalDice = totalDice;
        dice = new int[totalDice];
        numberSum = new int[6];
        for (int i = 0; i < totalDice; i++) {
            dice[i] = randomDice();
        }
        setNumberSum();
    }
    
    private void setNumberSum() {
        //initial numberSum
        for (int j = 0; j < 6; j++) {
            numberSum[j] = 0;
        }
        for (int i = 0; i < dice.length; i++) {
            numberSum[dice[i] - 1]++;
        }
    }
    
    public String numberSumString() {
        String s = "";
        for (int i = 0; i < numberSum.length; i++) {
            s += (i + 1) + ": " + numberSum[i] + ", ";
        }
        return s;
    }
    
    /**
     * * c) Implementer String toString()-metoden, som returnerer en String med
     * verdien på alle terningene, med en bindestrek (-) mellom hver verdi.
     * Rekkefølgen har ingen betydning.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < totalDice; i++) {
            s += dice[i] + "-";
        }
        return (String) s.substring(0, totalDice * 2 - 1);
    }
    
    private int randomDice() {
        return (int) (Math.random() * 6) + 1;
    }
    
    /**
     * 
     * @return total dice value
     * 
     *         d) Implementer metoden int getValueCount(int value), som
     *         returnerer antall terninger som viser den angitte verdien. Dersom
     *         terningene f.eks. viser 6-4-1-4-2 og metoden kalles med 4 som
     *         argument, så skal metoden returnere 2.
     */
    public int getValueCount(int value) {
        if (value < 1 || value > 6) {
            throw new IllegalArgumentException("invalid value!");
        }
        return numberSum[value];
    }
    
    /**
     * 
     * @param count
     * @param butNot
     * @return highest value of minimum count but not value 'butNot'
     * 
     *         e) Implementer metoden int getHighestValueOfSame(int count, int
     *         butNot). Denne returnerer den høyeste verdien som finnes på
     *         minst count terninger, og som ikke er butNot, eller 0 hvis det
     *         ikke finnes minst count antall av noen verdi. Anta at terningene
     *         viser 1-3-1-6-3. Dersom metoden kalles med count lik 2 og butNot
     *         lik 0 som argumenter, så skal den returnere 3 fordi 3 er den
     *         høyeste verdien det er (minst) to av. Dersom den kalles med 2 og
     *         3 som argumenter, så skal den returnere 1 fordi 1 er den høyeste
     *         (og eneste) verdien det er to av og som ikke er 3. Og dersom den
     *         kalles med 3 og 0 som argumenter, så skal 0 returneres, fordi
     *         det ikke er 3 terninger med samme verdi.
     */
    public int getHighestValueOfSame(int count, int butNot) {
        for (int i = 5; i > -1; i--) {
            if (numberSum[i] >= count && i != butNot) {
                return i + 1;
            }
        }
        return 0;
    }
    
    /**
     * 
     * @param startValue
     * @param endValue
     * @return
     * 
     * 
     *         f) Implementer metoden int getStraightSum(int startValue, int
     *         endValue). Denne returnerer summen av verdiene fra og med
     *         startValue og til og med endValue, men bare dersom det er minst
     *         én terning med hver verdi. Anta at terningene viser 2-1-3-5-3.
     *         Dersom metoden kalles med startValue lik 1 og endValue lik 3, så
     *         skal den returnere 6 fordi det er summen av 1, 2 og 3 og alle
     *         disse finnes blant terningene. Dersom metoden kalles med 1 og 5,
     *         så skal den returnere 0, fordi ingen terning viser 4.
     */
    public int getStraightSum(int startValue, int endValue) {
        int sum = 0;
        for (int i = startValue; i <= endValue; i++) {
            boolean have = false;
            for (int j = 0; j < dice.length; j++) {
                if (dice[j] == i) {
                    have = true;
                    break;
                }
            }
            if (!have) {
                return 0;
            }
            sum += i;
        }
        return sum;
    }
    
    /**
     * g) Implementer de to metodene void roll() og void roll(int[] values), som
     * begge tilordner nye, tilfeldige verdier til terningene. Den første gir ny
     * verdi til alle terningene, mens den andre kun gir ny verdi til terningene
     * med verdier angitt av values-tabellen. Merk at én verdi tilsvarer kun
     * én terning, selv om det er flere med samme verdi, så for å slå om
     * igjen to firere må values- tabellen inneholde to 4ere. Metoden skal
     * utløse et passende unntak, dersom en verdi i values ikke har en
     * tilsvarende terning.
     */
    public void roll() {
        for (int i = 0; i < totalDice; i++) {
            dice[i] = randomDice();
        }
        setNumberSum();
    }
    
    public void roll(int[] values) {
        if (!isContained(values)) {
            System.out.println("invalid argument, nothing changed!");
            //throw new IllegalArgumentException(
            //                    "invalid argument, values not contained!");
        } else {
            Arrays.sort(dice);
            Arrays.sort(values);
            for (int i = 0; i < dice.length; i++) {
                if (values[0] == dice[i]) {
                    for (int j = 0; j < values.length; j++) {
                        dice[i + j] = randomDice();
                    }
                    break;
                }
            }
            setNumberSum();
        }
    }
    
    private boolean isContained(int[] values) {
        int[] origin = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            origin[i] = dice[i];
        }
        Arrays.sort(values);
        Arrays.sort(origin);
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] == values[0]) {
                if (origin.length - i > values.length) {
                    for (int j = 0; j < values.length; j++) {
                        if (values[j] != origin[j + i]) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
/*
 * a) Selv om standardterningene har seks sider, ønsker vi å unngå å
 * ”hardkode” dette overalt i programmet. Hvordan er det vanlig å kode (med)
 * slike ”konstanter”, så en kun trenger å endre verdien ett sted?
 * 
 * b) Implementer felt og konstruktør(er) for representere og initialisere
 * terningverdiene. Du må ta høyde for at antall terninger kan varieres fra
 * spill til spill.
 */

