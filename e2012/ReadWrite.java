package e2012;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class ReadWrite {
    
    protected String path, resultMessage;

    public ReadWrite() {
        path = "/Users/junjun/Dropbox/ntnu2014/objectOrientedProgramming/oving/TDT4100/src/e2012/";
    }
    
    //public abstract String readFile(String filename);
    
    //public abstract boolean writeFile(String filename);
    
    /*
     * Hva er den grunnleggende forskjellen på input/output-klassene
     * InputStream/OutputStream og deres subklasser ift. Reader/Writer og deres
     * subklasser?
     * 
     * ￼￼InputStream-/OutputStream-klassene håndterer byte-verdier, mens
     * Reader-/Writer-klassene håndterer char-verdier, som krever koding av
     * tegn til/fra bytes (iht. Unicode-regler).
     */
    
    /*
     * b) Ifm. input/output brukes en egen type unntak, hvilken? På hva slags
     * måte påvirker det kode som driver med input/output?
     * 
     * Input/output-metoder kaster gjerne IOException, som er en såkalt
     * “checked exception”. Slike brukes gjerne for feil som er utenfor vår
     * kontroll. Disse krever at kode må fange dem opp med try/catch eller
     * deklarere med throws at de kastes videre
     */
    public void inputstream(String name){
        InputStream is = null;
        try {// use try catch for error
            is = new FileInputStream(path + name);
            int data = is.read();
            System.out.println(data);
            while (data != -1) {
                data = is.read();
                System.out.println(data);
            }
            //is.close();//close in finally
        } catch (IOException e) {//catch Input out error
            System.out.println(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public void outputstream(String name) throws IOException {//declare with throws IOException
        OutputStream os = new FileOutputStream(path + name);
        os.write(123456789);
        os.close();
    }
    /**
     * Hvorfor må vi lukke input- og output-“strømmer” med close()-metoden når
     * vi er ferdige med dem? Hvordan sikrer man at det skjer også i tilfelle
     * unntak?
     * 
     * ￼Strømmer bruker gjerne ressurser utenfor Java og close()-metoden sikrer
     * at Java samhandler riktig
     * ￼med disse, f.eks. frigjør dem. For å sikre at dette alltid skjer, er
     * det vanlig å ha close()-kallet i en
     * ￼try/finally-blokk.
     */
}
