class Foo {
    private int num;
    public Foo(int n) {
        num = n;
    }
    public void setNum(int n) {
        num = n;
    }
    public int getNum() {
        return num;
    }
}

public class Bar {
    static void changeFoo(Foo f) { 
        // insert code here 
    }
    public static void main(String[] args) {
        Foo f = new Foo(100);
        changeFoo(f);
        System.out.println("f is " + f.getNum());
    }
}