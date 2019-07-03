class Fruit {
    void foo() throws Exception {
        throw new Exception();
    }
}
class Orange extends Fruit {
    void foo() {
        System.out.println("B ");
    }
}
class FruitTest {
    public static void main(String[] args) {
        Fruit f = new Orange();
        f.foo();
    }
}