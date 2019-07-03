class Test {
    static void method1(int num) {
        num += 10;
    }
    public static void main(String[] args) {
        int num = 5;
        method1(num);
        System.out.println(num);
    }
}