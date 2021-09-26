
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
		if(form.elements[i].value === "")
		{
		   alert("Fill out all Fields");
		   form.elements[i].focus();
		   return false;
		}
   }
   if(!isNaN(document.F1.accountno.value))
   {
       if((999999999 > document.F1.accountno.value) || (document.F1.accountno.value > 9999999999))
	   {
                alert("Enter Valid 10 digits Account number");
                document.F1.accountno.value="";
                document.F1.accountno.focus();
                return false;
           }
   }
   else
   {
        alert("Account Number  must  be  number");
        document.F1.accountno.value="";
        document.F1.accountno.focus();
	return false;
   }
   if(!isNaN(document.F1.username.value))
   {
       if((9999 > document.F1.username.value) || (document.F1.username.value > 99999))
	   {
		 alert("Enter Valid five digit User ID");
		 document.F1.username.value="";
		 document.F1.username.focus();
                 return false;   
	   }
   }
   else
   {
        alert("User ID  must  be  number");
        document.F1.username.value="";
        document.F1.username.focus();
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

<table style="width:995px; height:auto; background:#FFFFFF; margin:0 auto;">
<tr >
	<td width="250" valign="top" style="border-right:#666666 1px dotted;">
    	<div id="services"><h1>Services</h1>
		<p style="margin-top:35px; ">"We provide best services to the users of this website in which the user can easily make any number of transactions
                    across India."</p> 	
       </div>
	</td>
    
    <td width="1200" valign="top">
    	<div id="formArea" style="border-right:#666666 1px dotted;"><h1>CLOSE ACCOUNT FORM</h1><br>
    	    <table  align="center" bgcolor="white">
		<tr>
			<td>
			<form name=F1 onSubmit="return valid(this)" action="CloseAccountServlet" method="post">
				     <table cellspacing="5" cellpadding="3">
				        <tr><td>ACCOUNT NO:</td><td> <input type="text" name="accountno" style="width:250px; height:25px;"/></td></tr>
					<tr><td>USER ID:</td><td> <input type="text" name="username" style="width:250px; height:25px;"/></td></tr>
					<tr><td>PASSWORD:</td><td> <input type="password" name="password" style="width:250px; height:25px;"/></td></tr>
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
