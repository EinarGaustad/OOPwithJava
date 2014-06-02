package exam2010TDT4100;


public class C implements G {
    
    @Override
    public String methodG(A a) {
        //System.out.println("methodG from class C: " + a.toString());
        return a.toString() + " -methodG from class C";
    }
}
