package exam2008;


public abstract class MobileThing implements Comparable<MobileThing> {
    
    private String  brand, model;
    private Country country;
    
    /**
     * @param brand
     * @param model
     * @param country
     */
    public MobileThing(String brand, String model, Country country) {
        super();
        this.brand = brand;
        this.model = model;
        this.country = country;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public Country getCountry() {
        return country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
    
    public int sendMessage(String number, String text) throws RuntimeException {
        Country country = getCountry();
        if (number.startsWith("+")) {
            char digit10 = number.charAt(1), digit1 = number.charAt(2);
            int code1 = (digit10 - '0') * 10 + (digit1 - '0');
            // int code2 = Integer.valueOf(number.substring(1, 3)); //method 2
            country = Country.getCountryForCode(code1);
            number = number.substring(3);
        }
        int smsCount = 0;
        while (text.length() > 128) {
            // String s128 = text.substring(0, 128);
            try {
                SMS.sendSMS(country, number, text);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            smsCount++;
            text = text.substring(128);
        }
        if (text.length() > 0) {
            // if (!SMS.sendSMS(country, number, text)) {
            // // error message
            // }
            try {
                SMS.sendSMS(country, number, text);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            smsCount++;
        }
        return smsCount;
    }
    
    public abstract String getAvailableKeys();
    
    public boolean isKeyboardOpen() {
        return true;
    }
    
    public final static String NUMER_KEYS = "0123456789",
            QWERTY_KEYS = "QWERTYUIOPASDFGHJKLZXCVBNM";
    
    public boolean isKeyAvailable(char key){
        return getAvailableKeys().indexOf(key) >= 0;
    }
    
    public int compareTo(MobileThing other) {
        return this.getMemorySize() - other.getMemorySize();
    }
    
    private int getMemorySize() {
        return 0;
    }
}
