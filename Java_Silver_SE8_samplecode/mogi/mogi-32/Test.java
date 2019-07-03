public class Test {
    private final int num;
    public Test(int num) {
        this.num = num;
    }
    public void updateNum(int num) {
        this.num = num;
    }
    public static void main(String[] args) {
        Test test = new Test(42);
        test.updateNum(69);
        System.out.println(test.num);
    }
}