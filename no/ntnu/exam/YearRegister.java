package no.ntnu.exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import no.posten.Adresseregister;

/*
 * konstruktør- brukes for å initialisere et nyopprettet new bojekt med gyldige
 * verdier.
 */
public class YearRegister {
    
    private long                  highest, lowest, average;
    private int                   year;
    private List<TaxEntity>       yearList;
    private Collection<TaxEntity> hashsetlist;
    private static no.posten.IAdress posten;

    YearRegister(int year) {
        this.year = year;
        yearList = new ArrayList<TaxEntity>();
        hashsetlist = new HashSet<TaxEntity>();
        posten = new Adresseregister(year);
    }
    
    /**
     * Hvis man ikke prøver å holde maxTax, minTax og averageTax kontinuerlig
     * oppdatert i add- og remove-metodene så må man sørge for at
     * makeStatistics()-metoden utføres
     * aller først i toString()- metoden. Det vil i såfall føre til veldig
     * mange (millioner) beregninger hver gang toString kalles.
     */
    public void makeStatistics() {
        if (yearList.size() > 0) {//make sure list is not empty
            long sum = 0;
            highest = yearList.get(0).getTax();
            lowest = yearList.get(0).getTax();
            for (TaxEntity te : yearList) {
                sum += te.getTax();
                if (te.getTax() > highest) {
                    highest = te.getTax();
                }
                if (te.getTax() < lowest) {
                    lowest = te.getTax();
                }
            }
            average = sum / yearList.size();
        }
    }
    
    public int population() {
        int p = 0;
        int phs = 0;
        for (TaxEntity te : hashsetlist) {
            if (te instanceof TaxPerson) {
                phs++;
            }
        }
        for (TaxEntity te : yearList) {
            if (te instanceof TaxPerson) {
                p++;
            }
        }
        System.out.println("hash set: " + phs + ", arraylist: " + p);
        return p;
    }
    
    /**
     * toString returnerer en tekstlig representasjon av objektet, og kalles ved
     * automatisk konvertering av objekt til String, f.eks. når println eller
     * operatoren+ brukes på Sting objekter.
     */
    public String toString() {
        return "Year: " + year + ", population: " + population()
                + ", Highest: " + highest + ", lowest: " + lowest
                + ", average: " + average;
    }

    /**
     * 
     * @param idnr
     * @return true if idnr er in the list, false otherwise.
     */

    public boolean containsTaxEntity(String idnr) {
        for (TaxEntity te : yearList) {
            if (idnr == te.getIdnr()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param p
     * @return true and add p the list if p is new, false if p is already in the
     *         list;
     */
    public boolean addTaxEntity(TaxEntity p) {
        for (TaxEntity te : yearList) {
            if (p == te) {
                return false;
            }
        }
        //        yearList.add(p);
        //        return true;
        makeStatistics();
        return yearList.add(p);
    }
    
    /**
     * 
     * @param p
     * @return
     *         List.add() vs Collection.add()
     *         boolean java.util.Collection.add(TaxEntity e)
     */
    public boolean leggetilTaxEntity(TaxEntity p) {
        makeStatistics();
        return hashsetlist.add(p);
    }
    
    /**
     * 
     * @param p
     * @return true if p is in the list and remove p, return false if p is not
     *         in the list;
     */
    public boolean removeTaxEntity(TaxEntity p) {
        for (TaxEntity te : yearList) {
            if (p == te) {
                yearList.remove(p);
                makeStatistics();
                return true;
            }
        }
        return false;
    }
    
    public Collection<TaxEntity> getTaxEntitesInCommune(String name) {
        Collection<TaxEntity> communelist = new ArrayList<TaxEntity>();
        for (TaxEntity te : yearList) {
            if (name == te.getCommune()) {
                communelist.add(te);
            }
        }
        return communelist;
    }

    public static String getCommune(String idnr){
        return posten.getKommune(posten.getAdresse(idnr));
    }
}
