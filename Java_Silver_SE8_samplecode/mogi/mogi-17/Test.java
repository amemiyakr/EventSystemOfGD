class Test {
    public static void main(String[] args) {
        Test t1 = new Test(10, "100");
        Test t2 = t1;
        Test t3 = new Test(10, "100");
        System.out.print((t1.getNo() == t3.getNo()) + " : ");
        System.out.print((t2.getId() == t3.getId()) + " : ");
        System.out.print(t1 == t3);
    }
    private int no;
    private String id;
    public Test(int n, String i) {
        no = n;
        id = i;
    }
    public int getNo() {
        return no;
    }
    public String getId() {
        return id;
    }
}