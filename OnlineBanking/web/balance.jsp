
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

<table style="width:995px; height:auto; background:#FFFFFF; margin:0 auto;">
<tr >
	<td width="250" valign="top" style="border-right:#666666 1px dotted;">
    	<div id="services"><h1>Services</h1>
		<p style="margin-top:35px; ">"We provide best services to the users of this website in which the user can easily make any number of transactions
                    across India."</p> 	
       </div>
	</td>
    
    <td width="1200" valign="top">
        <div id="formArea" style="border-right:#666666 1px dotted; background:#ffffff;font-size:20px;"><center><h1>BALANCE</h1></center><br>
            <center><span>Welcome &nbsp;&nbsp; ${CustomerSession}</span></center><br>
            <table cellspacing="5" cellpadding="5" border="0px solid" align="center">	
                <tr>
                    <td>Account Number </td><td>: 1023452343</td>	
		</tr>
                <tr>
                    <td>Balance </td><td>: 3245</td>	
		</tr>
                <tr>
                    <td>Mobile Number </td><td>: 8847364823</td>	
		</tr>
	</table>
    	   </div>      
    </td>
    
   <td width="250" valign="top">
    	<div id="welcome" style="border-right:#666666 1px dotted;"><h1>Welcome</h1><br>
    	    <center><img src="images/welcome.gif" alt="business" width="196" height="106"></center><br>
		    <p>"We provide best services to the users of this website in which the user can easily make any number of transactions
                    across India."</p>	    	
	    </div>      
    </td>
        </tr>
</table>
    
<script type="text/javascript">
document.onload = ctck();
</script>
<div id="footer">
  <div id="footer_navigation">
  
  </div>  
</div>
</div>
        
    </body>
</html>
