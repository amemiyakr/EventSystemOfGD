class Banana {
    void add() throws Exception {
        // 例外が発生する可能性のあるコード
    }
}
public class FruitJuice {
    public static void main(String[] args) {
        try {
            Banana b = new Banana();
            System.out.print("before ");
            b.add();
            System.out.print("after ");
        } catch(Exception ex) {
            System.out.print("catch ");
        }
        System.out.println("done ");
    }
}