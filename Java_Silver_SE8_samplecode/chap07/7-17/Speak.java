public class Speak {
    public static void main(String[] args) {
        Speak sp = new Tell();
        Tell te = new Tell();
        // insert code here
    }
}
class Tell extends Speak implements Truth {
    public void tell() {
        System.out.println("Right on!");
    }
}
interface Truth {
    public void tell();
}