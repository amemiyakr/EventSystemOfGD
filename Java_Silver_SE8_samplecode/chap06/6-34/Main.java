class Result {
    private int num;
    public void setNum(int num) {
        this.num = num;
    }
    public int getNum() {
        return num;
    }
}

public class Main {
    public static void main(String[] args) {
        Result result = new Result();
        int num = 10;
        result.setNum(num);
        // insert code here
        System.out.println(result.getNum());
    }
}