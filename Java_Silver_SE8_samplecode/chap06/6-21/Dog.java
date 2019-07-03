class Dog {
    int i;

    Dog() {
        this(10);
    }

    Dog(int i) {
        this(i, 10);
        i = i * 10;
    }

    Dog(int i, int y) {
        i = i * y;
    }

    public static void main(String[] s) {
        System.out.println(new Dog().i);
    }
}