package com.disilab.dao.interfaces;

import com.disilab.model.Question;

import java.sql.SQLException;
import java.util.List;

public interface IQuestionDAO {
    void insertQuestion(Question question) throws SQLException;
}
