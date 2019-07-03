package tests;
import static tests.Int.i;

public class Int {
    static int i;
}

class Main {
    public static void main(String args[]) {
        i = 10;
        sum(i);
        System.out.println(i);
    }
    static void sum(int i) {
        i += i;
    }
}