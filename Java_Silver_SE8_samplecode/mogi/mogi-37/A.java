interface A {
    public void m1();
}

class B implements A {
}

class C implements A {
    public void m1() {
    }
}

class D implements A {
    public void m1(int x) {
    }
}

abstract class E implements A {
}