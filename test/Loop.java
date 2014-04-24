package test;

/**
 * 
 * @author GuoJunjun
 * 
 *         java for loop
 * 
 *         for (initialization; termination; increment) { statement(s) }
 */
public class Loop {
    
    public static void main(String[] args) {
        
        for (int a = 0; a < 10; a++) {
            System.out.print(a+", ");
        }
        System.out.println();
        
        for (int i = 0, j = 11; i < 5 & j > 0; i++, j--) {
            System.out.print(" |  i: " + i + " j: " + j);
        }
        System.out.println();
        
        for (int i = 0, j = 11; i < 5 || j > 0; i++, j--) {
            System.out.print(" |  i: " + i + " j; " + j);
        }
        System.out.println();
    }
}
