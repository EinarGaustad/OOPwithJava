package exam2010TDT4100;


public class TestMorse {
    
    public static void main(String[] args) {
        MorseAlphabet ma = new MorseAlphabet();
        System.out.println(ma.convert("SOS"));
        System.out.println(ma
                .convert("JAVA, IS MY FAVOURITE PROGRAMMING LANGUAGE."));
    }
}
