package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Student.DisplayImage;
import java.sql.*;

public final class StudentHomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"../assets/img/apple-icon.png\">\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" href=\"../assets/img/favicon.ico\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("    <title>STUDENT HOME</title>\n");
      out.write("    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700,200\" rel=\"stylesheet\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\" />\n");
      out.write("    ");
 String id = (String)request.getAttribute("ID");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function() {                       \n");
      out.write("            $('#dashboardAnchor').click(function() {               \n");
      out.write("                $.get('ManageHomePages', function(responseText) { \n");
      out.write("                    $('#somediv').text(responseText);        \n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("\n");
      out.write("        $(\"#somebutton\").click(function(){\n");
      out.write("         $.ajax({\n");
      out.write("            url:'ManageHomePages',\n");
      out.write("            data:{ID:");
      out.print(id);
      out.write("},\n");
      out.write("            type:'post',\n");
      out.write("            cache:false,\n");
      out.write("            success:function(data){\n");
      out.write("               alert(data);\n");
      out.write("               $('#somediv').text(responseText); \n");
      out.write("            },\n");
      out.write("            error:function(){\n");
      out.write("              alert('error');\n");
      out.write("            }\n");
      out.write("         }\n");
      out.write("    );\n");
      out.write("  }\n");
      out.write(" );\n");
      out.write("    </script>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!-- CSS Files -->\n");
      out.write("    <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/dashboard.css?v=2.0.0 \" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"assets/css/demo.css\" rel=\"stylesheet\" />\n");
      out.write("</head>\n");

      
       String fname = (String)request.getAttribute("FNAME");
       String lname = (String)request.getAttribute("LNAME");
       String email = (String)request.getAttribute("EMAIL");
       String subject1 = (String)request.getAttribute("SUBJECT_1");
       String subject2 = (String)request.getAttribute("SUBJECT_2");
       String subject3 = (String)request.getAttribute("SUBJECT_3");
       String selectQuery;
       byte[] img = null;
       ServletOutputStream sos = null;
       
       if(subject1 == null){
           subject1 = "   ";
       }
       if(subject2 == null){
           subject2 = "  ";
       }
       if(subject3 == null){
           subject3 = "   ";
       }    
     
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
      out.write("                        <a id=\"dashboardAnchor\" class=\"nav-link\" href=\"\">\n");
      out.write("                            <i class=\"nc-icon nc-chart-pie-35\"></i>\n");
      out.write("                            <p>Dashboard</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"StudentHomePage.jsp\">\n");
      out.write("                            <i class=\"nc-icon nc-circle-09\"></i>\n");
      out.write("                            <p>Profile</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"nav-link\" href=\"lectureCards.jsp\">\n");
      out.write("                            <i class=\"nc-icon nc-notes\"></i>\n");
      out.write("                            <p>Lectures</p>\n");
      out.write("                        </a>\n");
      out.write("                    </li>   \n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"main-panel\">\n");
      out.write("            <!-- Navbar -->\n");
      out.write("            <nav class=\"navbar navbar-expand-lg \" color-on-scroll=\"500\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\"> PROFILE </a>\n");
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
      out.write("                                    <span class=\"d-lg-none\">Dashboard</span>\n");
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
      out.write("            <!-- End Navbar -->\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-8\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-header\">\n");
      out.write("                                    <h4 class=\"card-title\">PROFILE</h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <form>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-5 pr-1\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>COLLEGE</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" disabled=\"\"value=\"IIIT Bh\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-3 px-1\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>ID</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" disabled=\"\" value=");
      out.print(id);
      out.write(">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-6 pr-1\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>FIRST NAME</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" disabled=\"\" value=");
      out.print(fname);
      out.write(">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-6 pl-1\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>LAST NAME</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" disabled=\"\" value=");
      out.print(lname);
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-12\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"exampleInputEmail1\">Email Address</label>\n");
      out.write("                                                    <input type=\"email\" class=\"form-control\" disabled=\"\" value=");
      out.print(email);
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-3 pr-1\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>SUBJECT 1</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" disabled=\"\" value=");
      out.print(subject1);
      out.write(">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-3 px-1\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>SUBJECT 2</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" disabled=\"\" value=");
      out.print(subject2);
      out.write(">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-3\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label>SUBJECT 3</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" disabled=\"\" value=");
      out.print(subject3);
      out.write(">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    \n");
      out.write("                ");
  DisplayImage f = new DisplayImage();
                       f.sendId(id); 
      out.write("\n");
      out.write("                                                \n");
      out.write("                        <div class=\"col-md-4\">\n");
      out.write("                            <div class=\"card card-user\">\n");
      out.write("                                <div class=\"card-image\">\n");
      out.write("                                    <img src=\"https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400\" alt=\"...\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"author\">\n");
      out.write("                                        <a href=\"#\">\n");
      out.write("                                            <img class=\"avatar border-gray\" src=\"DisplayImage\">\n");
      out.write("                                            <h5 class=\"title\">");
      out.print((fname +" "+ lname));
      out.write("</h5>\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("           \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("<!--  JS Files   -->\n");
      out.write("<script src=\"assets/js/core/jquery.3.2.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"assets/js/core/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"assets/js/core/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"assets/js/dashboard.js\" type=\"text/javascript\"></script>\n");
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
