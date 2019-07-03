class Drink {
    Drink() {
        System.out.print(1);
    }
    Drink(int num) {
        this();
        System.out.print(2);
    }
}
public class Tea extends Drink {
    Tea() {
        super(6);
        System.out.print(3);
    }
    Tea(int num) {
        this();
        System.out.println(4);
    }
    public static void main(String[] args) {
        new Tea(5);
    }
}