public class Employee {
    public static void main(String[] args) {
        Manager mgr = new Manager();
        Employee emp = new Employee();
        emp = mgr;
        System.out.print("emp:" + emp.getClass());
        System.out.print(" mgr:" + mgr.getClass());
    }
}
class Manager extends Employee {
}