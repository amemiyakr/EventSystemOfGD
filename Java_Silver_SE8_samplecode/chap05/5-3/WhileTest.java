class WhileTest {
    public static void main(String[] args) {
        int num = 0;
        while(num < 5) {
            switch(num) {
                case 1:
                    System.out.print('A');
                case 2:
                    System.out.print('B');
                case 3:
                    System.out.print('C');
                default:
                    System.out.print('D');
            }
            num++;
        }
    }
}