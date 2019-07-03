class Main {
    static int boxes[] = {10, 10, 10, 10, 1};
    static int boxes2[];
    
    public static void main(String args[]) {
        boxes2 = Main.set(2, 20);
        for(int i : boxes) {
            System.out.print(i);
        }
        for(int i : boxes2) {
            System.out.print(i);
        }
    }
    
    static int[] set(int index, int box) {
        for(int i = 0; i < index; i++) {
            boxes[index] = box;
        }
        return boxes;
    }
}