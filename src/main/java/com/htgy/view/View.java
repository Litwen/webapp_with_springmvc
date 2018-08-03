package com.htgy.view;


import org.springframework.stereotype.Component;


public class View {
    private String loginSucess;
    private String registSuccess;
    private String registFail;
    private String loginFail;
    private String login;
    private String regist;

    public String getLoginSucess() {
        return loginSucess;
    }

    public void setLoginSucess(String loginSucess) {
        this.loginSucess = loginSucess;
    }

    public String getRegistSuccess() {
        return registSuccess;
    }

    public void setRegistSuccess(String registSuccess) {
        this.registSuccess = registSuccess;
    }

    public String getRegistFail() {
        return registFail;
    }

    public void setRegistFail(String registFail) {
        this.registFail = registFail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRegist() {
        return regist;
    }

    public void setRegist(String regist) {
        this.regist = regist;
    }

    public String getLoginFail() {
        return loginFail;
    }

    public void setLoginFail(String loginfail) {
        this.loginFail = loginfail;
    }
}
