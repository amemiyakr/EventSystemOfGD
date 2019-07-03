class Car {
    public void foo() {
        System.out.print("Parent,");
    }
}
class Truck extends Car {
    public void foo() throws Exception {
        super.foo();
        System.out.print("Child,");
        throw new Exception();
    }
    public static void main(String[] args) {
        try {
            new Truck().foo();
        } catch(Exception e) {
            System.out.println("Exception");
        }
    }
}