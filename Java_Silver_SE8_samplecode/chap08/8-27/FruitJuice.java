class Banana {
    void add() throws Exception {
        // ��O����������\���̂���R�[�h
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