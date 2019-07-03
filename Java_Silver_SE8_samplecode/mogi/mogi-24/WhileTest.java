class WhileTest {
    public static void main(String args[]) {
        int j = 0, k = 0;
        for(int i = 0; i < 1; i++) {
            do {
                k = 0;
                while(k < 3) {
                    k++;
                    System.out.print(k + " ");
                }
                j++;
            } while(j < 2);
            System.out.print("-");
        }
    }
}