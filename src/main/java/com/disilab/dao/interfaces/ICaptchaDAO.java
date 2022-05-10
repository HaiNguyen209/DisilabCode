package com.disilab.dao.interfaces;

import com.disilab.model.Account;

import java.sql.SQLException;

public interface ICaptchaDAO {

    void inserCaptcha(Account account, String captcha) throws SQLException;

    Account getUserInfo(String captcha) throws SQLException;

    void removeCaptcha(String username) throws  SQLException;
    void setRecover(String email, String captcha) throws SQLException;
}
