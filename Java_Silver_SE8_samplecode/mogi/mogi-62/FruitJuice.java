import java.io.IOException;
class Banana {
    void add() throws IOException {
        throw new IOException();
    }
}
public class FruitJuice {
    public static void main(String[] args) {
        try {
            Banana b = new Banana();
            System.out.print("before ");
            b.add();
            System.out.print("after ");
        // insert code here
            System.out.print("catch ");
        }
        System.out.println("done ");
    }
}