class BlockTest {
    public static void main(String args[]) {
        int num = 3;
        if(!(num > 3)) {
            System.out.print("abc");
        }
        {
            System.out.print("defg");
        }
        System.out.print("...");
    }
}