package com.disilab.dao.impl;

import com.disilab.dao.interfaces.IQuestionDAO;
import com.disilab.model.Question;
import com.disilab.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionDAO implements IQuestionDAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    ConnectionUtil dbc = new ConnectionUtil();
    Connection connection = null;

    @Override
    public void insertQuestion(Question question) throws SQLException {
        String insertQuestion = "INSERT INTO `forum`.`question` (`username`, `grade`, `subject`, `title`, `details`, `date`) VALUES (?, ?, ?, ?, ?, NOW())";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(insertQuestion);
            ps.setString(1, "hung123");
            ps.setString(2, question.getGrade());
            ps.setString(3, question.getSubject());
            ps.setString(4, question.getTitle());
            ps.setString(5, question.getDetail());
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
