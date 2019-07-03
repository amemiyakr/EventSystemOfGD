class EqualsTest {
    public static void main(String[] args) {
        String str1 = "Hello!";
        String str2 = new String("Hello!");
        if(str1 == str2)
            System.out.println("match");
        if(str1.equals(str2))
            System.out.println("really match");
    }
}