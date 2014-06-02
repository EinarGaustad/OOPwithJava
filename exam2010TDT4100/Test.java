package exam2010TDT4100;

public class Test {
    
    public static void main(String[] args) {
        A a = new B();
        //B b = (B) new A();
        B b = new B();
        System.out.println(a.toString() + "\n");
        System.out.println(new A().toString() + "\n");
        G g = new B();
        C c = new C();
        
        System.out.println((a.methodA() == c.methodG(a)) + "\n");
        System.out.println("---");
        System.out.println("b.toString: " + b.toString() + "\n");
        System.out.println("b.methodA(): " + b.methodA() + "\n");
        System.out.println("b.methodA().toString: " + b.methodA().toString());
        System.out.println("-----");
        System.out.println(b.methodG(new B()).toString() + "\n");
        System.out.println((((G) b).methodG(a)) + "\n");
        System.out.println((((B) g).methodG(b)) + "\n");
        System.out.println((((C) c).methodG(b)) + "\n");
        System.out.println((((G) c).methodG(a)));
    }
    
}
