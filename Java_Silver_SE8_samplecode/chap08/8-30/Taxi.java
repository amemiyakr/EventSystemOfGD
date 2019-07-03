class Car {
    void drive() throws Exception {
        throw new Exception();
    }
}
class Taxi extends Car {
    public static void main(String[] args) {
        try { 
            new Taxi().drive();
        } catch(Exception e) {
            System.out.println("Exception");
        }
    }
    void drive() throws RuntimeException {
        throw new RuntimeException();
    }
}