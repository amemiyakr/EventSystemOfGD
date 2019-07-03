class ArrayTest {
    public static void main(String[] args) {
        int[] i = {100, 300, 500, 700, 900};
        char c[] = new char[4];
        String s[];
        
        int j = 0;
        j += i.length;
        j += c.length;
        j += s.length;
        
        System.out.println(j);
    }
}