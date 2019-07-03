class MultiArray {
    public static void main(String args[]) {
        int[][] array = {{0, 1, 2}, {3, 4, 5, 6}};
        System.out.print(array.length + "");
        System.out.print(array[0].getClass().isArray() + "");
        System.out.println(array[1][1]);
    }
}