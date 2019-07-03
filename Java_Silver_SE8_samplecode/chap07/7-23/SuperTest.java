public class SuperTest {
    public static void main(String[] args) {
        // insert code here
        // insert code here
        // insert code here
    }
}
class Shape {
    public Shape() {
        System.out.println("Shape: constructor");
    }
    public void area() {
        System.out.println("Shape: area");
    }
}
class Square extends Shape {
    public Square() {
        super();
    }
    public Square(String label) {
        System.out.println("Square: constructor");
    }
    public void area() {
        super.area();
    }
    public void area(String label) {
        System.out.println("Square: area");
    }
}