class SbTest {
    public static void main(String[] args) {
        int x = 100;
        int y = x;
        x++;
        StringBuilder sb1 = new StringBuilder("123");
        StringBuilder sb2 = sb1;
        sb1.append("4");
        System.out.println((x == y) + " " + (sb1 == sb2));
    }
}