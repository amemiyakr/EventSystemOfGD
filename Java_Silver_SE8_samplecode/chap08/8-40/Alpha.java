class X {
    public void test1() {
        Y y = new Y();
        y.test2();
        // more code here
    }
}
class Y {
    public void test2() {
        Z z = new Z();
        z.test3();
        // more code here
    }
}
class Z {
    public void test3() {
        // NullPointerExceptionÇ™î≠ê∂
    }
}
public class Alpha {
    public static void main(String[] args) {
        try {
            X x = new X();
            x.test1();
        } catch(Exception e) {
            System.out.print("Error");
        }
    }
}