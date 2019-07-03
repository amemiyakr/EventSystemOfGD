class ScopeTest {
    int num;
    public static void main(String[] args) {
        ScopeTest test = new ScopeTest();
        int num = 0;
        System.out.print(num);
        test.foo();
        System.out.print(num);
        System.out.print(test.num);
    }
    void foo() {
        int num = 1;
        bar();
        System.out.print(num);
    }
    void bar() {
        num = 2;
    }
}