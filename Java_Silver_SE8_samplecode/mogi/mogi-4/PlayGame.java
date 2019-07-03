public class PlayGame {
    public static void main(String[] args) {
        Player p = new Player();
        p.start();
    }
}
class Player {
    public void start() {
        try {
            FunGame fg = new FunGame();
            fg.play();
        } catch(OriginalException te) {
            throw new RuntimeException(te);
        }
    }
}
class FunGame {
    public void play() throws OriginalException {
        // OriginalExceptionó·äOÇ™î≠ê∂
    }
}
class OriginalException extends Exception {
}