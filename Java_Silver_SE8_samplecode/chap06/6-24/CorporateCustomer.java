class Customer {
    private void charge() {
    }
}
class CorporateCustomer extends Customer {
    private void service() {
        charge();
    }
    public static void main(String[] args) {
        CorporateCustomer cc = new CorporateCustomer();
        cc.service();
    }
}