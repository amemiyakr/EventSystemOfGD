interface Navi { }
class Car implements Navi { }
class SportCar extends Car{ }
public class F1Car extends SportCar {
    public static void main(String[] args) {
        SportCar sc = new SportCar();
        // insert code here
    }
}