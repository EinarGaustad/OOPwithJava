package exam2010TDT4100;

/**
 * 
 * Hva er hensikten med innkapsling?
 * innkapsling er 'access control' det bestemme
 * hvilken klass eller objekt fra andre klass
 * kunne lese, modifiere vadier
 * 
 */

public class Date {
    
    private int day, month, year;
    
    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    
    public int getDaysOfmonth(int month) {
        if ((month == 2) && isLeapYear()) {
            return 29;
        } else {
            return Month.values()[month - 1].getValue();
        }
    }

    private void setDay(int day) {
        if (day > 32 || day < 0) {
            throw new IllegalArgumentException("invalid day: " + day);
        }
        this.day = day;
    }
    
    public int getDay() {
        return this.day;
    }
    
    private void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("invalid month: " + month);
        }
        this.month = month;
    }
    
    public int getMonth() {
        return this.month;
    }

    private void setYear(int year) {
        if (year < 0 || year > 9999) {
            throw new IllegalArgumentException("invalid year: " + year);
        }
        this.year = year;
    }
    
    public int getYear() {
        return this.year;
    }

    public void editNextDay() {
        if (getDaysOfmonth(getMonth()) == getDay()) {
            if (getMonth() == 12) {
                this.year += 1;
                this.month = 1;
                this.day = 1;
            } else {
                this.month += 1;
                this.day = 1;
            }
        } else {
            this.day = day + 1;
        }
    }
    
    public void editLastDay() {
        if (getDay() == 1) {
            if (getMonth() == 1) {
                this.year -= 1;
                this.month = 12;
                this.day = 31; //or getDaysOfmonth(getMonth());
            } else {
                this.month -= 1;
                this.day = getDaysOfmonth(getMonth());
            }
        } else {
            this.day = day - 1;
        }
    }
    
    /**
     * 29
     * if year is not divisible by 4 then common year
     * else if year is not divisible by 100 then leap year
     * else if year is not divisible by 400 then common year
     * else leap year
     */
    public boolean isLeapYear() {
        if (getYear() % 4 != 0) {
            return false;
        } else if (getYear() % 100 != 0) {
            return true;
        } else if (getYear() % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public int getFebruary() {
        if (isLeapYear()) {
            return 29;
        }
        return 28;
    }
    
    public String toString() {
        return day + "-" + month + "-" + year;
    }
    
    public String toStringM() {
        return day + "" + Month.values()[month - 1] + "" + year;
    }
}
