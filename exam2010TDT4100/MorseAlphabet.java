package exam2010TDT4100;

public class MorseAlphabet extends RadioAlphabet {

    public MorseAlphabet() {
        setCode();

    }
    
    private void setCode() {
        String morsecode = "A@.-#B@-...#C@-.-.#D@-..#E@.#F@..-.#G@--.#H@....#I@..#J@.---#K@-.-#L@.-..#M@--#N@-.#O@---#P@.--.#Q@--.-#R@.-.#S@...#T@-#U@..-#V@...-#W@.--#X@-..-#Y@-.--#Z@--..#Ä@.-.-#Á@.--.-#Å@.--.-#Ch@----#É@..-..#Ñ@--.--#Ö@---.#Ü@..—#0@-----#1@.----#2@..---#3@...--#4@....-#5@.....#6@-....#7@--...#8@---..#9@----.#.@.-.-.-#,@--..--#:@---...#?@..--..#/@-..-.#";
        String[] keyValue = morsecode.split("#");
        for (String keyvalue : keyValue) {
            alphabet.put(keyvalue.split("@")[0], keyvalue.split("@")[1]);
        }
    }
    
    @Override
    public String convert(String string) {
        return super.convert(string.toUpperCase());
    }
    
    //    CHARACTER   CODE    CHARACTER   CODE
    //    A   .-  B   -...
    //    C   -.-.    D   -..
    //    E   .   F   ..-.
    //    G   --. H   ....
    //    I   ..  J   .---
    //    K   -.- L   .-..
    //    M   --  N   -.
    //    O   --- P   .--.
    //    Q   --.-    R   .-.
    //    S   ... T   -
    //    U   ..- V   ...-
    //    W   .-- X   -..-
    //    Y   -.--    Z   --..
    //    0   -----   1   .----
    //    2   ..---   3   ...--
    //    4   ....-   5   .....
    //    6   -....   7   --...
    //    8   ---..   9   ----.
    //    Fullstop (period)   .-.-.-  Comma (,)   --..--
    //    Query (?)   ..--..  Equals (=)  -...-
}
