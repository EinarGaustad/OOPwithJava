package exam2010TDT4100;


public class B extends A implements G {
    
    @Override
    public String methodG(A a) {
        //System.out.println("methodG from class B: " + a.toString());
        return a.toString() + " -methodG from class B: ";
    }
    
    public String toString() {
        return "this is B & B extends A implements G";
    }
    
}
