import java.util.*;
public class AList {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>(10);
        al.add(0);
        al.add(1);
        al.add(2);
        al.add(3);
        al.remove(0);
        al.remove(1);
        for(Integer i:al) {
            System.out.print(i);
        }
    }
}
