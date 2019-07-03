public class Test {
    public static final String FOO = "foo";
    public static void main(String[] args) {
        Test test = new Test();
        Test2 test2 = new Test2();
        System.out.print(Test.FOO);
        System.out.print(Test2.FOO);
        System.out.print(test.FOO);
        System.out.print(test2.FOO);
        System.out.print(((Test)test2).FOO);
    }
}
class Test2 extends Test {
    public static final String FOO = "bar";
}