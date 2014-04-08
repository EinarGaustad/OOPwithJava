package exam2008;

public class Country {

    private final String value;
    private final int    code;
    
    private Country(String value, int code) {
        this.value = value;
        this.code = code;
    }
    
    public String getValue() {
        return value;
    }
    
    public int getCountryCode() {
        return code;
    }
    
    public final static Country    Norge     = new Country("NO", 47),
            Danmark = new Country("DK", 45), Sverige = new Country("SE", 46);
    private final static Country[] countries = { Norge, Danmark, Sverige };
    
    public static Country getCountryForCode(int code) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getCountryCode() == code) {
                return countries[i];
            }
        }
        return null;
    }
}
