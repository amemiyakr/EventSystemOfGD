class Apple {
    String size = "normal";
    void selectSize(String s) {
        size = s;
    }
    void print() {
        System.out.println(size);
    }
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.selectSize("large");
        apple.print();
    }
}