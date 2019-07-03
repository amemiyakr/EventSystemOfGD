public class Arry {
    static int value;
    public static void main(String[] args) {
        addValue("123");
    }
    public static void addValue(String v) throws NumberFormatException {
        value = Integer.parseInt(v);
    }
}