package com.internet.test.authentication.model;

public class AuthenticationTestData {
    private String username;
    private String password;
    private String login;

    public String getLogin() {
        return login;
    }

    public AuthenticationTestData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthenticationTestData() {
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
