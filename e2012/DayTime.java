package e2012;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DayTime {
    
    /**
     * a.
     * Hva betyr final-nøkkelordet slik det er brukt her?
     * 
     * På hva slags måte(r) ivaretar denne klassen formålet med innkapsling
     * og på hva slags måte(r) ikke?
     * 
     * final betyr her at feltet ikke kan endres etter at det er satt i
     * konstruktøren.
     * 
     * Selv om feltene er public så sikres innkapsling ved at felt-verdiene
     * forblir korrekte, siden kode utenfor klassen ikke kan sette feltene til
     * ugyldige verdier. Imidlertid er det ikke i tråd med innkapsling at kode
     * gjøres avhengig av at data er lagret i spesifikke felt. Ved bruk av
     * get-metoder får implementasjonsklassen større frihet til å endre
     * interne detaljer, uten at annen kode blir påvirket.
     * 
     * 
     */
    
    //    Modifier    | Class | Package | Subclass | World
    //    ————————————+———————+—————————+——————————+———————
    //    public      |  ✔    |    ✔    |    ✔     |   ✔
    //    ————————————+———————+—————————+——————————+———————
    //    protected   |  ✔    |    ✔    |    ✔     |   ✘
    //    ————————————+———————+—————————+——————————+———————
    //    no modifier |  ✔    |    ✔    |    ✘     |   ✘
    //    ————————————+———————+—————————+——————————+———————
    //    private     |  ✔    |    ✘    |    ✘     |   ✘

    public final int hours, minutes;
    private int      value;
    
    public DayTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }
    
    public String toString() {
        return hours + ":" + minutes;
    }
    
    public int gethours() {//not needed hours and minutes are public 
        return hours;
    }
    
    public int getminutes() {
        return minutes;
    }
    
    // public void changeTime(int hours, int minutes) { //wrong
    // this.hours = hours;//once it is final the values can not be changed!
    // this.minutes = minutes;
    // }
    
    /**
     * b.
     * Beskriv den generelle teknikken og navnekonvensjonen(e) for å
     * representere og kapsle inn en enkel verdi, f.eks. tall eller
     * objektreferanse, som skal kunne endres etter at objektet er opprettet.
     * 
     * Gitt verdi med (logisk) navn ”value” og type X, så vil en ha felt, get-
     * og set-metoder som følger:
     * private X value;
     * public X getValue() { return value;}
     * public void setValue(X value) { this.value = value;}
     * Dersom X er boolean/Boolean, så brukes gjerne ”is” som prefiks
     * istedenfor ”get”.
     */
    
    /**
     * c)
     * 
     * I hva slags metode(r) brukes unntak ifm. innkapsling, og hvordan? Vis
     * gjerne med et eksempel! / In what method (s) used except in connection.
     * encapsulation, and how? View preferably with an example!
     * : «ifb.» som forkortelse for «i forbindelse med»
     * 
     * 
     * I metoder som endrer (en verdi i) et objekt, så bør argumenter
     * valideres. Dette må skje før selve endringen og i tilfelle ugyldig(e)
     * verdier så kastes et unntak av typen IllegalArgumentException(...).
     * Eksempel:
     */
    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(
                    "Value must not negative, but was: " + value);
        }
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    /**
     * d) Mange klasser inneholder et List<X>-felt og definerer addX, removeX og
     * andre metoder som tilsvarer og bruker metodene i List-grensesnittet. En
     * alternativ løsning kunne vært å arve fra en List<X>-implementasjon,
     * f.eks. ArrayList<X>. Hvorfor brukes aldri denne løsningen i praksis?
     * 
     * 
     * Type List vs type ArrayList in Java ?
     * (1) List<?> myList = new ArrayList<?>();
     * (2) ArrayList<?> myList = new ArrayList<?>();
     * 
     * : Almost always the first one is preferred over the second one. The first
     * has the advantage that the implementation of the List can change (to a
     * LinkedList for example), without affecting the rest of the code. This is
     * will be difficult to do with an ArrayList, not only because you will need
     * to change ArrayList to LinkedList everywhere, but also because you may
     * have used ArrayList specific methods.
     */
    List<String>      stringList;  //List interface
    ArrayList<String> stringAlist; //specific ArrayList type
    
    public void setList(String string) {
        stringList = new ArrayList<String>();
        stringAlist = new ArrayList<String>();
        stringList.add(string);
    }
    
    public void setList() {
        stringList = new LinkedList<String>();
        //stringAlist = new LinkedList<String>();// wrong !!
    }
    /**
     * answer:
     * 
     * Det vi altså spør om her er hvorfor vi f.eks. gjør slik
     * public class Person {
     * List<Person> children = ... // contains list of children public void
     * addChild(Person p) { ... }
     * public void removeChild(Person p) { ... }
     * }
     * og ikke slik
     * public class Person extends ArrayList<Person> {
     * // trenger ikke add- og remove-metoder, fordi vi arver dem fra ArrayList
     * }
     * - Når en arver så kan en ikke kun arve de metodene en ønsker, men får
     * alle med på kjøpet. Da vil en være nødt til å redefinere alle en ikke
     * trenger/ønsker at skal være tilgjengelig.
     * - Det vil ikke alltid være logisk riktig at klassen skal være instanceof
     * List<X>.
     * - Teknikken kan bare brukes for én slik liste, siden en bare kan arve
     * fra én implementasjonsklasse.
     */
    public class Person {
        
        List<Person> children = new ArrayList<Person>();
        
        public void addChild(Person p) {
            children.add(p);
        }
        
        public void removeChild(Person p) {
            children.remove(p);
        }
    }
    
    //
    public class Folk extends ArrayList<Folk> {
        
    }
    //- Når en arver så kan en ikke kun arve de metodene en ønsker, 
    //  men får alle med på kjøpet. Da vil en være nødt til å redefinere 
    //  alle en ikke trenger/ønsker at skal være tilgjengelig.
    //- Det vil ikke alltid være logisk riktig at klassen skal være 
    //  instanceof List<X>.
    //- Teknikken kan bare brukes for én slik liste, siden en bare kan arve 
    //  fra én implementasjonsklasse.
}
