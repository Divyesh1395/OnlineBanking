
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
           HttpSession session1 = request.getSession();
           if(session1.getAttribute("CustomerSession") == null){
               response.sendRedirect("customerLogin.jsp");
           } 
            %>
        <div id="top_links">
<div id="header">
	<h1>DNG - BANK</h1>
    <h2>ExtraOrdinary Service</h2>
</div>

<div id="navigation">
    <ul>
    <li style="width:150px;"><a href="balance.jsp">BALANCE</a></li>
    <li style="width:250px;"><form name="f1" action="AllTransactions" method="get"><input type="submit" value="TRANSACTION HISTORY" style="width:250px; height:40px; background:transparent; border:0px; font:bold 15px/38px Arial, Helvetica, sans-serif; color:#adadad; cursor:pointer;"/></form></li>
    <li style="width:220px;"><a href="transfer.jsp">TRANSFER &nbsp; AMOUNT</a></li>
    <li style="width:220px;"><a href="changePass.jsp">CHANGE &nbsp; PASSWORD</a></li>
    <li style="width:150px;"><form action="CustomerLogout" method="get"><input type="submit" value="Logout" style="width:150px; height:40px; background:transparent; border:0px; font:bold 17px/42px Arial, Helvetica, sans-serif; color:#adadad; cursor:pointer;"/></form></li>
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
