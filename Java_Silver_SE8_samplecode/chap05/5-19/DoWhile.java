public class DoWhile {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c"};
        int num = 0;
        do
            while(num < str.length)
                System.out.print(++num);
        while(num < str.length);
    }
}