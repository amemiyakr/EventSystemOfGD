class Super {
    public int data() {
        return 100;
    }
}
class Sub {
    public static void main(String[] args) {
        Sub t = new Sub();
        t.func();
    }
    public void func() {
        System.out.println(status() + " " + super.data() + " " + data());
    }
    public int status() {
        return 1000;
    }
    public int data() {
        return 10000;
    }
}