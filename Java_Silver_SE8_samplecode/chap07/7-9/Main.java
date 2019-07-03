class Message {
    public void out() {
        System.out.print("Message ");
    }
}
class ErrorMessage extends Message {
    public void out() {
        super.out();
        System.out.print("ErrorMessage ");
    }
}
class Main {
    public static void main(String args[]) {
        Message m = new Message();
        m = new ErrorMessage();
        m.out();
    }
}