class User {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

public class Test {
    static void changeUser(User user) {
        // insert code here
    }
    public static void main(String[] args) {
        User user = new User();
        user.setName("Java");
        changeUser(user);
        System.out.println("user is " + user.toString());
    }
}
