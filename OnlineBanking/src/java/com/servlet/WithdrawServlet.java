
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WithdrawServlet extends HttpServlet {
    
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
            String amount = request.getParameter("amount");
            
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=myData";
                String userDB = "sa";
                String passDB = "1234";
                con = DriverManager.getConnection(url,userDB,passDB); 
                String Query1 = "select accountID from register where accountID=?";
                ps = con.prepareStatement(Query1);
                ps.setString(1,accountID);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int id = Integer.parseInt(accountID);
                    st = con.createStatement();
                    ResultSet rs1 = st.executeQuery("select balance from register where accountID="+ id);
                    if(rs1.next() == true){
                    int balance = Integer.parseInt(rs1.getString(1));
                    
                    if(balance >= Integer.parseInt(amount)){
                        int newBalance = balance - (Integer.parseInt(amount));
                        String dat = sdf.format(new Date());
                        String Query3 = "insert into trans (dat, accountID, debit, balance) values(?,?,?,?)";
                        ps = con.prepareStatement(Query3);
                        ps.setString(1,dat);
                        ps.setString(2,accountID);
                        ps.setString(3,amount);
                        ps.setInt(4,newBalance);
                        ps.executeUpdate();
                        
                        String Query4 = "update register set balance=? where accountID=?";
                        ps = con.prepareStatement(Query4);
                        ps.setInt(1,newBalance);
                        ps.setString(2,accountID);
                        ps.executeUpdate();
                        
                            out.println("<!DOCTYPE html>");
                            out.println("<html><body>");
                            out.println("<center><h1>Amount Successfully Withdraw</h1></center></br>");
                            out.println("<center><a href='withdraw.jsp'>Click here to One More Transaction.</a></center></br>");
                            out.println("<center><a href='allAccounts.jsp'>Click here to Home Page.</a></center>");
                            out.println("</form></body></html>");
                    }
                    }
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
