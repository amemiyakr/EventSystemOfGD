import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            ex();
        } catch(RuntimeException e) {
            System.out.println(e);
        }
    } 
    static void ex() {
        if(Math.random() > 0.5) 
            throw new IOException();
        throw new RuntimeException();
    }
}