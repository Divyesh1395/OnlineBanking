
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class AllTransactions extends HttpServlet {
    
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
                HttpSession session = request.getSession();
                String id = (session.getAttribute("CustomerSession")).toString();
            
                try{
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=myData";
                    String userDB = "sa";
                    String passDB = "1234";
                    con = DriverManager.getConnection(url,userDB,passDB);
                    //out.println(id);
                    //st = con.createStatement();
                    //ResultSet rs1 = st.executeQuery("select accountID from register where name="+ id);
                    //if(rs1.next() == true){
                        //int accID = Integer.parseInt(rs1.getString(1));
                    //out.println(accID);
                        String Query = "select * from trans";
                        ps = con.prepareStatement(Query);
                        //ps.setInt(1,accID);
                        ResultSet rs = ps.executeQuery();
                        String str = "<center><table border=1><tr><h1>All Transaction Details</h1></tr><tr><th>Date</th><th>Account No.</th><th>Target No.</th><th>Debit</th><th>Credit</th><th>Balance</th></tr>";
                        while(rs.next()){
                            str += "<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>";
                        }
                        str += "</table></center>";
                        out.println(str);
                
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                            out.println("<!DOCTYPE html>");
                            out.println("<html><body>");
                            out.println("<center><a href='balance.jsp'>Click here to Home Page.</a></center>");
                            out.println("</form></body></html>");
                }
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
