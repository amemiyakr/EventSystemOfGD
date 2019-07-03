class BarSample {
    public static void main(String[] args) {
        int foo = 0;
        BarSample ts = new BarSample();
        ts.func(foo);
        System.out.print(foo);
    }
    public void func(int foo) {
        if(++foo > 0) {
            foo++;
        }
        System.out.print(foo);
    }
}