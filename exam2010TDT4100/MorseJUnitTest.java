package exam2010TDT4100;

import org.junit.Assert;
import org.junit.Test;
public class MorseJUnitTest {
    
    private MorseAlphabet ma = new MorseAlphabet();
    
    @Test
    public void testConvertString() {
        Assert.assertEquals("... --- ...", ma.convert("sos"));
        Assert.assertEquals("- . ... -", ma.convert("test"));
    }
}
