package e2011;

public class Date {

    /**
     * a:
     * En kan kategorisere innkapslingsmetoder som enten lese- eller
     * endringsmetoder. Hva er den viktigste oppgaven til endringsmetodene,
     * bortsett fra å utføre selve endringen?
     */
    /**
     * Den viktigste oppgaven er å sjekke (validere) om den nye verdien (eller
     * nye verdiene) er lovlige/gyldige, før de evt. endres, f.eks. at et navn
     * kun inneholder bokstaver og mellomrom.
     */
    private int day, month, year;
    
    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    
    public String toString() {
        return day + "." + month + "." + year;
    }
    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("0 < day < 32");
        } else {
            this.day = day;
        }
    }
    
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("0 < month < 13");
        } else {
            this.month = month;
        }
    }
    
    public void setYear(int year) {
        if (year < 0 || year > 99) {
            throw new IllegalArgumentException("year: 0 - 99");
        }
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getYear() {
        return year;
    }
}
