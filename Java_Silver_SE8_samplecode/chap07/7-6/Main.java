abstract class Dog {
    abstract public void walk();
}

class Pug extends Dog {
    public void walk() {
        System.out.println("Pug is walking.");
    }
}

class Main {
    public static void main(String args[]) {
        Dog dog;
        // insert code here
    }

    void play(Dog dog) {
        dog.walk();
    }
}