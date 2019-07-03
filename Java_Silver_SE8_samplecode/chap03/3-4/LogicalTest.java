class LogicalTest {
    public static void main(String[] args) {
        boolean flag1 = (1 != 0) && (2 != 3);
        boolean flag2 = (4 != 4) || (4 == 4);
        System.out.print("flag1: " + flag1 + " flag2: " + flag2);
    }
}