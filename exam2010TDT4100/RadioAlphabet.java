package exam2010TDT4100;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Nato har standardisert dette i sitt fonetiske alfabet, som begynner med
 * ”alfa”, ”bravo”, ”charlie”, ”delta”, ”echo”, ”foxtrot”
 * 
 */
public class RadioAlphabet {
    
    private Map<String, String> alphabet = new HashMap<String, String>();
    
    public RadioAlphabet(String string, String sign) {
        String[] table = string.split(sign);

        for (String s : table) {
            if (!onlyAlphabets(s)) {
                throw new IllegalArgumentException(
                        "only Alphabets are accepted! no signs!");
            } else {
                alphabet.put(s.substring(0, 1), s);
            }
        }
    }
    
    public boolean onlyAlphabets(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.toLowerCase().charAt(i) < 'a'
                    || s.toLowerCase().charAt(i) > 'z') {
                return false;
            }
        }
        return true;
    }
    
    public boolean converts(char c) {
        if (alphabet.containsKey(c + "")) {
            return true;
        }
        return false;
    }
    
    public String convert(char c) {
        if (converts(c)) {
            return alphabet.get(c + "");
        }
        return null;
    }
    
    public String convert(String string) {
        String s = "";
        for (int i = 0; i < string.length(); i++) {
            if (converts(string.charAt(i))) {
                //s += convert(string.substring(i, i + 1)) + " ";
                s += convert(string.charAt(i)) + " ";
            }
        }
        return s;
    }

    /**
     * b) Hvorfor kan ikke disse metodene være deklarert med
     * static-modifikatoren?
     * fordi string som sette inn er i objekt eller instans ikke i class.
     * 
     * med static modifikatoren vil metodene ikke kunne referere til et bestemt
     * RadioAlphabet-objekt. En kan for så vidt gjøre alfabetet static også, med
     * da vil en bare kunne ha ett globalt alfabet.
     * 
     * c) Hva kalles det når metoder i samme klasse har samme navn (som
     * convert-metodene)? Hva er
     * regelen for å skille dem fra hverandre/velge mellom dem, når de
     * brukes/kalles?
     * 
     * at metoder i en klasse kan ha vamme vavn kalles ¨overloading¨. for å
     * avgjøre hvilken som skal kalles, brukes de deklarerte typene til
     * argumentene ikke returverdien. merk at dette er noe annet enn polymorfi,
     * som handler om at subklasser kan ha ulike implementasjoner av metoder
     * definert i en felles superklasse.
     * 
     * Method overloading in Java occurs when two or more methods in the same
     * class have the exact same name but different parameters
     * 
     */
    public void setWord(String string) {
        alphabet.put(string.substring(0, 1), string);
    }
    
    public void removeWord(char c) {
        alphabet.remove(c + "");
    }
    
    public String toString() {
        String s = "";
        Set<String> keySet = alphabet.keySet();
        for (String key : keySet) {
            s += key + ": " + alphabet.get(key) + "\n";
        }
        return s;
    }
}
