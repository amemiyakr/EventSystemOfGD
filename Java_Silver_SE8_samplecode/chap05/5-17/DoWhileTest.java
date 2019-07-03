class DoWhileTest {
    public static void main(String[] args) {
        do {
            int num = 0;
            int ary[] = {0, 1, 2, 3, 4};
            System.out.print(ary[num++]);
        } while(num < ary.length);
    }
}