class Fruit {
    void display() {
        System.out.printf("Fruit");
    }
}

class Apple extends Fruit {
    void display() {
        System.out.printf("Apple");
    }
}

class Main {
    public static void main(String[] args) {
        Fruit f;
        if(args[0].equals("f")) {
            f = new Fruit();
        } else {
            f = new Apple();
        }
        Apple a = f;
        a.display();
    }
}