package oving9.highscoreProgram;


/**
 * 
 * @author GuoJunjun Denne oppgaven handler om å bruke
 *         observatør-observert-teknikken for å bli informert om endringer i en
 *         highscore-liste. Vi bruker også arv for å skille ut gjenbrukbar kode
 *         for en generell, observerbar liste. Observatør-observert-teknikken
 *         går ut på at det observerte objektet sier ifra til en eller flere
 *         observatører om at tilstanden er endret. I denne oppgaven skal vi
 *         lage en HighscoreList som kan si fra til lyttere av typen
 *         ListListener når nye resultater blir registrert. En
 *         hovedprogramklasse kalt HighscoreProgram vil bli brukt til å sjekke
 *         at det virker. Denne klassen oppretter en HighscoreList-instans,
 *         legger inn resultater (tall) fra konsollet som legges til lista og
 *         skriver ut lista hver gang et nytt resultat faktisk blir lagt til.
 * 
 * 
 *         En HighscoreList skal holde styr på heltallsresultater (av typen
 *         int/Integer). Lista skal være observerbar ved at den kan registrere
 *         lyttere (ListListener-instanser) og si fra til dem når lista blir
 *         endret. Lista skal ha en maksimal lengde, som settes i konstruktøren,
 *         f.eks. skal en topp 10-liste kunne opprettes med new
 *         HighscoreList(10). Nye resultater registreres med metoden
 *         addResult(int), som skal finne riktig posisjon og legge resultatet
 *         inn (dersom det er godt nok). Dersom lista er for lang, så skal det
 *         dårligste resultatet fjernes. NB: Lavest verdi er best, f.eks. antall
 *         sekunder på en oppgave eller antall flytt i Sokoban.
 * 
 *         ListListener-grensesnittet er vist i klassediagrammet til venstre og
 *         må implementers av alle klasser som ønsker å fungere som lyttere for
 *         HighscoreList-instanser. Lyttere registrerer seg med HighscoreList
 *         sin addListListener-metode og vil siden få beskjed om nye resultater
 *         ved at listChanged-metoden kalles. Argumentene som tas inn er
 *         HighscoreList-objektet som ble endret og posisjonen i lista der
 *         endringen skjedde.
 * 
 *         Merk at første argument til listChanged-metoden er av typen
 *         ObservableList. Dette er en abstrakt superklasse for HighscoreList,
 *         som først brukes i del 3 og som da skal holde orden på lista.
 *         ObservableList vil ha en del generelle metoder som HighscoreList
 *         arver og kan bruke. For å kunne kjøre testene for HighscoreList
 *         allerede i del 1, så må ObservableList være definert fra starten. Lag
 *         derfor en tom ObservableList-klasse og bruk denne som superklasse for
 *         HighscoreList.
 */
public class HighscoreList extends ObservableList {
    
    // private final int maxSize;
    // private int[] list;
    // protected ArrayList<Integer> list;
    // private ArrayList<>
    // private int changedPosition;

    /**
     * 
     * @param maxSize
     *            HighscoreList(int maxSize) - konstruktøren tar inn maks antall
     *            resultater som lista skal kunne holde. Denne verdien må brukes
     *            av addResult, slik at resultater som er for dårlige kastes.
     */
    HighscoreList(int maxSize) {
        this.maxSize = maxSize;
        // elements = new ArrayList<Integer>();
        // list = new int[maxSize];
    }
    
    // /**
    // *
    // * @return size() - returnerer antall elementer i lista, som altså aldri
    // * skal overstige maks-antallet
    // */
    // int size() {
    // if (elements.size() > maxSize) {
    // return maxSize;
    // }
    // return elements.size();
    // }

    // /**
    // *
    // * @param index
    // * @return resultatet i posisjonen angitt av argumentet
    // */
    // int getElement(int index) {
    // if (index > maxSize || index < 0) {
    // throw new IllegalArgumentException("Wrong index");
    // } else {
    // return list.get(index);
    // }
    // }
    
    /**
     * 
     * @param result
     *            void addResult(int) - registrere et nytt resultat, og dersom
     *            resultatet er godt nok til å komme med på lista, så legges det
     *            inn på riktig plass. Dersom lista blir for lang, så må
     *            dårligste resultat kastes. Alle registrerte lyttere må få
     *            beskjed om en evt. endring av lista, inkludert på hvilken
     *            posisjon som ble endret.
     */
    void addResult(int result) {
        // if (result < 0) {
        // throw new IllegalArgumentException("result can not be negativ");
        // } else {
            int position = 0;
            while (position < size() && (int) getElement(position) <= result) {
                position++;
            }
            addElement(position, result);
            tellListener(this, position);
        while (elements.size() > maxSize) {
            elements.remove(maxSize);
        }
        // }
        // ----------
        // if (size() < maxSize) {
        // list.add(result);
        // changedPosition = size();
        // } else {
        // int max = -1;
        // int indexnr = 0;
        // for (int i = 0; i < maxSize; i++) {
        // if (list.get(i) > max) {
        // max = list.get(i);
        // indexnr = i;
        // }
        // }
        // list.set(indexnr, result);
        // changedPosition = indexnr;
        // }

        // --------
        
        // if (size() == 0) {
        // list.add(result);
        // } else {
        // for (int i = 0; i < size(); i++) {
        // if (list.get(i) > result) {
        // list.add(i, result);
        // changedPosition = i;
        // if (list.size() > maxSize) {
        // list.remove(maxSize);
        // }
        // break;
        // }
        // }
        // }
    }
    


    @Override
    boolean acceptsElement(Object object) {
        if (object instanceof Integer) {
            return true;
        }
        return false;
    }
}
