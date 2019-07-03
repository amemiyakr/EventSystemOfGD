class Banana {
    void add() throws Exception { 
        System.out.println("Banana "); 
    }
}
public class FruitJuice {
    public static void main(String[] args) {
        Banana b = new Banana();
        b.add();
    }
}