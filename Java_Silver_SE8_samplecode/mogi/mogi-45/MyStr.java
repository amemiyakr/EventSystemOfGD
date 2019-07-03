class MyStr {
    public static void main(String args[]) {
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.print(str1 == str2);
        System.out.print(" ");
        System.out.print(str1.equals(str2));
        System.out.print(" ");
        str1 = str2;
        System.out.print(str1 == str2);
    }
}
