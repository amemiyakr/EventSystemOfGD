class MultiArray {
    public static void main(String[] args) {
        int[] x[] = {{1, 2, 3, 4}, {5, 6, 7}, {8, 9, 10, 11}};
        int[][] y = x;
        System.out.println(y[2][1] + x[1][2]);
    }
}