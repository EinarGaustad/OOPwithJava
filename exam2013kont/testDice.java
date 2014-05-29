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
        /**
         * The purpose of a test program is to verify that one or more methods
         * have been implemented correctly.
         * 
         * a) Med kun get- og roll-metodene som er spesifisert i Dice-klassen i
         * oppgave 1, er det vanskelig å gjennomføre testing av klassen,
         * hvorfor? Hvordan vil du utvide/endre på koden for å gjøre det mulig
         * å teste disse metodene?
         * 
         * roll metode returer ikke verdier
         * kan skrive toString metode for å vise rusultat
         * 
         * problemet er at det ikke er mulig å sette terningverdiene direkte,
         * siden de bare settes indirekte til uforutsigbare verdier i roll
         * metodene, en kan derfor ikke veksle mellom å sette tilstanden og
         * teste hvilke svar get metodene gir. en løsning er å lage en egen
         * setDice metode og en annen er å gjøre det mulig å sette objektet med
         * set metode eller i konstruktøren som genererer tilfeldige tall, slik
         * at vi kan gi inn en som genererer forutsigvare verdier.
         * 
         * b) Forklar med tekst og evt. kode hvordan du vil teste getScore- og
         * setScore-metoden i ScoreCard –klassen slik de er spesifisert i
         * oppgave 2 b). Det viktigste er å få frem den generelle teknikken
         * for testing, ikke å bruke et spesifikk rammeverk som JUnit.
         */

    }
}
