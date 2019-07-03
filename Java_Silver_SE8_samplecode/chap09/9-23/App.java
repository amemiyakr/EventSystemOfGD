import java.util.*;
import java.util.function.*;
class App {
    public static void main(String[] args) {
        Customer c1 = new Customer("AAA", 500);
        Customer c2 = new Customer("BBB", 300);
        List<Customer> list = Arrays.asList(c1,c2);
        // insert code here
    }
    public static void func(List<Customer> list, Predicate<Customer> p) {
        for(Customer c : list) {
            if(p.test(c)) {
                System.out.println(c.getName());
            }
        }
    }
}
class Customer {
    private String name;
    private int point;
    public Customer(String name, int point) {
        this.name = name;
        this.point = point;
    }
    public String getName() {
        return this.name;
    }
    public int getPoint() {
        return this.point;
    }
}