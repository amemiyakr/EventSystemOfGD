class EnhFor {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c", "d"};
        for(String s : str) {
            if("a".equals(s)) {
                continue;
            }
            System.out.print(s);
            if("c".equals(s)) {
                break;
            }
        }
    }
}