class App {
    private static int v1;
    private int v2;
    public App() {
        this(20, 40);
    }
    public App(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    public void func() {
        System.out.print(v1 + " : " + v2 + " : ");
    }
}
class Test {
    public static void main(String[] args) {
        App a1 = new App(10, 30);
        App a2 = new App();
        a1.func(); a2.func();
    }
}