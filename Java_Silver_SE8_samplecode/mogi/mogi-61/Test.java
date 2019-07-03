public class Test {
    static int snum;
    int num;
    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();
        test1.num++;
        test1.snum++;
        test2.num++;
        test2.snum++;
        System.out.print(test1.num);
        System.out.print(test1.snum);
        System.out.print(test2.num);
        System.out.print(test2.snum);
    }
}