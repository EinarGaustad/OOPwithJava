package no;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

public class TestJavaCollection {
    
    public static void main(String[] args) {
        // ArrayList class implements the Collections interface
        Collection<String> coll = new ArrayList<String>();
        System.out.println(coll.toString());
        
        // the TreeSet 
        coll = new TreeSet<String>();
        int n = coll.size();
        System.out.println(n);
        coll.add("Ole");
        coll.add("Kari");
        String s = coll.toString();
        System.out.println(s);
        
        coll.remove("Ole");
        System.out.println(coll.toString());
        System.out.println(coll.remove("Nordman"));
        System.out.println(coll.contains("Kari"));
        coll.add("Lee");
        for (String element : coll) {
            System.out.println(" : " + element);
        }
        Iterator<String> iter = coll.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " : " + iter.toString());
        }
        System.out.println();

        String[] simpleTable = { "Per", "Morten", "Johan" };
        System.out.println("Simple table: " + simpleTable[0] + ", "
                + simpleTable[1] + ", " + simpleTable[2]);
        System.out.println();
        
        LinkedList<String>employee = new LinkedList<String>();
        System.out.println(employee.toString());
        employee.add("ll-Kari");
        employee.add("ll-Ole");
        employee.add("ll-Lee");
        System.out.println(employee.toString());
        ListIterator<String> liter = employee.listIterator();
        while (liter.hasNext()) {
            System.out.println(liter.next() + " next");
        }
        while (liter.hasPrevious()) {
            System.out.println(liter.previous() + " previous");
        }
    }
}
