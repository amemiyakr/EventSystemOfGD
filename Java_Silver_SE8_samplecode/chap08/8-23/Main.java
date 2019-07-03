public class Main {
    public static void main(String[] args) {
        ex1();
    }
    private static void ex1() {
        ex2();
   }
    private static void ex2() {
        throw new Exception();
    }
}
