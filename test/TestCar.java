package test;

import java.util.ArrayList;
import java.util.List;

import e2011.Date;

public class TestCar {
    
    public static void main(String[] args) {
        List<Appointment> appointments = new ArrayList<Appointment>();

        Car c1 = new Car();
        Date d1 = new Date(3, 6, 13);
        Appointment a1 = new Appointment(d1, c1);
        appointments.add(a1);
        
        Car c2 = new Car();
        Date d2 = new Date(4, 6, 13);
        Appointment a2 = new Appointment(d2, c2);
        appointments.add(a2);
        
        System.out.println(appointments.get(0).toString());
        System.out.println();
        System.out.println(appointments.get(1).toString());
        System.out.println();
        Date newappointment = new Date(5, 6, 13);
        appointments.get(0).setDate(newappointment);
        Car editc1 = c1;
        editc1.setCarid(11111);
        editc1.setCarbrand("Audi");
        editc1.setCaryear(2000);
        editc1.setOwnername("Ole");
        editc1.setPredefinedWork("change wheel");
        appointments.get(0).setCar(editc1);
        
        System.out.println(appointments.get(0).toString());
        System.out.println();
        System.out.println(appointments.get(1).toString());
        System.out.println();
    }
}
