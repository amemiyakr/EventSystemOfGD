class InstanceVariable {
    int num1;
    static int num2;
    public static void main(String[] args) {
        new InstanceVariable().foo();
    }
    void foo() {
        int num3 = 3;
        bar();
        System.out.print(num3);
    }
    void bar() {
        int num4 = 8;
        System.out.print(num4);
        for(int num5 = 0; num5 < 10; num5++) {
            System.out.print(num5);
            System.out.print(num4);
        }
    }
}