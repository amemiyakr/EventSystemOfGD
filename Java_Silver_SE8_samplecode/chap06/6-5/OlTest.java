class OlTest {
    void foo(int i) {
        System.out.println("one");
    }
    void foo(String s) {
        System.out.println("two");
    }
    void foo(double d) {
        System.out.println("three");
    }
    public static void main(String[] args) {
        new OlTest().foo(2.0);
    }
}