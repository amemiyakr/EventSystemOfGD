class Test {
    public static void main(String[] args) {
        Test t1 = new Test(100);
        Test t2 = new Test(50);
        Test t3 = new Test(10);
        t1.func();
        t2.func();
        t3.func(); 
    }
    private int i;
    private static int j;
    public Test(int i) {
        this.j += i;
        this.i += i;
    }
    public void func() {
        System.out.println("i : " + i + " j : " + j);
    }
}
