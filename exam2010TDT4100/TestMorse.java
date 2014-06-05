package exam2010TDT4100;


public class TestMorse implements RadioAlphabetListener {
    
    public static void main(String[] args) {
        TestMorse tm = new TestMorse();

        MorseAlphabet ma = new MorseAlphabet();
        ma.addListeners(tm);
        System.out.println(ma.convert("SOS"));
        System.out.println(ma
                .convert("JAVA, IS MY FAVOURITE PROGRAMMING LANGUAGE."));
    }
    
    @Override
    public void radioAlphabetChanged(RadioAlphabet ra, char c) {
        System.out.println(ra.toString() + ": " + c);
    }
}
