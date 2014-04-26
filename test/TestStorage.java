package test;


public class TestStorage {
    
    public static void main(String[] args) {
        // Storage s = new Storage(10);
        // s.add(5);
        // Storage s1 = new Storage(9);
        // s1.add(9);
        // System.out.println("-----");
        // Storage s2 = new Storage();
        // s2.add(1);
        // Storage.adds(1);
        // Storage s3 = new Storage();
        // s3.add(1);
        // Storage.adds(1);
        // System.out.println("-----");
        // Storage s4 = new Storage();
        // s4.add(1);
        // Storage.adds(1);
        // Storage s5 = new Storage();
        // s5.add(1);
        // Storage.adds(1);
        for (int i = 0; i < 10; i++) {
            Storage ss = new Storage();
            ss.add(10);
            Storage.adds(10);
            System.out.println("total: " + ss.getTotal() + "\n" + "s total: "
                    + Storage.getsTotal() + " ;");
        }
    }
}
