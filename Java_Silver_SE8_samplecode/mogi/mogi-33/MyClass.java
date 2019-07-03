class MyClass {
    int num;
    void foo() {
        num = 100;
    }
}
class Main {
    public static void main(String args[]) {
        MyClass mc = new MyClass();
        MyClass mc2 = mc;
        mc.foo();
        mc2.num *= 2;
        mc2 = null;
        System.out.println(mc.num);
    }
}