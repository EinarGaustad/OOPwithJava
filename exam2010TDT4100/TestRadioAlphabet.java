package exam2010TDT4100;


public class TestRadioAlphabet {
    
    public static void main(String[] args) {
        System.out.println("abcdefgh".substring(1, 2));
        RadioAlphabet test = new RadioAlphabet(
                "hotel alfa lima lima victor alfa romeo delta", " ");
        System.out.println(test.toString());
        System.out.println(test.convert("a&b*c@d!e"));
        test.setWord("åring");
        System.out.println();
        System.out.println(test.toString());
        System.out.println(test.convert("håvard"));
        System.out.println("håvard".length() == 7);
        System.out.println("håvard".length() == 7);

    }
}
