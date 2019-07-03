class CalcTest {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        
        i = j++;
        System.out.print(i);
        
        i = (j++);
        System.out.print(i);
    }
}