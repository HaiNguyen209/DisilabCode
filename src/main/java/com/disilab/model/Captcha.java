package com.disilab.model;

public class Captcha {
    private String captcha;
    private Account account;

    public Captcha() {
    }

    public Captcha(String captcha, Account account) {
        this.captcha = captcha;
        this.account = account;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
