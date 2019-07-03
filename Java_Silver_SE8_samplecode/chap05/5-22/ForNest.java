class ForNest {
    public static void main(String[] args) {
        int ary[][] = new int[5][];
        for(int i=0; i<ary.length; i++) {
            // insert code here
            for(int j=0; j<ary[i].length; j++) {
                ary[i][j] = i + j;
                System.out.print(ary[i][j]);
            }
            System.out.println();
        }
    }
}