class Test {
    public static void main(String args[]) {
        if(test("True")) {
            System.out.println("True");
        } else {
            System.out.println("Not true");
        }
    }
    static Boolean test(String str) {
        return Boolean.valueOf(str);
    }
}