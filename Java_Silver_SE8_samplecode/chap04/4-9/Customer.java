class Customer {
    public static void main(String args[]) {
        Customer[] cust = {
            new Customer("Sato"),
            new Customer("Tanaka"),
        };
        System.out.println(cust);
        System.out.println(cust[1]);
        System.out.println(cust[1].name);
    }
    private String name;
    public Customer(String name) {
        this.name = name;
    }
}