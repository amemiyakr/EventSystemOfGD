class Test {
    public static void main(String args[]) {
        Test t = new Test();
        t.func(50, 100);
        t.func(50.0, 100.0);
    }
    static void func(int num1, int num2) {
        System.out.println("int : " + (num1 + num2));
    }
    static void func(float num1, float num2) {
        System.out.println("float : " + (num1 + num2));
    }
    static void func(Double num1, Double num2) {
        System.out.println("Double : " + (num1 + num2));
    }
    static void func(Integer num1, Integer num2) {
        System.out.println("Integer : " + (num1 + num2));
    }
}