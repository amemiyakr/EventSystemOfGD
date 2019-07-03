class Parent { }
class Child extends Parent { }

class Main {
    public static void main(String args[]) {
        Parent parent = (Parent) (new Child());
        Child child = (Child) (new Child());
        Child child2 = (Child) (new Parent());
    }
}