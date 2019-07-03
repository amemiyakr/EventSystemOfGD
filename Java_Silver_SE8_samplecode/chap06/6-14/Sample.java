class Sample {
    int i = 0;
    static int j = 0;
    void count() {
        for(int z = 0; z < 3; z++) {
            i++; j++;
        }
    }
    public void disp() {
        System.out.println("i = " + i + " : j = "+ j);
    }
    public static void main(String[] args) {
        Sample s1 = new Sample();
        s1.count();
        s1.disp();
        Sample s2 = new Sample();
        s2.count();
        s2.disp();
    }
}
