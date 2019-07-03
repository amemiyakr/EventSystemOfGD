class Test {
    public static void foo(long n) {
        System.out.print("long ");
    }
    public static void foo(int n) {
        System.out.print("int ");
    }
    public static void main(String[] args) {
        short x = 1;
        long y = 2;
        foo(x);
        foo(y);
    }
}