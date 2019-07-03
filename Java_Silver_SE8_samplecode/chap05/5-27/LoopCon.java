class LoopCon {
    public static void main(String[] args) {
        for(int i=0;;i++) {
            if(i%2 == 0) {
                continue;
            }
            if(i%3 == 0) {
                break;
            }
            System.out.print(i);
        }
    }
}