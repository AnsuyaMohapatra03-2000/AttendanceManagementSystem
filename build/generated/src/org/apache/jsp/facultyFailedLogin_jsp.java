package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class facultyFailedLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \t<title>Failed</title>\n");
      out.write("\t\t<style>\n");
      out.write("\t\t\tbody{\n");
      out.write("\t\t\t\tpadding-top: 8%;\n");
      out.write("\t\t\t\tbackground-image: url(\"img/bg.png\");\n");
      out.write("\t\t\t\tbackground-position: fixed;\n");
      out.write("\t\t\t\tmargin: 0;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tp{\n");
      out.write("\t\t\t\tpadding-top: 15%;\n");
      out.write("\t\t\t\tfont-size: 30px;\n");
      out.write("\t\t\t\ttext-align: center;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t.center-div{\n");
      out.write("\t\t\t\tmargin:auto;\n");
      out.write("\t\t\t\tmax-width:500px;\n");
      out.write("\t\t\t\tbackground-color: #af7ccc; \n");
      out.write("\t\t\t\tcolor:#ffffff;\n");
      out.write("\t\t\t\tpadding:10px 0;\n");
      out.write("\t\t\t\ttext-align:center;\n");
      out.write("\t\t\t\tmin-height:300px;\n");
      out.write("\t\t\t\tborder-bottom: 5px solid #883098;\n");
      out.write("\t\t\t\tbox-shadow: 10px 5px 5px #883098;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t.fixed-footer{\n");
      out.write("\t\t\t\twidth: 100%;\n");
      out.write("\t\t        position: fixed;        \n");
      out.write("\t\t        background: #af7ccc;\n");
      out.write("\t\t        font-size: 26px;\n");
      out.write("\t\t        color: #fff;\n");
      out.write("\t\t        bottom: 0;\n");
      out.write("\t\t        line-height: 40px;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t.container{\n");
      out.write("\t\t\t\tmargin: 0 auto;\n");
      out.write("\t\t\t\tpadding: 10px;\n");
      out.write("\t\t\t\ttext-align: center;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\ta{\n");
      out.write("\t\t\t\ttext-decoration: none;\n");
      out.write("\t\t\t\tcolor: #ffffff;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t</style>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<div class=\"center-div\">\n");
      out.write("\t\t\t<p>Please enter valid Student ID and Password!!</p>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"fixed-footer\">\n");
      out.write("\t\t\t<div class=\"container\"><a href=\"facultyLogin.html\">Click here to go to the Login Page</a></div>    \n");
      out.write("\t\t</div>\n");
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
