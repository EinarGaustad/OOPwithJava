package test;
import e2011.Date;

public class Appointment {
    
    private Date date;
    private Car  car;
    
    /**
     * @param date
     * @param car
     */
    public Appointment(Date date, Car car) {
        this.date = date;
        this.car = car;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Car getCar() {
        return car;
    }
    
    public void setCar(Car car) {
        this.car = car;
    }
    
    @Override
    public String toString() {
        return "[date=" + date + ", " + car.toString() + "]";
    }

}
