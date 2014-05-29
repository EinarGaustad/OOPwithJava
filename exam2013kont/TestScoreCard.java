package exam2013kont;

public class TestScoreCard implements ScoreCardListener {
    
    @Override
    public void scoreCardChanged(ScoreCard scorecard) {
        System.out.println(scorecard.toString());
        
    }
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
        System.out.println("\n"+ "test listener");
        TestScoreCard ts = new TestScoreCard();
        ts.scoreCardChanged(sc);
        /**
         * del 3 Observerbarhet
         * 
         * Hva vil det si at et objekt er observerbart?
         * Hvorfor er dette nyttig?
         * når objekt forandre seg, motode inne i denne objekt
         * sende mellig til andre objekt som er på observer list.
         * riktig eller listener objekt kunne gjøre nyttig aksjon
         * når objekt forandre seg, for eksampel. det kan for telle
         * listener class å lage GUI...
         * 
         * Et observerbart objekt har mekanismer for å si fra til
         * såkalte observatører om alle relevante endringer av tilstanden sin
         * Dette er nyttig for å holde tilstanden til avhengige ovjekter
         * konsistent, f.eks. at et brukergrensesnitt viser den faktiske
         * tilstanden til en objekter i en applikasjon.
         * 
         * b. forklar med tekst og evt. kode hvordan du vil gjøre SocreCard
         * observerbar.
         * lage en list for å legge inn riktig observer for andre klasse,
         * lage en motode som fortelle alle objekt som er på obserever list
         * når ScoreCard forandres, sende melling til fortellings metode.
         * lage en grensesnitt som få melling
         * observer class må implement grensesnitt å bestemme hva skal gjøres..
         * 
         * Det defineres et lyttergrensesnitt, Scorecardlistener med en metode
         * scorecardchanged, som observatørene/lytterne må implementere.
         * scorecard
         * utvides til å holde en liste av slike, med metoder for å legge til
         * addscorecardlistener og fjerne lyttere, når tilstanden til
         * scorecard instansen endres i setscore metoden, går en gjennom socre
         * cardlistener lista og kaller scorecardchanged metoden med argumenter
         * som angir hva som ble endret.
         * 
         * b) Forklar med tekst og evt. kode hvordan du vil teste getScore- og
         * setScore-metoden i ScoreCard –klassen slik de er spesifisert i
         * oppgave 2 b). Det viktigste er å få frem den generelle teknikken
         * for testing, ikke å bruke et spesifikk rammeverk som JUnit.
         * 
         * lage en toString metode for å vise resultat,
         * lage en Dice objekt, get alle resultat fra deice objekt og sette dem
         * til scorecared objekt og sjekk hvis det er riktig
         * 
         * getScore-metoden er ikke avhengig av tilstanden til en
         * ScoreCard-instans, og kan testes ved å kalle metoden med varierende
         * og dekkende argumenter og sjekke returverdien mot ”fasiten”.
         * setScore- metoden har som formål å endre tilstanden til en
         * ScoreCard-instans og kan bare sjekkes ”indirekte” ved at en først
         * endrer tilstanden ved å kalle den og så sjekker returverdien til en
         * get-metode som leser ut samme tilstand (i dette tilfellet
         * getScore-metoden fra oppgave 2a)).
         */
    }

}
