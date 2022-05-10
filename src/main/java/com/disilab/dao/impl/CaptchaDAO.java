package com.disilab.dao.impl;

import com.disilab.dao.interfaces.ICaptchaDAO;
import com.disilab.model.Account;
import com.disilab.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CaptchaDAO implements ICaptchaDAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    ConnectionUtil dbc = new ConnectionUtil();
    Connection connection = null;
    @Override
    public void inserCaptcha(Account account, String captcha) throws SQLException {
        String sql = "INSERT INTO `verification` (`username`, `name`, `email`, `password`, `captcha`, `lifetime`) VALUES (?, ?, ?, ?, ?, UNIX_TIMESTAMP(now() + INTERVAL 180 SECOND))";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUserName());
            ps.setString(2, account.getDisplayName());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getPassword());
            ps.setString(5, captcha);
            ps.executeUpdate();
        }catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void setRecover(String username, String captcha) throws SQLException {
        String sql = "INSERT INTO `verification` (`username`, `captcha`, `lifetime`) VALUES (?, ?, UNIX_TIMESTAMP(now() + INTERVAL 180 SECOND))";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, captcha);
            ps.executeUpdate();
        }catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Account getUserInfo(String captcha) throws SQLException {
        String sql = "select username, name, email, password from verification where captcha = ?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, captcha);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getString("username"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    @Override
    public void removeCaptcha(String username) throws SQLException {
        String sql = "DELETE FROM `verification` WHERE (`username` = ?)";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
