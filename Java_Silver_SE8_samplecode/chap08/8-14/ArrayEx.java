public class ArrayEx {
    public static void main(String[] args) {
        try {
            arry();
        } catch(Exception e) {
            System.out.println(e);
        } catch(RuntimeException ex) {
            System.out.println(ex);
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