class ExTest {
    static void foo() {
        String str = null;
        System.out.print(str.toString());
    }
    public static void main(String[] args) {
        try {
            foo();
        } catch(Exception ex) {
            System.out.print("exception ");
        } finally {
            System.out.print("finally ");
        }
    }
}