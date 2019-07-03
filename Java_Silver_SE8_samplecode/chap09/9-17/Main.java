import java.util.ArrayList;
    
class Main {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>(10);
        al.add("a");
        al.add(3,"b");
        al.add("c");
        
        for(String s:al) {
            System.out.print(s);
        }
    }
}