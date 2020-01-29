package ftc.shift.sample.models;

public class User {

    private String personId;

    private String login;

    private String password;

    private String registrationDate;

    private String name;

    private Integer balance;

    private String avatar;

    public User() {
    }

    public User(String personId, String login, String password, String name, Integer balance, String avatar, String registrationDate) {
        this.personId = personId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.balance = balance;
        this.avatar = avatar;
        this.registrationDate = registrationDate;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}


