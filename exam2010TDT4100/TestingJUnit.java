package exam2010TDT4100;


import junit.framework.TestCase;

public class TestingJUnit extends TestCase {
    
    private RadioAlphabet radioAlphabet;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        radioAlphabet = new RadioAlphabet("alfa-hotel-zulu", "-");
        radioAlphabet.setWord("hotel alfa lima lima victor alfa romeo delta",
                " ");
    }
    
    public void testConvertChar() {
        assertEquals("alfa", radioAlphabet.convert('a'));
        assertEquals("hotel", radioAlphabet.convert('h'));
        assertEquals("zulu", radioAlphabet.convert('z'));
        assertNull(radioAlphabet.convert('!'));
    }
    
    public void testConvertString() {
        assertEquals("hotel alfa lima lima victor alfa romeo delta",
                radioAlphabet.convert("hallvard"));
        assertEquals("hotel alfa lima alfa lima",
                radioAlphabet.convert("!h!a!l!a!l?"));
        radioAlphabet.setWord("åring");
        System.out.println(radioAlphabet.toString());
        System.out.println(radioAlphabet.converts('å'));
        System.out.println(radioAlphabet.convert('å'));
        System.out.println(radioAlphabet.convert("håvard"));
        assertEquals("hotel victor alfa romeo delta",
                radioAlphabet.convert("håvard"));
    }
    
    public void testSetWord() {
        assertEquals("hotel alfa lima lima victor alfa romeo delta",
                radioAlphabet.convert("hallvard"));
        radioAlphabet.setWord("lala");
        assertEquals("hotel alfa lala lala victor alfa romeo delta",
                radioAlphabet.convert("hallvard"));
    }
    
    public void testRemoveWord() {
        assertEquals("hotel alfa lima lima victor alfa romeo delta",
                radioAlphabet.convert("hallvard"));
        radioAlphabet.removeWord('l');
        assertEquals("hotel alfa victor alfa romeo delta",
                radioAlphabet.convert("hallvard"));
    }
}
