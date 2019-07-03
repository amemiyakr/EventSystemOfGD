class App {
    public static void main(String[] args) {
        String[] str = {"AA", "BB", "CC", "DD"};
        str[1] = str[3];
        String[] str2 = str;
        str2[3] = "XX";
        for(String s : str) {
            System.out.print(s + " ");
        }
    }
}