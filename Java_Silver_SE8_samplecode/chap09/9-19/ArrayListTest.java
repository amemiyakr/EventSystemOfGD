import java.util.*;
class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);list.add(5);list.add(2);
        Collections.sort(list);
        list.add(3);
        Collections.reverse(list);
        System.out.println(list);
    }
}