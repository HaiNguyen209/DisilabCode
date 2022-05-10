package com.disilab.controller.home;

import com.disilab.dao.impl.QuestionDAO;
import com.disilab.dao.interfaces.IQuestionDAO;
import com.disilab.model.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AskController", value = "/hoi-dap")
public class AskController extends HttpServlet {
    private HttpSession session;
    private PrintWriter out;
    private JSONArray list = new JSONArray();
    private JSONObject obj = new JSONObject();
    private String msg;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("ask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ask(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void ask(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String subject = request.getParameter("subject");
        String detail = request.getParameter("detail");
        String grade = request.getParameter("grade");
        Question question = new Question(grade, subject, title, detail);
        IQuestionDAO qdao = new QuestionDAO();
        out = response.getWriter();
        qdao.insertQuestion(question);
        msg = "success";
        obj.put("msg", msg);
        list.add(obj);
        out.println(list.toJSONString());
        out.flush();
    }
}
