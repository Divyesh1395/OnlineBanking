package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>DGN Bank</title>\n");
      out.write("    <SCRIPT LANGUAGE=\"JavaScript\">\n");
      out.write("function valid(form)\n");
      out.write("{\n");
      out.write("   for(var i=0; i<form.elements.length; i++)\n");
      out.write("   {\n");
      out.write("\t\tif(form.elements[i].value === \"\")\n");
      out.write("\t\t{\n");
      out.write("\t\t   alert(\"Fill out all Fields\");\n");
      out.write("\t\t   form.elements[i].focus();\n");
      out.write("\t\t   return false;\n");
      out.write("\t\t}\n");
      out.write("   }\n");
      out.write("   if(!isNaN(document.F1.username.value))\n");
      out.write("   {\n");
      out.write("\t   if((9999 > document.F1.username.value) || (document.F1.username.value > 99999))\n");
      out.write("\t   {\n");
      out.write("\t\t alert(\"Enter Valid five digit User ID\");\n");
      out.write("\t\t document.F1.username.value=\"\";\n");
      out.write("\t\t document.F1.username.focus();\n");
      out.write("                 return false;   \n");
      out.write("\t   }\n");
      out.write("   }\n");
      out.write("   else\n");
      out.write("   {\n");
      out.write("        alert(\"User ID  must  be  number\");\n");
      out.write("        document.F1.username.value=\"\";\n");
      out.write("        document.F1.username.focus();\n");
      out.write("\treturn false;\n");
      out.write("   }\n");
      out.write("   return true;   \n");
      out.write("}\n");
      out.write("</SCRIPT>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function ctck(){\n");
      out.write("var sds = document.getElementById(\"dum\");\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("        \n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"top_links\">\n");
      out.write("<div id=\"header\">\n");
      out.write("\t<h1>DNG - BANK</h1>\n");
      out.write("    <h2>ExtraOrdinary Service</h2>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"navigation\">\n");
      out.write("    <ul>\n");
      out.write("    <li style=\"width:150px; float:right; border-left:1px solid #282828;\"><a href=\"indexAdmin.html\">HOME</a></li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("        <table style=\"width:995px; height:auto; background:#FFFFFF; margin:0 auto;\">\n");
      out.write("<tr >\n");
      out.write("\t<td width=\"250\" valign=\"top\" style=\"border-right:#666666 1px dotted;\">\n");
      out.write("    \t<div id=\"services\"><h1>Services</h1>\n");
      out.write("\t\t<p style=\"margin-top:35px; \">\"We provide best services to the users of this website in which the user can easily make any number of transactions\n");
      out.write("                    across India.\"</p> \t\n");
      out.write("       </div>\n");
      out.write("\t</td>\n");
      out.write("    \n");
      out.write("    <td width=\"1200\" valign=\"top\">\n");
      out.write("    \t<div id=\"formArea\" style=\"border-right:#666666 1px dotted;\"><h1>LOGIN AS A MANAGER</h1><br>\n");
      out.write("    \t    <table  align=\"center\" bgcolor=\"white\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t<form name=F1 onSubmit=\"return valid(this)\" action=\"AdminLoginServlet\" method=\"post\">\n");
      out.write("\t\t\t\t    <table cellspacing=\"5\" cellpadding=\"3\">\n");
      out.write("\t\t\t\t\t<tr><td>USER ID:</td><td> <input type=\"text\" name=\"username\" style=\"width:250px; height:25px;\"/></td></tr>\n");
      out.write("\t\t\t\t\t<tr><td>PASSWORD:</td><td> <input type=\"password\" name=\"password\" style=\"width:250px; height:25px;\"/></td></tr>\n");
      out.write("\t\t\t\t\t<tr></tr><tr></tr>\n");
      out.write("\t\t\t\t\t<tr><td></td><td><input type=\"submit\" value=\"Submit\" style=\"width:70px; height:25px;\"/>&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\t\t\t\t<INPUT TYPE=RESET VALUE=\"CLEAR\" style=\"width:70px; height:25px;\"/></td></tr>\n");
      out.write("                                    </table>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("                                </td>\n");
      out.write("        </td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\n");
      out.write("\t</table>\n");
      out.write("    \t   </div>      \n");
      out.write("    </td>\n");
      out.write("    \n");
      out.write("   <td width=\"250\" valign=\"top\">\n");
      out.write("    \t<div id=\"welcome\" style=\"border-right:#666666 1px dotted;\"><h1>Welcome</h1><br>\n");
      out.write("    \t    <center><img src=\"images/welcome.gif\" alt=\"business\" width=\"196\" height=\"106\"></center><br>\n");
      out.write("\t\t    <p>\"We provide best services to the users of this website in which the user can easily make any number of transactions\n");
      out.write("                    across India.\"</p>\t    \t\n");
      out.write("\t    </div>      \n");
      out.write("    </td>\n");
      out.write("        </tr>\n");
      out.write("</table>\n");
      out.write("    \n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("document.onload = ctck();\n");
      out.write("</script>\n");
      out.write("            <div id=\"footer\">\n");
      out.write("  <div id=\"footer_navigation\">\n");
      out.write("  \n");
      out.write("  </div>  \n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
