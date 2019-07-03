class Test {
    int foo(double d) {
        System.out.println("one");
        return 0;
    }
    String foo(double d) {
        System.out.println("two");
        return null;
    }
    double foo(double d) {
        System.out.println("three");
        return 0.0;
    }
    public static void main(String[] args) {
        new Test().foo(4.0);
    }
}