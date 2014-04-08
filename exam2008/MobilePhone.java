package exam2008;


public class MobilePhone extends MobileThing {
    
    public MobilePhone(String brand, String model, Country country) {
        super(brand, model, country);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String getAvailableKeys() {
        // if(isKeyboardOpen()){
        // return NUMER_KEYS;
        // }
        return (isKeyboardOpen() ? NUMER_KEYS : "");
    }
}
