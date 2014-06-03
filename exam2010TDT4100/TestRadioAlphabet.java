package exam2010TDT4100;


public class TestRadioAlphabet {
    
    public static void main(String[] args) {
        System.out.println("abcdefgh".substring(1, 2));
        RadioAlphabet test = new RadioAlphabet("alfa-bravo-delta-charlie", "-");
        System.out.println(test.toString());
        System.out.println(test.convert("a&b*c@d!e"));
    }
}
