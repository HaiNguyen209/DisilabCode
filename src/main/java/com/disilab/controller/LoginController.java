package com.disilab.controller;

import com.disilab.dao.impl.AccountDAO;
import com.disilab.dao.interfaces.IAccountDAO;
import com.disilab.model.Account;
import com.disilab.utils.AesUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(name = "LoginController", value = "/dang-nhap")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = request.getRequestURI() + "?" + request.getQueryString();
        if (url.contains("google")) {
            loginGoogle(request, response);
        } else {
            login(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        IAccountDAO ldao = new AccountDAO();
        Account account;
        JSONArray list = new JSONArray();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String msg;
        JSONObject obj = new JSONObject();
        try {
            account = ldao.login(email, AesUtil.enCode(password));
            if (account != null) {
                if (account.isStatus()) {
                    session.setAttribute("user", account);
                    msg = "success";
                } else {
                    msg = "status";
                }
            } else {
                msg = "error";
            }
            obj.put("msg", msg);
            list.add(obj);
            out.println(list.toJSONString());
            out.flush();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private void loginGoogle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        IAccountDAO ldao = new AccountDAO();
        Account account;
        JSONArray list = new JSONArray();
        String email = request.getParameter("email");
        String token = request.getParameter("token");
        String msg;
        JSONObject obj = new JSONObject();
        try {
            account = ldao.loginGoogle(email);
            if (account != null && token != null) {
                if (account.isStatus()) {
                    session.setAttribute("user", account);
                    msg = "success";
                } else {
                    msg = "status";
                }
            } else {
                msg = "error";
            }
            obj.put("msg", msg);
            list.add(obj);
            out.println(list.toJSONString());
            out.flush();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
