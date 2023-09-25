package seminars.third.tdd;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;
    boolean isAdmin;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        this.isAuthenticate = this.name.equals(name) && this.password.equals(password);
        return this.isAuthenticate;
    }


}