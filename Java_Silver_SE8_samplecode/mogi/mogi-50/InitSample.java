class Test1 {
    Test1() {
        System.out.print("init");
    }
}
class Test2 {
    Test2(String str) {
        System.out.print("INIT");
    }
}
class InitSample {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        Test2 t2 = new Test2();
    }
}