class Main {
    public static void main(String args[]) {
        try {
            // some code here
        } catch(NumberFormatException ex) {
            System.out.print("x");
        } catch(Exception ex) {
            System.out.print("y");
        } finally {
            System.out.print("z");
        }
    }
}