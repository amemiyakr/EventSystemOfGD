class Test {
    public static void main(String args[]) {
        Boolean b1 = new Boolean(Boolean.parseBoolean("true"));
        Boolean b2 = new Boolean(null);
        Boolean b3 = null;
        System.out.println(b1 + " : " + b2 + " : " + b3);
    }
}