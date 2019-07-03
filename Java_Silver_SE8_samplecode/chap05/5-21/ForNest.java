class ForNest {
    public static void main (String[] args) {
        int ary[][]=new int[5][5];
        for(int i=0; i<ary.length; i++) {
            for(int j=0; j<ary[i].length; j++) {
                ary[i][j] = i+j;
            }
        }
        for(int i=0 ;i<ary.length; i++) {
            System.out.print(ary[i][4-i]);
        }
    }
}