class Ex {
    void exec() {
        (new RunEx()).exec();
    }
}
class RunEx {
    void exec() {
        throw new RuntimeException();
    }
}
class Main {
    public static void main(String[] args) throws RuntimeException {
        try {
            (new Ex()).exec();
        } catch(RuntimeException r) {
        }
    }
}