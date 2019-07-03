class Flag {
    public static void main(String args[]) {
        boolean flag1 = false;
        boolean flag2 = true;
        System.out.print(flag1 = flag2 && flag1);
        System.out.print((flag1 = flag2) && flag1);
    }
}