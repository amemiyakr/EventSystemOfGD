class Employee { }

class Manager extends Employee { }

class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        Manager manager1 = new Manager();
        Manager barn2 = (Manager)employee1;
        Object obj1 = (Object)employee1;
        String str1 = (String)employee1;
        Employee build2 = (Employee)manager1;
    }
}