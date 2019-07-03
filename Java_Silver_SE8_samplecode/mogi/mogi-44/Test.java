abstract class C1 {
    public C1() {
        System.out.print(1);
    }
}
class C2 extends C1 {
    public C2() {
        System.out.print(2);
        super();
    }
}
public class Test {
    public static void main(String[] args) {
        new C2();
    }
}