package com.htgy.registform;

public class RegistForm {
    private String account;
    private String username;
    private String passFirst;
    private String passSecond;

    public String getAccount() {
        return account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassFirst() {
        return passFirst;
    }

    public void setPassFirst(String passFirst) {
        this.passFirst = passFirst;
    }

    public String getPassSecond() {
        return passSecond;
    }

    public void setPassSecond(String passSecond) {
        this.passSecond = passSecond;
    }
}
