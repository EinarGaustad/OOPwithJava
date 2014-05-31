package exam2010TDT4100;


public class TestDate {
    
    public static void main(String[] args) {
        Date d = new Date(1, 1, 2014);
        System.out.println(d.toString());
        d.editLastDay();
        System.out.println(d.toString());
        for (int i = 0; i < 365; i++) {
            d.editNextDay();
            if (d.getDay() % 5 == 0) {
                System.out.println(d.toString());
            }
            if (d.getDay() % 5 == 1) {
                System.out.println(d.toStringM());
            }
        }
        System.out.println(" ");
        for (int i = 0; i < 365 * 11; i++) {
            d.editNextDay();
            if (d.getDay() == 1) {
                System.out.println(d.toString() + " "
                        + Month.values()[d.getMonth() - 1] + ": "
                        + Month.values()[d.getMonth() - 1].getValue());
            }
        }
    }
}
