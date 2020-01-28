package ftc.shift.sample.models;

import java.util.List;

public class User {

    private String personId;

    private String name;

    private String balance;

    private String avatar;

    private List<String> wellDoneQuestions;

    private List<String> failedQuestions;

    private List<String> userQuestion;

    public User() {
    }

    public User(String personId, String name, String balance, String avatar, List<String> wellDoneQuestions, List<String> failedQuestions, List<String> userQuestion) {
        this.personId = personId;
        this.name = name;
        this.balance = balance;
        this.avatar = avatar;
        this.failedQuestions = failedQuestions;
        this.wellDoneQuestions = wellDoneQuestions;
        this.userQuestion = userQuestion;
    }

    public String getPersonId() { return personId; }

    public void setPersonId(String personId) { this.personId = personId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    private String getBalance() { return balance; }

    private void getBalance(String balance) { this.balance = balance; }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public List<String> getFailedQuestions() { return getFailedQuestions(); }

    public void setFailedQuestions(List<String> failedQuestions) { this.failedQuestions = failedQuestions; }

    public List<String> getWellDoneQuestions() { return getWellDoneQuestions(); }

    public void setWellDoneQuestions(List<String> wellDoneQuestions) { this.wellDoneQuestions = wellDoneQuestions; }

    public List<String> getUserQuestion() { return getUserQuestion(); }

    public void setUserQuestion(List<String> userQuestion) { this.userQuestion = userQuestion; }
}


