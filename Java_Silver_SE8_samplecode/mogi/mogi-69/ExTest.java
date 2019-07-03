public class ExTest {
    static void test() throws RuntimeException {
        try {
            System.out.print("test() ");
            throw new RuntimeException();
        } catch(Exception ex) { 
            System.out.print("Exception ");
        }
    }
    public static void main(String[] args) {
        try { 
            test(); 
        } catch(RuntimeException ex) {
            System.out.print("RuntimeException ");
        }
        System.out.print("main() end ");
    }
}
