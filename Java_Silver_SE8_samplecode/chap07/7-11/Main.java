public class Main implements Inter {
    public String toString() {
        return "I am Main";
    }
    public static void main(String[] args) {
        Sub sub = new Sub();
        Main main = sub;
        Inter inter = main;
        System.out.println(inter);
    }
}
class Sub extends Main {
    public String toString() {
        return "I am Sub";
    }
}
interface Inter {}