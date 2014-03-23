package oving9.highscoreProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author GuoJunjun Merk at første argument til listChanged-metoden er av typen
 *         ObservableList. Dette er en abstrakt superklasse for HighscoreList,
 *         som først brukes i del 3 og som da skal holde orden på lista.
 *         ObservableList vil ha en del generelle metoder som HighscoreList
 *         arver og kan bruke. For å kunne kjøre testene for HighscoreList
 *         allerede i del 1, så må ObservableList være definert fra starten. Lag
 *         derfor en tom ObservableList-klasse og bruk denne som superklasse for
 *         HighscoreList.
 */
public abstract class ObservableList {
    
    private ArrayList<ListListener> listenerlist = new ArrayList<ListListener>();
    protected int          maxSize;
    protected List<Object> elements = new ArrayList<Object>();
    
    /**
     * 
     * @return size() - returnerer antall elementer i lista, som altså aldri
     *         skal overstige maks-antallet
     */
    int size() {
        // if (list.size() > maxSize) {
        // return maxSize;
        // }
        return elements.size();
    }
    
    /**
     * 
     * @param index
     * @return resultatet i posisjonen angitt av argumentet
     */
    Object getElement(int index) {
//        if (index > maxSize || index < 0) {
//            throw new IllegalArgumentException("Wrong index");
//        } else {
            return elements.get(index);
//        }
    }
    
    /**
     * 
     * @param object
     * @return hvorvidt subklassen aksepterer at objektet legges inn i lista
     *         (f.eks. aksepterer HighscoreList kun Integer-objekter).
     */
    abstract boolean acceptsElement(Object object);
    
    /**
     * 
     * @param pos
     * @param object
     *            void addElement(int, Object) - legger til et element på
     *            posisjonen angitt av argumentet, men bare dersom det
     *            aksepteres som element. Dersom elementet ikke aksepteres, så
     *            skal IllegalArgumentException utløses. Dersom posisjonen er
     *            ulovlig så skal IndexOutOfBoundsException utløses.
     */
    protected void addElement(int pos, Object object) {
        if (!acceptsElement(object)) {
            throw new IllegalArgumentException("Only accept Integer");
        } else if (pos < 0 || pos > maxSize) {
            throw new IndexOutOfBoundsException("index erro");
        } else {
            elements.add(pos, object);
        }
    }
    
    /**
     * 
     * @param element
     *            void removeElement(int) - fjerner elementet på posisjonen
     *            angitt av argumentet. Dersom posisjonen er ulovlig så skal
     *            IndexOutOfBoundsException utløses.
     */
    protected void removeElement(int pos) {
        if (pos < 0 || pos > maxSize) {
            throw new IndexOutOfBoundsException("index erro");
        } else {
            elements.remove(pos);
        }
    }
    
    /**
     * 
     * @param object
     *            void addElement(Object) - legger til et element bakerst i
     *            lista, men bare dersom det aksepteres som element. Dersom
     *            elementet ikke aksepteres, så skal IllegalArgumentException
     *            utløses.
     */
    protected void addElement(Object object) {
        if (!acceptsElement(object)) {
            throw new IllegalArgumentException("erro");
        }else{
            elements.add(object);
        }
    }
    
    /**
     * 
     * @param lytter
     *            registrerer en ny lytter
     */
    void addListListener(ListListener lytter) {
        if (!listenerlist.contains(lytter)) {
            listenerlist.add(lytter);
        }
    }
    
    /**
     * 
     * @param lytter
     *            fjerner en tidligere registrert lytter
     */
    void removeListListener(ListListener lytter) {
        if (listenerlist.contains(lytter)) {
            listenerlist.remove(lytter);
        }
    }
    
    void tellListener(ObservableList list, int changedPosition) {
        for (ListListener listener : listenerlist) {
            listener.listChanged(list, changedPosition);
        }
    }
}
