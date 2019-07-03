interface I1 {
    float getRange(int low, int high);
}

interface I2 {
    float getAvg(int a, int b, int c);
}

abstract class C1 implements I1, I2 {
}

class C2 implements I1 {
    public float getRange(int x, int y) {
        return 3.14f;
    }
}

interface I3 extends I1 {
    float getAvg(int a, int b, int c, int d);
}