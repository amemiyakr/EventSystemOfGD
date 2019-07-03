public class Main {
    public static void main(String[] args) throws Exception {
        ex();
    }
    private static void ex() throws Exception {
        System.out.println("Before");
        if((Math.random() * 10) > 5) {
            throw new Exception();
        }
        System.out.println("After");
    }
}