public class ArrayTest {
    public static void main(String[] args) {
        try {
            arry();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    static void arry() {
        int[] ages = new int[5];
        ages[5] = 10;
        getRuntimeException();
    }
    static void getRuntimeException() {
        throw new RuntimeException("Runtime Exception!");
    }
}