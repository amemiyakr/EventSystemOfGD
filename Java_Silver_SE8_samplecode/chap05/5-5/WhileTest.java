class WhileTest {
    public static void main(String[] args) {
        int num0 = 0, num1 = 1, num2 = 1;
        while(num2 < 10) {
            num0 = num1;
            num1 = num2;
            num2 = num0 + num1;
        }
        System.out.println(num2);
    }
}