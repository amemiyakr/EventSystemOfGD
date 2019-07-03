abstract class Animal {
    abstract void bark();
    void eat() {}
}
interface Flyer {
    void fly();
}
class Dog extends Animal {
    void bark() {}
    void eat() {}
    void play() {}
}
class Bird implements Flyer {
    public void fly() {}
    public void twitter() {}
}
class Main {
    public static void main(String args[]){
        Animal a = new Dog();
        Flyer f = new Bird();
        a.bark();
        a.eat();
        a.play();
        f.fly();
        f.twitter();
    }
}