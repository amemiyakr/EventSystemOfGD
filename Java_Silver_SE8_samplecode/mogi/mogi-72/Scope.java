class Scope {
    public static void main(String[] args) {
        int num = 1;
        Scope scope = new Scope();
        scope.foo(num);
        System.out.print(" main num = " + num);
    }
    void foo(int num) {
        System.out.print("foo num = " + --num);
    }
}