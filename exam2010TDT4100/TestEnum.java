package exam2010TDT4100;


public class TestEnum {
    
    public static void main(String[] args) {
        System.out.println(Month.values()[1]);
        Month t = Month.April;
        System.out.println(t.getValue() + "\n");
        for (int i = 0; i < Month.values().length; i++) {
            System.out.print(Month.values()[i] + ": ");
            System.out.println(Month.values()[i].getValue());
        }
    }
}
