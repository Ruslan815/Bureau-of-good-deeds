package ftc.shift.sample.models;

public class User {

    private String id;
    private String login;
    private String password;
    private String registrationDate;
    private String name;
    private int balance;
    private String avatar;

    public User() {
    }

    public User(String id, String login, String password, String registrationDate, String name, int balance, String avatar) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.registrationDate = registrationDate;
        this.name = name;
        this.balance = balance;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}


