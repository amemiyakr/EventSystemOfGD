class Orange {
    private int x;
    
    public Orange(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
}

public class Juice {
    static Orange foo(Orange orange) {
        orange = new Orange(100);
        return orange;
    }
    public static void main(String[] args) {
        Orange orange = new Orange(200);
        System.out.print(orange.getX() + "-");
        orange = foo(orange);
        System.out.print(orange.getX());
    }
}