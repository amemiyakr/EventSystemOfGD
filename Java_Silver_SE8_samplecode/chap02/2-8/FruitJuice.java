class Orange { }
public class FruitJuice {
    public static void main(String[] args) {
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        o1 = new Orange();
        Orange o3 = o2;
        o2 = null;
        o1 = o3;
        // GC
    }
}