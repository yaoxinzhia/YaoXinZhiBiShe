package cn.demo.domain;

/**
 * 用户类
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String emailadress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }

    public User(String username, String password, String emailadress) {
        this.username = username;
        this.password = password;
        this.emailadress = emailadress;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailadress='" + emailadress + '\'' +
                '}';
    }
}
