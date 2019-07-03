class Test0 {
    public void foo() {
        System.out.print("Afoo ");
    }
}
public class Test extends Test0 {
    public void foo() {
        System.out.print("Bfoo ");
    }
    public static void main(String[] args) {
        Test0 test0 = new Test();
        Test test = (Test)test0;
        test.foo();
        test0.foo();
    }
}