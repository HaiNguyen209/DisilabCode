package com.disilab.controller;

import com.disilab.dao.impl.AccountDAO;
import com.disilab.dao.impl.CaptchaDAO;
import com.disilab.dao.interfaces.IAccountDAO;
import com.disilab.dao.interfaces.ICaptchaDAO;
import com.disilab.model.Account;
import com.disilab.utils.*;
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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RegisterController", value = "/dang-ky")
public class RegisterController extends HttpServlet {
    private ICaptchaDAO cdao = new CaptchaDAO();
    private IAccountDAO adao = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI() + "?" + request.getQueryString();
        try {
            if (action.contains("verification")) {
                verification(request, response);
            } else if (action.contains("insert")) {
                insert(request, response);
            } else {
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (SQLException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException |
                 BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            register(request, response);
        } catch (SQLException | IllegalBlockSizeException | NoSuchPaddingException | NoSuchAlgorithmException |
                 BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONArray list = new JSONArray();
        String msg = null;
        JSONObject obj = new JSONObject();
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Account checkEmail = adao.checkEmail(email);
        if (checkEmail == null) {
            String captcha = CaptchaUtil.getCaptcha(8);
            Account info = new Account(username, name, email, AesUtil.enCode(password));
            cdao.inserCaptcha(info, captcha);
            String encode = AesUtil.enCode("captcha=" + captcha);
            MailUtil.setContent(username, "http://localhost:8080/disilab/dang-ky?verification=" + encode, email);
            msg = "success";
            obj.put("msg", msg);
            list.add(obj);
            out.println(list.toJSONString());
            out.flush();
        } else {
            msg = "error";
            obj.put("msg", msg);
            list.add(obj);
            out.println(list.toJSONString());
            out.flush();
        }
    }

    protected void verification(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String verification = request.getParameter("verification");
        String decode = AesUtil.deCode(verification);
        request.getRequestDispatcher("dang-ky?insert=true&" + decode).forward(request, response);
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String captcha = request.getParameter("captcha");
        Account getInfor = cdao.getUserInfo(captcha);
        if (getInfor != null) {
            adao.register(getInfor);
            cdao.removeCaptcha(getInfor.getUserName());
            request.setAttribute("success", "Đăng ký thành công!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }
}
