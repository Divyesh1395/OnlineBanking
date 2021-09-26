
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DGN Bank</title>
        <link href="style.css" rel="stylesheet" type="text/css">
        
    </head>
    <body>
        <%
           response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
           response.setHeader("Pragma", "no-cache");
           response.setHeader("Expires", "0");
           if(session.getAttribute("UserSession") == null){
               response.sendRedirect("adminLogin.jsp");
           } 
            %>
            <div id="top_links">
<div id="header">
	<h1>DNG - BANK</h1>
    <h2>ExtraOrdinary Service</h2>
</div>

<div id="navigation">
    <ul>
    <li style="width:158px;"><form name=F1 action="AllAccountServlet" method="get"><input type="submit" value="All Accounts" style="width:157px; height:40px; background:transparent; border:0px; font:bold 17px/42px Arial, Helvetica, sans-serif; color:#adadad; cursor:pointer;"/></form></li>    
    <li style="width:208px;"><a href="addAccount.jsp">OPEN &nbsp; NEW &nbsp; ACCOUNT</a></li>
    <li style="width:168px;"><a href="closeAC.jsp">CLOSE &nbsp; ACCOUNT</a></li>
    <li style="width:168px;"><a href="deposit.jsp">DEPOSIT &nbsp; MONEY</a></li>    
    <li style="width:185px;"><a href="withdraw.jsp">WITHDRAW &nbsp; MONEY</a></li>
    <li style="width:104px;"><form action="Logout" method="get"><input type="submit" value="Logout" style="width:104px; height:40px; background:transparent; border:0px; font:bold 17px/42px Arial, Helvetica, sans-serif; color:#adadad; cursor:pointer;"/></form></li>
    </ul>
</div>
           <div style="width:995px; height:400px; background:#FFFFFF; margin:0 auto;">    
                   
           </div>
<div id="footer">
  <div id="footer_navigation">
  
  </div>  
</div>
</div>            
    </body>
</html>
