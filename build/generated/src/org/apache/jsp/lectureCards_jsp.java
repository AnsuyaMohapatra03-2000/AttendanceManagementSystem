package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lectureCards_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" href=\"assets/img/favicon.ico\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("    <title>STUDENT HOME</title>\n");
      out.write("    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />\n");
      out.write("    <!--     Fonts and icons     -->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700,200\" rel=\"stylesheet\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\" />\n");
      out.write("    <!-- CSS Files -->\n");
      out.write("    <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/dashboard.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/demo.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("    <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" >\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style_sublist.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"wrapper\">\n");
      out.write("        <div class=\"sidebar\">\n");
      out.write("            <div class=\"sidebar-wrapper\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"#\" class=\"simple-text\">\n");
      out.write("                        STUDENT\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav\">\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"nav-link\" href=\"dashboard.html\">\n");
      out.write("                            <i class=\"nc-icon nc-chart-pie-35\"></i>\n");
      out.write("                            <p>DASHBOARD</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"nav-link\" href=\"./user.html\">\n");
      out.write("                            <i class=\"nc-icon nc-circle-09\"></i>\n");
      out.write("                            <p>PROFILE</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"./lectures.html\">\n");
      out.write("                            <i class=\"nc-icon nc-notes\"></i>\n");
      out.write("                            <p>LECTURES</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"main-panel\">\n");
      out.write("            <!-- Navbar -->\n");
      out.write("            <nav class=\"navbar navbar-expand-lg \" color-on-scroll=\"500\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\"> LECTURES </a>\n");
      out.write("                    <button href=\"\" class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" aria-controls=\"navigation-index\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <span class=\"navbar-toggler-bar burger-lines\"></span>\n");
      out.write("                        <span class=\"navbar-toggler-bar burger-lines\"></span>\n");
      out.write("                        <span class=\"navbar-toggler-bar burger-lines\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <div class=\"collapse navbar-collapse justify-content-end\" id=\"navigation\">\n");
      out.write("                        <ul class=\"nav navbar-nav mr-auto\">\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a href=\"#\" class=\"nav-link\" data-toggle=\"dropdown\">\n");
      out.write("                                    <span class=\"d-lg-none\">DASHBOARD</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"#\">\n");
      out.write("                                    <span class=\"no-icon\">LOG OUT</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("            <!-- End Navbar -->\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"col-md-12\"> \n");
      out.write("                            <section class=\"sub-list\">\n");
      out.write("                              <div class=\"container-fluid\">\n");
      out.write("                                <div class=\"container\">\n");
      out.write("                                  <div class=\"row\">\n");
      out.write("                                    <div class=\"col-sm-4\">\n");
      out.write("                                      <div class=\"card-subject text-center\">\n");
      out.write("                                        <div class=\"title-sub\">\n");
      out.write("                                          <i class=\"fa fa-internet-explorer\"></i>\n");
      out.write("                                          <h2>Internet and Web Technologies</h2>\n");
      out.write("                                        </div>\n");
      out.write("                                       <a href=\"#\">Lecture 01</a>\n");
      out.write("             \t\t\t\t\t\t\t<a href=\"#\">Lecture 02</a>\n");
      out.write("              \t\t\t\t\t\t\t<a href=\"#\">Lecture 03</a>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- END Col one -->\n");
      out.write("                                    <div class=\"col-sm-4\">\n");
      out.write("                                      <div class=\"card-subject text-center\">\n");
      out.write("                                        <div class=\"title-sub\">\n");
      out.write("                                          <i class=\"fa fa-windows\" ></i>\n");
      out.write("                                          <h2>Operating System</h2>\n");
      out.write("                                        </div>\n");
      out.write("                                        <a href=\"#\">Lecture 01</a>\n");
      out.write("             \t\t\t\t\t\t\t<a href=\"#\">Lecture 02</a>\n");
      out.write("              \t\t\t\t\t\t\t<a href=\"#\">Lecture 03</a>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- END Col two -->\n");
      out.write("                                    <div class=\"col-sm-4\">\n");
      out.write("                                      <div class=\"card-subject text-center\">\n");
      out.write("                                        <div class=\"title-sub\">\n");
      out.write("                                          <i class=\"fa fa-wifi\"></i>\n");
      out.write("                                          <h2>Data Communication and Computer Networks</h2>\n");
      out.write("                                        </div>\n");
      out.write("                                          <a href=\"#\">Lecture 01</a>\n");
      out.write("             \t\t\t\t\t\t\t<a href=\"#\">Lecture 02</a>\n");
      out.write("              \t\t\t\t\t\t\t<a href=\"#\">Lecture 03</a>\n");
      out.write("                                      </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- END Col three -->\n");
      out.write("                                  </div>\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                            </section>\n");
      out.write("                        </div>\n");
      out.write("                    \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("</body>\n");
      out.write("<!--   Core JS Files   -->\n");
      out.write("<script src=\"assets/js/core/jquery.3.2.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"assets/js/core/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"assets/js/core/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<!--script src=\"../assets/js/plugins/chartist.min.js\"></script-->\n");
      out.write("<script src=\"assets/js/dashboard.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
