class ParentCalc {
    protected static int add(int a, int b) {
        return a + b;
    }
}

class ChildCalc extends ParentCalc {
    public static int add(int a, int b) {
        int c = super.add(a, b);
        return c;
    }
}

public class Test {
    public static void main(String args[]) {
        ChildCalc sc = new ChildCalc();
        System.out.print(sc.add(1, 4));
        System.out.print(ChildCalc.add(6, 3));
    }
}