
package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    
    Connection con = null;
    PreparedStatement ps = null;
    
    public boolean check(String name, String pass, String query){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=myData";
            String userDB = "sa";
            String passDB = "1234";
            con = DriverManager.getConnection(url,userDB,passDB);
            ps = con.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
}
