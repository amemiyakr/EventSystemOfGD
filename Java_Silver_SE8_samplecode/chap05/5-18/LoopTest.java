class LoopTest {
    public static void main(String[] args) {
        boolean flag = false;
        do
            System.out.print('A');
        while(flag);
        while(flag)
            System.out.print('B');
    }
}