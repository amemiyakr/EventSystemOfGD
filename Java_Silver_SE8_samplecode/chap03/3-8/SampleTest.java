class SampleTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int z = 20;
        
        if((i < j) && (i > z) || (j == z)) {
            System.out.print("true : ");
        } else {
            System.out.print("false : ");
        }
        if(i < j && i > z || j == z) {
            System.out.print("true : ");
        } else {
            System.out.print("false : ");
        }
        if((i < j) && ((i > z) || (j == z))) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}