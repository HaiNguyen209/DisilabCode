package com.disilab.model;

public class Achievement {
    private Account account;
    private Medal medal;
    private int point;

    public Achievement() {
    }

    public Achievement(Account account, Medal medal, int point) {
        this.account = account;
        this.medal = medal;
        this.point = point;
    }

    public Account getUser() {
        return account;
    }

    public void setUser(Account account) {
        this.account = account;
    }

    public Medal getMedal() {
        return medal;
    }

    public void setMedal(Medal medal) {
        this.medal = medal;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
