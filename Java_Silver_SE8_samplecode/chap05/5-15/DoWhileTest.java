class DoWhileTest {
    public static void main(String[] args) {
        int ary[] = {0, 1, 2, 3, 4};
        int num = 0;
        do {
            System.out.print(ary[num]);
        } while(num++ < ary.length);
    }
}