class MyBuffer {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("123456789");
        sb.delete(0,3).delete(1,2).replace(2,4,"4");
        System.out.println(sb);
    }
}