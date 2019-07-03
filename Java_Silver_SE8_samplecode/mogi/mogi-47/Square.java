class Square {
    int squares = 81;

    public static void main(String[] args) {
        new Square().go();
    }

    void go() {
        incr(++squares);
        System.out.println(squares);
    }

    void incr(int squares) {
        squares += 10;
    }
}