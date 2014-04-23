package oving6.cardcontainer;


public class Test {
    
    public static void main(String[] args) {
        CardContainer cd = new CardDeck(14);
        System.out.println(cd.getCardCount());
        System.out.println(cd.toString());
        CardContainerIterator it = cd.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
