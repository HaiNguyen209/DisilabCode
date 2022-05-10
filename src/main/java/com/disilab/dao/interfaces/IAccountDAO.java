package com.disilab.dao.interfaces;

import com.disilab.model.Account;

import java.sql.SQLException;

public interface IAccountDAO {
    Account login(String email, String password) throws SQLException;
    Account loginGoogle(String email) throws SQLException;
    void register(Account account) throws SQLException;
    Account checkEmail(String email) throws SQLException;
}
