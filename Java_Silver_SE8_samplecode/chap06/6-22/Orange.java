class Orange {
    int i;

    Orange() {
        this(10);
    }

    Orange(int i) {
        this(this.i, 10);
        this.i = this.i * 10;
    }

    Orange(int i, int y) {
        this.i = this.i * y;
    }

    public static void main(String[] args) {
        System.out.println(new Orange().i);
    }
}