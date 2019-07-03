import java.util.*;
class ArrayListLoop {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++)
            if(i % 2 == 0)list.add(i);
        list.add(7);
        System.out.println(list);
    }
}