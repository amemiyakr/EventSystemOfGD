class Customer {
    int no;
    String name;
    Customer() {
        // insert code here
    }
    public static void main(String[] args) {
        Customer cs = new Customer();
        // insert code here
        System.out.println(cs);
    }
    public String toString() {
        return no + " : " + name;
    }
}