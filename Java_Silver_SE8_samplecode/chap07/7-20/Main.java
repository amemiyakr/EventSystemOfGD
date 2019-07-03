class Bird {
    Colibri c;
    void setInstance(Colibri c) {
        this.c = c;
    }
    void twitter() {
        System.out.println(c);
    }
}

class Colibri extends Bird {
    public String toString() {
        return "Humming";
    }
}

class Main {
    public static void main(String[] args) {
        Colibri colibri = new Colibri();
        Bird bird = (Bird)colibri;
        bird.setInstance(colibri);
        bird.twitter();
    }
}