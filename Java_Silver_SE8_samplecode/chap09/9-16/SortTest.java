import java.util.*;
class SortTest {
    public static Collection get() {
        Collection<String> sorted = new ArrayList<String>();
        sorted.add("B"); sorted.add("C"); sorted.add("A");
        return sorted;
    }
    public static void main(String[] args) {
        for(Object obj: get()) {
            System.out.print(obj + ", ");
        }
    }
}