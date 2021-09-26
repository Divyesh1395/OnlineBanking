
package com.servlet;

import com.login.dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class AdminLoginServlet extends HttpServlet {
    
    LoginDao dao = new LoginDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String userName = request.getParameter("username");
            String pass = request.getParameter("password");
            String Query = "select * from adminLogin where id=? and pass=?";
                    if(dao.check(userName, pass, Query)){
                        HttpSession session = request.getSession();
                        session.setAttribute("UserSession", userName);
                        response.sendRedirect("allAccounts.jsp");
                    }
                    else{                            
                        response.sendRedirect("adminLogin.jsp");
                    }
        //processRequest(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
