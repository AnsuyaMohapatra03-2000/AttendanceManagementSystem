package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboardStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/img/apple-icon.png\">\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" href=\"assets/img/favicon.ico\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("    <title>STUDENT HOME </title>\n");
      out.write("    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />\n");
      out.write("\n");
      out.write("    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>\n");
      out.write("    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>\n");
      out.write("\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700,200\" rel=\"stylesheet\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\" />\n");
      out.write("  \n");
      out.write("    <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/dashboard.css\" rel=\"stylesheet\" />\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("\n");
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
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"dashboard.html\">\n");
      out.write("                            <i class=\"nc-icon nc-chart-pie-35\"></i>\n");
      out.write("                            <p>Dashboard</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"nav-link\" href=\"./user.html\">\n");
      out.write("                            <i class=\"nc-icon nc-circle-09\"></i>\n");
      out.write("                            <p>Profile</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"nav-link\" href=\"./lectures.html\">\n");
      out.write("                            <i class=\"nc-icon nc-notes\"></i>\n");
      out.write("                            <p>Lectures</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"main-panel\">\n");
      out.write("            <!-- Navbar -->\n");
      out.write("            <nav class=\"navbar navbar-expand-lg \" color-on-scroll=\"500\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\"> DASHBOARD </a>\n");
      out.write("                    <button href=\"\" class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" aria-controls=\"navigation-index\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <span class=\"navbar-toggler-bar burger-lines\"></span>\n");
      out.write("                        <span class=\"navbar-toggler-bar burger-lines\"></span>\n");
      out.write("                        <span class=\"navbar-toggler-bar burger-lines\"></span>\n");
      out.write("                    </button>\n");
      out.write("\n");
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
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- End Navbar -->\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"container col-md-12\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-header \">\n");
      out.write("                                <h4 class=\"card-title\">ATTENDANCE</h4>\n");
      out.write("                                <p class=\"card-category\">Subject-Wise</p>\n");
      out.write("                            </div>\n");
      out.write("                            <section id=\"circleBar\">\n");
      out.write("                            <div class=\"row-progress\">\n");
      out.write("                                <div class=\"col-md-3\">                        \n");
      out.write("                                    <div class=\"round\" data-value=\"0.50\" data-size=\"200\" data-thickness=\"6\">\n");
      out.write("                                        <strong></strong>\n");
      out.write("                                        <span> IWT</span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-3\">                    \n");
      out.write("                                    <div class=\"round\" data-value=\"0.74\" data-size=\"200\" data-thickness=\"6\">\n");
      out.write("                                    <strong></strong>\n");
      out.write("                                    <span>OS</span>\n");
      out.write("                                </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-3\">            \n");
      out.write("                                    <div class=\"round\" data-value=\"0.65\" data-size=\"200\" data-thickness=\"6\">\n");
      out.write("                                        <strong></strong>\n");
      out.write("                                        <span> DCCN</span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            </section>  \n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <div class=\"card strpied-tabled-with-hover\">\n");
      out.write("                                <div class=\"card-header \">\n");
      out.write("                                    <h4 class=\"card-title\">TIME TABLE </h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body table-full-width table-responsive\">\n");
      out.write("                                    <table class=\"table table-hover table-striped\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <th>Day</th>\n");
      out.write("                                            <th>10:00-11:00</th>\n");
      out.write("                                            <th>11:00-12:00</th>\n");
      out.write("                                            <th>12:00-1:00</th>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>MONDAY</td>\n");
      out.write("                                                <td>OS</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td>IWT</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>TUESDAY</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td>DCCN</td>\n");
      out.write("                                                <td>OS</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>WEDNESDAY</td>\n");
      out.write("                                                <td>DCCN</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>THURSDAY</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td>IWT</td>\n");
      out.write("                                                <td>OS</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>FRIDAY</td>\n");
      out.write("                                                <td>IWT</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td>DCCN</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("<!--   Core JS Files   -->\n");
      out.write("<script src=\"assets/js/core/jquery.3.2.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"assets/js/core/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"assets/js/core/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"assets/js/dashboard.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write(" <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>\n");
      out.write("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-circle-progress/1.2.0/circle-progress.min.js'></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function Circlle(el){\n");
      out.write("      $(el).circleProgress({fill: {color: '#800080'}})\n");
      out.write("        .on('circle-animation-progress', function(event, progress, stepValue){\n");
      out.write("                        $(this).find('strong').text(String(stepValue.toFixed(2)).substr(2)+'%');\n");
      out.write("                });  \n");
      out.write("    };\n");
      out.write("    Circlle('.round');\n");
      out.write("</script>\n");
      out.write("\n");
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
