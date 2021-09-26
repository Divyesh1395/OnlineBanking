
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CloseAccountServlet extends HttpServlet {
    
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
        
            String accountID = request.getParameter("accountno");
            String userID = request.getParameter("username");
            String pass = request.getParameter("password");
            HttpSession session = request.getSession();
            
            String id = (session.getAttribute("UserSession")).toString();
            if(id.equals(userID)){
              try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=myData";
                String userDB = "sa";
                String passDB = "1234";
                con = DriverManager.getConnection(url,userDB,passDB); 
                
                int accID = Integer.parseInt(accountID);
                st = con.createStatement();
                ResultSet rs1 = st.executeQuery("select accountID from register where accountID="+ accID);
                if(rs1.next() == true){
                    int accNo = Integer.parseInt(rs1.getString(1));
                    st = con.createStatement();
                    ResultSet rs2 = st.executeQuery("select balance from register where accountID="+ accID);
                        if(rs2.next() == true){
                            int balance = Integer.parseInt(rs2.getString(1));
                                if(balance == 0){
                                       String dat = sdf.format(new Date());
                                       String Query3 = "insert into closeAC (dat, accountID, managerID) values(?,?,?)";
                                       ps = con.prepareStatement(Query3);
                                       ps.setString(1,dat);
                                       ps.setString(2,accountID);
                                       ps.setString(3,userID);
                                       ps.executeUpdate();

                                       String Query4 = "delete from register where accountID = ?";
                                       ps = con.prepareStatement(Query4);
                                       ps.setString(1,accountID);
                                       ps.executeUpdate();

                                    out.println("<!DOCTYPE html>");
                                    out.println("<html><body>");
                                    out.println("<center><h1>Account Successfully Closed</h1></center></br>");
                                    out.println("<center><a href='closeAC.jsp'>Click here to Close One More User.</a></center></br>");
                                    out.println("<center><a href='allAccounts.jsp'>Click here to Home Page.</a></center>");
                                    out.println("</form></body></html>");
                    }
                        }
                }
                
             //response.sendRedirect("addAccount.jsp");
        }  
            catch(Exception ex){
                ex.printStackTrace();
            }
            }
    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
