package com.disilab.dao.impl;

import com.disilab.dao.interfaces.IAccountDAO;
import com.disilab.utils.ConnectionUtil;
import com.disilab.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAO implements IAccountDAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    ConnectionUtil dbc = new ConnectionUtil();
    Connection connection = null;

    public Account login(String email, String password) throws SQLException {
        String sql = "SELECT a.role_id, r.role_name, a.username, a.name , " +
                "a.email, a.phone, a.image, a.about, a.key, a.status " +
                "FROM account a inner join role r on a.role_id = r.id where a.email = ? AND a.password = ?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt("role_id"), rs.getString("role_name"));
                return new Account(role, rs.getString("username"),
                        rs.getString("name"), rs.getString("email"), rs.getInt("phone"),
                        rs.getString("image"), rs.getString("about"), rs.getString("key"), rs.getBoolean("status"));
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

    public Account loginGoogle(String email) throws SQLException {
        String sql = "SELECT a.role_id, r.role_name, a.username, a.name , " +
                "a.email, a.phone, a.image, a.about, a.key, a.status " +
                "FROM account a inner join role r on a.role_id = r.id where a.email = ?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt("role_id"), rs.getString("role_name"));
                return new Account(role, rs.getString("username"),
                        rs.getString("name"), rs.getString("email"), rs.getInt("phone"),
                        rs.getString("image"), rs.getString("about"), rs.getString("key"), rs.getBoolean("status"));
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

    public void register(Account account) throws SQLException {
        String sql = "INSERT INTO `forum`.`account` (`role_id`, `username`, `name`, `email`, `password`, `status`) VALUES ('1', ?, ?, ?, ?, '1')";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUserName());
            ps.setString(2, account.getDisplayName());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getPassword());
            ps.executeUpdate();
        }catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public Account checkEmail(String email) throws SQLException {
        String sql = "SELECT username FROM account where a.email = ?";
        try {
            connection =  dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUserName(rs.getString("username"));
                return account;
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
}
