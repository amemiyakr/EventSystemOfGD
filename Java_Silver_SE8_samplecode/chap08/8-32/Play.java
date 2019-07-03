class OriginalException extends Exception { }
class FunGame {
    public String setPlayer(String name) throws OriginalException {
        if(name == null) 
            throw new OriginalException();
        return "Hello " + name;
    }
}
public class Play {
    public static void main(String[] args) {
        new FunGame().setPlayer("Mike");
    }
}