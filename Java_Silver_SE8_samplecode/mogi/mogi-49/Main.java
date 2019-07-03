interface Dog {
    public void walk();
}
class Poodle implements Dog {
    public void walk() {
        System.out.println("Poodle walking.");
    }
}
class MediumPoodle extends Poodle {
    public void walk() {
        System.out.println("MediumPoodle walking.");
    }
}
class Main {
    public static void main(String args[]) {
        Poodle poodle;
        Dog dog = new MediumPoodle();
        // insert code here
        poodle.walk();
    }
}