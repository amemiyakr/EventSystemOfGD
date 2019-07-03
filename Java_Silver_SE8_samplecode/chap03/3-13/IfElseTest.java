class IfElseTest {
    public static void main(String[] args) {
        int num = 22;
        if(num >= 0) {
            if(num != 0)
                System.out.print("the ");
            else
                System.out.print("quick ");
            if(num < 5)
                System.out.print("brown ");
            if(num > 20)
                System.out.print("fox ");
            else if(num < 30)
                System.out.print("jumps ");
            else if(num < 10)
                System.out.print("over ");
            else
                System.out.print("the ");
            if(num > 10)
                System.out.print("lazy ");
        } else {
            System.out.print("dog ");
        }
        System.out.print("...");
    }
}