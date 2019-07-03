class Orange { }
class Banana { }
public class FruitJuice {
    public static void main(String[] args) {
        Orange o1 = new Orange();
        Orange o2 = o1;
        o1 = new Orange();
        Orange o3 = new Orange();
        o2 = null;
        o1 = o3;
        Banana b1 = new Banana();
        Banana b2 = new Banana();
        b1 = new Banana();
        Banana b3 = b1;
        b2 = null;
        b1 = null;
        // GC
    }
}