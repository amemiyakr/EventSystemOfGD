class Nest {
    public static void main(String[] args) {
        String[] ary = {"aa", "bb", "cc"};
        for(String s : ary) {
            int num = 0;
            while(num < ary.length) {
                System.out.println(s + ", " + num);
                num++;
            }
        }
    }
}