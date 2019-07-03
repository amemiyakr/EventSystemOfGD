class WhileTest {
    public static void main(String[] args) {
        String[] str = {"aa", "bb", "cc"};
        int num = 0;
        while(num < str.length) {
            System.out.print(num + str[num++] + num);
        }
    }
}