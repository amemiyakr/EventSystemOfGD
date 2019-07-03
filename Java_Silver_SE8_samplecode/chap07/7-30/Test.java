class Test {
    public static void main(String[] args) {
        Test2 t2 = new Test2();
    }
}
class Test1 {
    public Test1() {
       System.out.print("1 ");
    }
}
class Test2 extends Test1 {
    public Test2() {
       System.out.print("2 ");
    }
}