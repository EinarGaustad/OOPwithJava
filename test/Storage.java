package test;


public class Storage {
    
    private static int stotal = 0;
    private int        total  = 0;
    
    // public Storage(int total) {
    // this.total = total;
    // stotal = total;
    // System.out.println("init total: " + total);
    // System.out.println("init s total: " + stotal);
    // }
    //
    // public Storage() {
    // this.total = 1;
    // stotal = 1;
    // System.out.println("init total: " + total);
    // System.out.println("init s total: " + stotal);
    // }

    public void add(int nr) {
        this.total += nr;
        // System.out.println("total: " + total);
    }
    
    public static void adds(int nr) {
        stotal += nr;
        // System.out.println("s total: " + stotal);
    }
    
    public static int getsTotal() {
        return stotal;
    }
    
    public int getTotal() {
        return total;
    }
}
