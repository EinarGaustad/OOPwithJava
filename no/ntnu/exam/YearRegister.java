package no.ntnu.exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class YearRegister {
    
    private long            highest, lowest, average;
    private int             year;
    private List<TaxEntity> yearList;
    private Collection<TaxEntity> hashsetlist;
    YearRegister(int year) {
        this.year = year;
        yearList = new ArrayList<TaxEntity>();
        hashsetlist = new HashSet<TaxEntity>();
    }
    
    public int population(){
        int p=0;
        int phs = 0;
        for (TaxEntity te : hashsetlist) {
            if (te instanceof TaxPerson) {
                phs++;
            }
        }
        for(TaxEntity te: yearList){
            if(te instanceof TaxPerson){
                p++;
            }
        }
        System.out.println("hash set: " + phs + ", arraylist: " + p);
        return p;
    }
    public String toString(){
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
     * @return true and add p the list if p is new, false if p is already in the list; 
     */
    public boolean addTaxEntity(TaxEntity p) {
        for (TaxEntity te : yearList) {
            if (p == te) {
                return false;
            }
        }
        //        yearList.add(p);
        //        return true;
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
}
