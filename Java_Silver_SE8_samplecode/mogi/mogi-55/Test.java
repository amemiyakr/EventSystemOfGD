public class Test {
    public static void main(String[] args) {
        Message m, mA, mB;
        m = new Message();
        mA = new MessageA();
        mB = new MessageB();
        System.out.println(m.disp() + ", " + mA.disp() + ", " + mB.disp());
    }
}
class Message {
    public String disp() {
        return "message";
    }
}
class MessageA extends Message {
    public long disp() {
        return "AAA";
    }
}
class MessageB extends Message {
    public long disp() {
        return "BBB";
    }
}