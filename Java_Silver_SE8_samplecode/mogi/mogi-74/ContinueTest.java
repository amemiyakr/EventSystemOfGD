class ContinueTest {
    public static void main(String[] args) {
        int num = 0;
        do {
            if(num < 2) {
                continue;
            }
            System.out.print(num);
        } while(num++ < 5);
    }
}