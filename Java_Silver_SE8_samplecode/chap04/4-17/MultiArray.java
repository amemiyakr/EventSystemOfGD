class MultiArray {
    public static void main(String args[]) {
        int array2d[][] = new int[4][3];
        System.out.println("Load");
        for(int i = 0; i < array2d.length; i++) {
            for(int j = 0; j < array2d[i].length; j++) {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                // insert code here
            }
        }
        System.out.println("Modify");
        for(int i = 0; i < array2d.length; i++) {
            for(int j = 0; j < array2d[i].length; j++) {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                // insert code here
            }
        }
    }
}