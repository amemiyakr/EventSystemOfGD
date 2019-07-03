class Sample {
    public static void main(String[] args) {
        String s1 = "1 ";
        String s2 = "2 ";
        String s3 = s1.concat(s2);
        String s4 = "3 ";
        s3 = s3.concat(s4);
        s3.replace('3','4');
        s1 = s4.concat(s3);
        System.out.println(s1);
    }
}