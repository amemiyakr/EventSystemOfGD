import java.util.ArrayList;
class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(101);
        System.out.println(list.get(list.size()));
    }
}