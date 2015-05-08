package bean;

public class UserBean {
    UserBean() {

    }

    private String login;

    public UserBean(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
