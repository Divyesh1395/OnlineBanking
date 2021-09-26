
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

public class TransferServlet extends HttpServlet {

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
            String password = request.getParameter("password");
            String targetAcc = request.getParameter("targetAcc");
            String amount = request.getParameter("amount");
            
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=myData";
                String userDB = "sa";
                String passDB = "1234";
                con = DriverManager.getConnection(url,userDB,passDB);
                
                String Query1 = "select * from register where accountID=? and pass=?";
                ps = con.prepareStatement(Query1);
                ps.setString(1,accountID);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    st = con.createStatement();
                    ResultSet rs1 = st.executeQuery("select balance from register where accountID="+ accountID);
                    if(rs1.next() == true){
                    int balance = Integer.parseInt(rs1.getString(1));
                    int amo = Integer.parseInt(amount);
                    if(balance >= amo){
                        int newDebitBalance = balance - amo;
                        st = con.createStatement();
                        ResultSet rs3 = st.executeQuery("select balance from register where accountID="+ targetAcc);
                        if(rs3.next() == true){
                        int creditBalance = Integer.parseInt(rs3.getString(1));
                        int newcreditBalance = creditBalance + amo;
                        
                            String dat = sdf.format(new Date());
                            String Query4 = "insert into trans (dat, accountID, targetID, debit, balance) values(?,?,?,?,?)";
                            ps = con.prepareStatement(Query4);
                            ps.setString(1,dat);
                            ps.setString(2,accountID);
                            ps.setString(3,targetAcc);
                            ps.setString(4,amount);
                            ps.setInt(5,newDebitBalance);
                            ps.executeUpdate();
                            
                            String Query8 = "insert into trans (dat, accountID, targetID, credit, balance) values(?,?,?,?,?)";
                            ps = con.prepareStatement(Query8);
                            ps.setString(1,dat);
                            ps.setString(2,targetAcc);
                            ps.setString(3,accountID);
                            ps.setString(4,amount);
                            ps.setInt(5,newcreditBalance);
                            ps.executeUpdate();
                            
                            String Query5 = "update register set balance=? where accountID=?";
                            ps = con.prepareStatement(Query5);
                            ps.setInt(1,newcreditBalance);
                            ps.setString(2,targetAcc);
                            ps.executeUpdate();
                            
                            String Query9 = "update register set balance=? where accountID=?";
                            ps = con.prepareStatement(Query9);
                            ps.setInt(1,newDebitBalance);
                            ps.setString(2,accountID);
                            ps.executeUpdate();
                                                      
                            out.println("<!DOCTYPE html>");
                            out.println("<html><body>");
                            out.println("<center><h1>Amount Successfully Transfered</h1></center></br>");
                            out.println("<center><a href='transfer.jsp'>Click here to make One More Transaction.</a></center></br>");
                            out.println("<center><a href='balance.jsp'>Click here to Balance Page.</a></center>");
                            out.println("</form></body></html>");
                        }
                        }
                    }
                }
        }
                catch(Exception ex){
                     ex.printStackTrace();
                 }
        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
