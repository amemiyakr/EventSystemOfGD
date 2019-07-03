class Pug {
    void walk(int i) {
        System.out.println("Pug was walking " + i + "km");
    }
    void walk(double d) {
        System.out.println("Pug was walking " + d + "km");
    }
    void walk(String s) {
        System.out.println("Pug was walking " + s + "km");
    }
    void walk(short s) {
        System.out.println("Pug was walking " + s + "km");
    }
}
class Main {
    public static void main(String args[]) {
        (new Pug()).walk(10L);
    }
}