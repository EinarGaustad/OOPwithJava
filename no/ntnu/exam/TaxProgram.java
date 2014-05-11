package no.ntnu.exam;

import java.util.Scanner;


public class TaxProgram {
    
    private static YearRegister yr;
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int year = Integer.parseInt(sc.nextLine());
        sc.close();
        yr = new YearRegister(year);
    }
    
    public static void main(String[] args) {
        run();
        System.out.println(yr.toString());
    }
}