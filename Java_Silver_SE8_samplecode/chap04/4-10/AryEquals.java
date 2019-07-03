class AryEquals {
    public static void main(String[] args) {
        String str1[] = {"AAA", "BBB", "CCC"};
        String str2[] = {"AAA", "BBB", "CCC"};
        String str3[] = new String[3];
        str3[0] = "AAA";
        str3[1] = "BBB";
        str3[2] = "CCC";
        
        System.out.print(str1 == str1);
        System.out.print(" : ");
        System.out.print(str1 == str2);
        System.out.print(" : ");
        System.out.print(str1 == str3);
    }
}