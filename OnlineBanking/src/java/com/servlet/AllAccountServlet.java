
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class AllAccountServlet extends HttpServlet {
    
    Connection con = null;
    PreparedStatement ps = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
                try{
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=myData";
                    String userDB = "sa";
                    String passDB = "1234";
                    con = DriverManager.getConnection(url,userDB,passDB);
                    String Query = "select * from register";
                    ps = con.prepareStatement(Query);
                    ResultSet rs = ps.executeQuery();
                    String str = "<center><table border=1><tr><h1>All Accounts Details</h1></tr><tr><th>Account No.</th><th>User Name</th><th>Balance</th><th>Address</th><th>Email ID</th><th>Contact</th><th>Occupation</th><th>Opening Date</th><th>Gender</th></tr>";
                    while(rs.next()){
                        str += "<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td></tr>";
                    }
                    str += "</table></center>";
                    out.println(str);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                            out.println("<!DOCTYPE html>");
                            out.println("<html><body>");
                            out.println("<center><a href='allAccounts.jsp'>Click here to Home Page.</a></center>");
                            out.println("</form></body></html>");
                }
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        //processRequest(request, response);
                //Welcome ${UserSession}
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
