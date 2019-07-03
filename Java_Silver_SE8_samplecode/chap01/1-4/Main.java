class Main {
    static int i;

    public static void main(String[] args) {
        int i = 10;
        i = set(i);
        i = get();
        println();
    }
    static int set(int i) {
        i = i;
        return i++;
    }
    static int get() {
        return i++;
    }
    static void println() {
        System.out.println(i);
    }
}