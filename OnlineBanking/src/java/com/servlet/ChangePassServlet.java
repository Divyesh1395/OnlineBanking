
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class ChangePassServlet extends HttpServlet {

    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    
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
        
            String oldPass = request.getParameter("oldPassword");
            String newPass = request.getParameter("newPassword");
            String rePass = request.getParameter("rePassword");
            HttpSession session = request.getSession();
            
            String id = (session.getAttribute("CustomerSession")).toString();
            
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=myData";
                String userDB = "sa";
                String passDB = "1234";
                con = DriverManager.getConnection(url,userDB,passDB);             
                String Query1 = "select * from register where name=? and pass=?";
                ps = con.prepareStatement(Query1);
                ps.setString(1,id);
                ps.setString(2,oldPass);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                        String Query2 = "update register set pass=? where name=?";
                        ps = con.prepareStatement(Query2);
                        ps.setString(1,rePass);
                        ps.setString(2,id);
                        ps.executeUpdate();
                          out.println("<!DOCTYPE html>");
                          out.println("<html><body>");
                          out.println("<center><h1>Password Successfully Changed</h1></center></br>");
                          out.println("<center><a href='balance.jsp'>Click here to Balance Page.</a></center>");
                          out.println("</form></body></html>");                  
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        processRequest(request, response);        
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
