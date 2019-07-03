class ZeroDivide {
    public static void main(String args[]) {
        double dnum = 3.14;
        int num = 0;
        System.out.print(dnum / num);
        dnum = num;
        System.out.print(dnum / num);
    }
}