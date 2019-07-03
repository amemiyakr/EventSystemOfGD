class LoopControl {
    public static void main(String[] args) {
        boolean flag1 = true;
        boolean flag2 = false;
        while(flag1) {
            flag1 = false;
            if(flag1 == flag2) {
                System.out.print("A");
                flag1 = true;
                flag2 = flag1;
                continue;
            }
            System.out.print("B");
            break;
        }
    }
}