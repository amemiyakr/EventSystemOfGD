class Test {
    public static void main(String[] args) {
        Boolean flag = new Boolean(true);
        int num1 = 216;
        int num2 = new Test().foo(flag, num1);
        System.out.println(num2);
    }

    int foo(Boolean flag, int num) {
        if(flag) {
            return (num / 6);
        }
        return (num / 36);
    }
}