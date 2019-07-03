class InitializeAry {
    public static void main(String args[]) {
        int num1[] = new int[3];
        int num2[];
        num2 = num1;
        num1[0] = 1; num1[1] = 2; num1[2] = 3;
        System.out.println(num2[0] + num2[1] + num2[2]);
    }
}