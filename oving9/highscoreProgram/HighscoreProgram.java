package oving9.highscoreProgram;

import java.util.Scanner;


/**
 * 
 * @author GuoJunjun Lag en hovedprogramklasse kalt HighscoreProgram, som tester
 *         at HighscoreList-klassen din virker som den skal. La den opprette en
 *         HighscoreList-instans, lese inn tall fra konsollet (f.eks. med en
 *         Scanner og nextInt-metoden) og legge disse inn i lista. Sørg for at
 *         HighscoreProgram implementerer ListListener-grensesnittet og
 *         registrerer seg som lytter på HighscoreList-instansen. La
 *         lyttermetoden listChanged skrive ut informasjon og resultatene i
 *         HighscoreList-instansen og posisjonsargumentet, slik at du ser at alt
 *         virker som det skal.
 */
public class HighscoreProgram implements ListListener {
    
    private HighscoreList list;

    /**
     * void init() - oppretter en ny HighscoreList og registrerer seg selv
     * (altså HighscoreProgram-instansen) som lytter
     */
    void init(int max) {
        list = new HighscoreList(max);
    }
    
    void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("List size");
        int nr = sc.nextInt();
        init(nr);
        for (int i = 0; i < nr; i++) {
            System.out.println("result nr " + i + " : ");
            nr = sc.nextInt();
            System.out.println(nr);
            list.addResult(nr);
        }
        sc.close();

    }
    
    /**
     * void listChanged(ObservableList, int) - observerer endringer i
     * HighscoreList-instansen og skriver ut posisjonsargumentet, samt selve
     * listen, til konsollet
     */
    @Override
    public void listChanged(ObservableList list, int changedPosition) {
        String element = " ";
        for (int i = 0; i < list.size(); i++) {
            element += list.getElement(i);
        }
        System.out.println(element + "\n" + "Changed position: "
                + changedPosition);
    }
    
    public static void main(String[] args) {
        HighscoreProgram program = new HighscoreProgram();
        program.run();
    }
}
