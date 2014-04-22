package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    
    public static void main(String[] args) {
        Apple a = new Apple("red", 5);
        Orange o = new Orange("orange", 9);
        
        System.out.println(a.toString());
        System.out.println(o.toString());
        Fruit f = new Orange("color", 20);
        System.out.println(f.toString());
        Apple m = new Mango("color", 3);
        System.out.println(m.toString());
        System.out.println(f instanceof Orange);
        
        char c = (char) ('a' + 1);

        System.out.println(c);
        int i = 'b' - 'a';
        System.out.println(i);
        int z = 'b';
        System.out.println(z);
        char ic = 98;
        System.out.println(ic);
        
        char t1 = 'a';
        char t2 = 'b';
        System.out.println((t1 + 1) == t2);
        System.out.println((t1 + 1));
        
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.size());

        Iterator<String> it = list.iterator(); // !

        for (int j = 0; j < "abc".length(); j++) {
            if (it.hasNext()) {
                String s = list.iterator().next();
                String ss = list.iterator().next();
                System.out.println(s + " : " + it.next());
                System.out.println(list.get(j));
                System.out.println("2: "
                        + ((Iterator<String>) list.iterator()).next());
            }
        }
        // for (Iterator<String> it = list.iterator(); it.hasNext();) {
        // System.out.println(it.next());
        // }
        for (String s : list) {
            System.out.println("method 3: " + s);
        }
    }
    
    private static Iterator<String> iterator(List<String> list) {
        // TODO Auto-generated method stub
        return null;
    }
}
