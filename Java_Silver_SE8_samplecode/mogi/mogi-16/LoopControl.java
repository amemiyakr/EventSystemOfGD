class LoopControl {
    public static void main(String[] args) {
        int[][] ary = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        label:
        for(int i = 0;; i++) {
            for(int j = 0;; j++) {
                if(i == j) {
                    continue label;
                }
                System.out.print(ary[i][j]);
                if(i == 2) {
                    break label;
                }
            }
        }
    }
}