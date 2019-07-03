class Num {
    public int value;
    public void calc() {
        value += 7;
    }
}
public class IntNum extends Num {
    public void calc() {
        value -= 3;
    }
    public void calc(int multi) {
        calc();
        super.calc();
        value *= multi;
    }
    public static void main(String[] args) {
        IntNum intNum = new IntNum();
        intNum.calc(2);
        System.out.println("Value is: " + intNum.value);
    }
}