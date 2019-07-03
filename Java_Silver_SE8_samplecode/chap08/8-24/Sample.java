class Sample {
    public static void main(String[] args) {
        new Test().func();
    }
}
class Test {
    public void func() {
        throw new Exception();
    }
}