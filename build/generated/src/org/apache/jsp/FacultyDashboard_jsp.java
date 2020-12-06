package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FacultyDashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("    <title>FACULTY HOME </title>\n");
      out.write("    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />\n");
      out.write("\n");
      out.write("    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>\n");
      out.write("    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>\n");
      out.write("  \n");
      out.write("    <link href=\"assets_faculty/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <link href=\"assets_faculty/css/dashboard.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"wrapper\">\n");
      out.write("        <div class=\"sidebar\">\n");
      out.write("            <div class=\"sidebar-wrapper\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"#\" class=\"simple-text\">\n");
      out.write("                        FACULTY\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"FacultyDashboard.jsp\">\n");
      out.write("                            <i class=\"nc-icon nc-chart-pie-35\"></i>\n");
      out.write("                            <p>DASHBOARD</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"nav-link\" href=\"FacultyProfile.jsp\">\n");
      out.write("                            <i class=\"nc-icon nc-circle-09\"></i>\n");
      out.write("                            <p>PROFILE</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"nav-link\" href=\"FacultyQuizData.jsp\">\n");
      out.write("                            <i class=\"nc-icon nc-notes\"></i>\n");
      out.write("                            <p>STUDENTS</p>\n");
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
      out.write("                    <div class=\"collapse navbar-collapse justify-content-end\" id=\"navigation\">\n");
      out.write("                        <ul class=\"nav navbar-nav mr-auto\">\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"navbar-brand\" href=\"./dashboard.html\">DASHBOARD </a>\n");
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
      out.write("                        <div class=\"col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("                          <div class=\"card card-stats\">\n");
      out.write("                            <div class=\"card-header card-header-warning card-header-icon\">\n");
      out.write("                              <div class=\"card-icon\">\n");
      out.write("                                <i class=\"material-icons\">TOTAL REGISTERED</i>\n");
      out.write("                              </div>\n");
      out.write("                              <h1 class=\"card-title\">40</h1>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"card-footer\">\n");
      out.write("                              <div class=\"stats\">\n");
      out.write("                                <a href=\"Registered_Student_List.jsp\">Details</a>\n");
      out.write("                              </div>\n");
      out.write("                            </div>\n");
      out.write("                          </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("                          <div class=\"card card-stats\">\n");
      out.write("                            <div class=\"card-header card-header-success card-header-icon\">\n");
      out.write("                              <div class=\"card-icon\">\n");
      out.write("                                <i class=\"material-icons\">TOTAL PRESENT</i>\n");
      out.write("                              </div>\n");
      out.write("                              <h1 class=\"card-title\">33</h1>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"card-footer\">\n");
      out.write("                              <div class=\"stats\">\n");
      out.write("                                <a href=\"Todays_Attendance.jsp\">Details</a>\n");
      out.write("                              </div>\n");
      out.write("                            </div>\n");
      out.write("                          </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <div class=\"card strpied-tabled-with-hover\">\n");
      out.write("                                <div class=\"card-header \">\n");
      out.write("                                    <h4 class=\"card-title\">TIME TABLE</h4>\n");
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
      out.write("                                                <td></td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td>CLASS</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>TUESDAY</td>\n");
      out.write("                                                <td>CLASS</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>WEDNESDAY</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td>CLASS</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>THURSDAY</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>FRIDAY</td>\n");
      out.write("                                                <td></td>\n");
      out.write("                                                <td>CLASS</td>\n");
      out.write("                                                <td></td>\n");
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
      out.write("<script src=\"../assets/js/core/jquery.3.2.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"../assets/js/core/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"../assets/js/core/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"../assets/js/dashboard.js\" type=\"text/javascript\"></script>\n");
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
