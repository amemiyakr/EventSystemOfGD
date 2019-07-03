class LoopControl {
    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            switch(i) {
                case 0:
                    System.out.print(0);
                    continue;
                case 1:
                    System.out.print(1);
                    break;
                default:
                    System.out.print(2);
            }
        }
    }
}