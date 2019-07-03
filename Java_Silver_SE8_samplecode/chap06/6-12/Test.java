class Test {
    static int staNum = 3;
    
    public static void main(String[] args) {
        Test test = new Test();
        test.staNum++;
        Test.staNum++;
        test.staNum++;
        System.out.println(Test.staNum + "" + test.staNum);
    }
}