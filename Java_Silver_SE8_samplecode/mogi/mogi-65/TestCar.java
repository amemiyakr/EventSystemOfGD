abstract class Vehicle {
    public Vehicle() {
        System.out.print(1);
    }
}
class Car extends Vehicle {
    public Car() {
        System.out.print(2);
    }
}
public class TestCar {
    public static void main(String[] args) {
        new Car();
    }
}