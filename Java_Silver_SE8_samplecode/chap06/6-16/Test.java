class Apple {
    String size = "normal";
    Apple(String s) { 
        size = s;
    }
    void print() {
        System.out.println(size);
    }
}
class Test {
    public static void main(String[] args) {
        new Apple("large").print();
    }
}