
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DGN Bank</title>
        <SCRIPT LANGUAGE="JavaScript">
function valid(form)
{
   for(var i=0; i<form.elements.length; i++)
   {
		if(form.elements[i].value == "")
		{
		   alert("Fill out all Fields");
		   form.elements[i].focus();
		   return false;
		}
   }
   if(document.F1.newPassword.value !== document.F1.rePassword.value)
    {
	   alert("Check Confirm Password"); 
	   document.F1.rePassword.value="";
	   document.F1.rePassword.focus();	
	   return false;
    }
         return true;   
}
</SCRIPT>

<script type="text/javascript">
function ctck(){
var sds = document.getElementById("dum");
}
</script>
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
    	<div id="formArea" style="border-right:#666666 1px dotted;"><h1>CHANGE PASSWORD</h1><br>
    	    <table  align="center" bgcolor="white">
		<tr>
			<td>
				<form name=F1 onSubmit="return valid(this)" action="ChangePassServlet" method="post">
				    <table cellspacing="5" cellpadding="3">
					<tr><td>OLD PASSWORD:</td><td> <input type="password" name="oldPassword" style="width:250px; height:25px;"/></td></tr>
                                        <tr><td>NEW PASSWORD:</td><td> <input type="password" name="newPassword" style="width:250px; height:25px;"/></td></tr>
                                        <tr><td>CONFIRM NEW PASSWORD:</td><td> <input type="password" name="rePassword" style="width:250px; height:25px;"/></td></tr>
                                        <tr></tr><tr></tr>
					<tr><td></td><td><input type="submit" value="Submit" style="width:70px; height:25px;"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<INPUT TYPE=RESET VALUE="CLEAR" style="width:70px; height:25px;"/></td></tr>
					</table>
		    		</form>
                                </td>
        </td>
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
