
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class AddAccountServlet extends HttpServlet {
    
    Connection con = null;
    PreparedStatement ps = null;

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
            
            String name = request.getParameter("username");
            String pass = request.getParameter("repassword");
            String amount = request.getParameter("amount");
            String address = request.getParameter("address");
            String mail = request.getParameter("mail");
            String phone = request.getParameter("phone");
            String occupation = request.getParameter("occupation");
            String tareeq = request.getParameter("tareeq");
            String gender = request.getParameter("gender");
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=myData";
                String userDB = "sa";
                String passDB = "1234";
                con = DriverManager.getConnection(url,userDB,passDB);            
                String Query = "insert into register (name, pass, balance, addr, email, contact, occupation, dat, gender) values(?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(Query);
                ps.setString(1,name);
                ps.setString(2,pass);
                ps.setString(3,amount);
                ps.setString(4,address);
                ps.setString(5,mail);
                ps.setString(6,phone);
                ps.setString(7,occupation);
                ps.setString(8,tareeq);
                ps.setString(9,gender);
                ps.executeUpdate();
                             
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("<center><h1>Successfully Registered</h1></center></br>");
            out.println("<center><a href='addAccount.jsp'>Click here to Registered One More User.</a></center></br>");
            out.println("<center><a href='allAccounts.jsp'>Click here to Home Page.</a></center>");
            out.println("</form></body></html>");
        } 
            catch(Exception ex){
                ex.printStackTrace();
            }
        //processRequest(request, response);
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
