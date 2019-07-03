class SwitchTest {
    public static void main(String[] args) {
        String str = "Hello";
        switch(str) {
            case "Hello":
                System.out.print("Say Hello");
            case "Good bye": 
                System.out.print(" Say Good bye");
                break;
            case "Thanks":
                System.out.print(" Say Thanks");
                break;
            default:
                System.out.print(" Say Default");
        }
    }
}