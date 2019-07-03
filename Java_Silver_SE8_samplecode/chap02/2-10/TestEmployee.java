class Employee {
    public String name = "";
    public int age = 0;
    public String department = "Undeclared";
    public boolean fulltime = true;
    public void display() {
        System.out.println("Name: " + name + " Department: " + department);
    }
    public boolean isFullTime() {
        return fulltime;
    }
}
public class TestEmployee {
    public static void main(String[] args) {
        Employee suzuki = new Employee();
        Employee tanaka = new Employee();
        suzuki.name = "Suzuki";
        suzuki.age = 25;
        tanaka = suzuki;
        tanaka.name = "Tanaka";
        System.out.println("Suzuki's Name: " + suzuki.name);
    }
}