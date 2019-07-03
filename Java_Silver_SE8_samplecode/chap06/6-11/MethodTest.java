class MethodTest {
    static void methodOne() {
        methodTwo();
        MethodTest.methodTwo();
        methodThree();
        MethodTest.methodFour();
    }

    static void methodTwo() {
    }

    void methodThree() {
        methodOne();
        MethodTest.methodTwo();
        methodFour();
        MethodTest.methodFour();
    }

    void methodFour() {
    }
}