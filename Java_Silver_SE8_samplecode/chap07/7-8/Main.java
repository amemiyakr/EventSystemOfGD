class Super {
    public void out() {
        System.out.println("Super");
    }
}

class Sub extends Super {
    public void out() {
        System.out.println("Sub");
    }
}

class Main {
    public static void main(String args[]) {
        function(new Sub());
    }
    static void function(Super s) {
        s.out();
    }
}