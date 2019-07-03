class Taxi extends Car {
    public static void main(String[] args) {
        try { 
            System.out.println(new Taxi().speed("80"));
        } catch(Exception e) {
            System.out.println("Exception");
        }
    }
    int speed(String s) {
        return Integer.parseInt(s);
    }
}
class Car {
    int speed(String s) throws Exception {
        return 80;
    }
}