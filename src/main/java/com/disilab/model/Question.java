package com.disilab.model;

import java.sql.Timestamp;

public class Question {
    private int question_id;
    private Account account;
    private String grade;
    private String subject;
    private String title;
    private String detail;
    private Timestamp date;

    public Question() {

    }

    public Question(int question_id, Account account, String grade, String subject, String title, String detail, Timestamp date) {
        this.question_id = question_id;
        this.account = account;
        this.grade = grade;
        this.subject = subject;
        this.title = title;
        this.detail = detail;
        this.date = date;
    }

    public Question(String grade, String subject, String title, String detail) {
        this.grade = grade;
        this.subject = subject;
        this.title = title;
        this.detail = detail;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
