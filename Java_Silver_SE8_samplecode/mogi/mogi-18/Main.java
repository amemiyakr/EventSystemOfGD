class Runtime {
    void run() {
        throw new RuntimeException();
    }
}
class Except {
    void run() throws Exception {
        throw new Exception();
    }
}
class Main {
    public static void main(String ggs[]) throws Throwable {
        new Runtime().run();
        new Except().run();
    }
}