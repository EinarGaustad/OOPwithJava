package exam2010TDT4100;

public class Test {
    
    public void test1() {
        A a = new B();
        //B b = (B) new A();
        B b = new B();
        System.out.println(a.toString() + "\n");
        System.out.println(new A().toString() + "\n");
        G g = new B();
        C c = new C();
        
        //        System.out.println((a.methodA() == c.methodG(a)) + "\n");
        System.out.println("---");
        System.out.println("b.toString: " + b.toString() + "\n");
        System.out.println("b.methodA(): " + b.methodA() + "\n");
        System.out.println("b.methodA().toString: " + b.methodA().toString());
        System.out.println("-----");
        System.out.println(b.methodG(new B()).toString() + "\n");
        System.out.println((((G) b).methodG(a)) + "\n");
        System.out.println((((B) g).methodG(b)) + "\n");
        //        System.out.println((((C) c).methodG(b)) + "\n");
        System.out.println((((G) c).methodG(a)));
    }
    
    public void test2() {
        A a = new A();
        B b = new B();
        C c = new C();
        G g = null;
        System.out.println(a = a);
        System.out.println(a = b);
        System.out.println(a = c);
        System.out.println(a == g);//cant not convert a to g, g is a interface
    }
    
    public void test3(){
        A a = new A();
        B b = new B();
        C c = new C();
        G g = new B();
        H h = new D();
        H l = null;
        H e = new E();
        
        System.out.println("e instanceof H: " + (e instanceof H));
        System.out.println(e instanceof E);
        System.out.println(e instanceof G);
        System.out.println(g instanceof H);
        System.out.println(e instanceof H);
        System.out.println("g instanceof G " + (g instanceof G));
        System.out.println("l instanceof H: " + (l instanceof H));// false because l=null
        System.out.println();
        System.out.println(l = e);
        System.out.println(h = l);
        System.out.println(a = c);
        System.out.println(h = e);
        System.out.println("h: " + h);
        h = l;
        System.out.println("h: " + h);
        h = e;
        System.out.println("h: " + h);
    }
    
    public static void main(String[] args) {
        Test t = new Test();
        t.test3();
    }
    
}
