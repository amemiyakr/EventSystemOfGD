class Foo {
    public static void main(String args[]) {
        int num = 4;
        if(num++ < 5) {
            System.out.println(num + "true");
        }else {
            System.out.println(num + "false");
        }
    }
}