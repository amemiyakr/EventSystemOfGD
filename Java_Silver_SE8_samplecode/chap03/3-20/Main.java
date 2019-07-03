class Main {
    public static void main(String[] args) {
        Integer i = new Integer(10);
        
        switch(i) {
            case 20:
                System.out.print("10");
                break;
            case 40:
                System.out.print("20");
                break;
            case 30:
                System.out.print("30");
                break;
            case 10:
                System.out.print("40");
        }
    }
}