package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class IWT_005fLectures_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("    <title>IWT Lectures</title>\n");
      out.write("<style>\n");
      out.write("            body\n");
      out.write("            {\n");
      out.write("              margin: 0;\n");
      out.write("              padding: 0;\n");
      out.write("              background-color: #f2f2f2;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style the tab */\n");
      out.write("            .tab {\n");
      out.write("              overflow: hidden;\n");
      out.write("              background-color: #800080;\n");
      out.write("              color: white;\n");
      out.write("              text-align: center;\n");
      out.write("              padding: 10px 10px 1px 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style the buttons inside the tab */\n");
      out.write("            .tab button {\n");
      out.write("              float: left;\n");
      out.write("              border: none;\n");
      out.write("              outline: none;\n");
      out.write("              cursor: pointer;\n");
      out.write("              padding: 14px 16px;\n");
      out.write("              margin-right: 2px;\n");
      out.write("              transition: 0.3s ease;\n");
      out.write("              font-size: 17px;\n");
      out.write("              color: #4d004d;\n");
      out.write("              border: none;\n");
      out.write("              width: 150px;\n");
      out.write("              border-radius: 12px 12px 0 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Change background color of buttons on hover */\n");
      out.write("            .tab button:hover {\n");
      out.write("              background-color: #ddd;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Create an active/current tablink class */\n");
      out.write("            .tab button.active {\n");
      out.write("              background-color: #ccc;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style the tab content */\n");
      out.write("            .tabcontent {\n");
      out.write("              display: none;\n");
      out.write("              padding: 6px 12px;\n");
      out.write("              border-top: none;\n");
      out.write("            }\n");
      out.write("            #video_player_box_1{ width:550px; background:#000; margin:0px auto;}\n");
      out.write("            #video_controls_bar_1{ background: #333; padding:10px; color:#CCC;}\n");
      out.write("            #seekslider_1{ width:180px; }\n");
      out.write("            #volumeslider_1{ width: 80px;}\n");
      out.write("            \n");
      out.write("            #video_player_box_2{ width:550px; background:#000; margin:0px auto;}\n");
      out.write("            #video_controls_bar_2{ background: #333; padding:10px; color:#CCC;}\n");
      out.write("            #seekslider_2{ width:180px; }\n");
      out.write("            #volumeslider_2{ width: 80px;}\n");
      out.write("     \n");
      out.write("            #video_player_box_3{ width:550px; background:#000; margin:0px auto;}\n");
      out.write("            #video_controls_bar_3{ background: #333; padding:10px; color:#CCC;}\n");
      out.write("            #seekslider_3{ width:180px; }\n");
      out.write("            #volumeslider_3{ width: 80px;}\n");
      out.write("</style>\n");
      out.write("<link rel=\"shortcut icon\" href=\"#\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"tab\">\n");
      out.write("  <button class=\"tablinks\" id=\"defaultOpen\" onclick=\"openSub(event, 'Lecture-1')\">LECTURE-1</button>\n");
      out.write("  <button class=\"tablinks\" onclick=\"openSub(event, 'Lecture-2')\">LECTURE-2</button>\n");
      out.write("  <button class=\"tablinks\" onclick=\"openSub(event, 'Lecture-3')\">LECTURE-3</button>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"Lecture-1\" class=\"tabcontent\">\n");
      out.write("    <h2 style=\"text-align:center;\">Introduction to HTML</h2>\n");
      out.write("          <br><br>\n");
      out.write("          <div id=\"video_player_box_1\">\n");
      out.write("              <video id=\"my_video_1\" width=\"550\" height=\"310\">\n");
      out.write("                                     <source src=\"videos/IWT_1.mp4\" type=\"video/mp4\">\n");
      out.write("                           </video>\n");
      out.write("                          <div id=\"video_controls_bar_1\">\n");
      out.write("                                        <button id=\"playpausebtn_1\">Pause</button>\n");
      out.write("                                        <input id=\"seekslider_1\" type=\"range\" min=\"0\" max=\"100\" value=\"0\" step=\"1\">\n");
      out.write("                                        <span id=\"curtimetext_1\">00:00</span> / <span id=\"durtimetext_1\">00:00</span>\n");
      out.write("                                        <button id=\"mutebtn_1\">Mute</button>\n");
      out.write("                                        <input id=\"volumeslider_1\" type=\"range\" min=\"0\" max=\"100\" value=\"100\" step=\"1\">\n");
      out.write("                         </div>\n");
      out.write("       </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"Lecture-2\" class=\"tabcontent\">\n");
      out.write("     <h2 style=\"text-align:center;\">Introduction to CSS</h2>\n");
      out.write("          <br><br>\n");
      out.write("          <div id=\"video_player_box_2\">\n");
      out.write("                           <video id=\"my_video_2\" width=\"550\" height=\"310\">\n");
      out.write("                                     <source src=\"videos/IWT_2.mp4\" type=\"video/mp4\">\n");
      out.write("                                         Your browser does not support the <code>video</code> tag.\n");
      out.write("                           </video>\n");
      out.write("                          <div id=\"video_controls_bar_2\">\n");
      out.write("                                        <button id=\"playpausebtn_2\">Pause</button>\n");
      out.write("                                        <input id=\"seekslider_2\" type=\"range\" min=\"0\" max=\"100\" value=\"0\" step=\"1\">\n");
      out.write("                                        <span id=\"curtimetext_2\">00:00</span> / <span id=\"durtimetext_2\">00:00</span>\n");
      out.write("                                        <button id=\"mutebtn_2\">Mute</button>\n");
      out.write("                                        <input id=\"volumeslider_2\" type=\"range\" min=\"0\" max=\"100\" value=\"100\" step=\"1\">\n");
      out.write("                         </div>\n");
      out.write("       </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"Lecture-3\" class=\"tabcontent\">\n");
      out.write("          <h2 style=\"text-align:center;\">What Is Java - Java Programming </h2>\n");
      out.write("          <br><br>\n");
      out.write("          <div id=\"video_player_box_3\">\n");
      out.write("                           <video id=\"my_video_3\" width=\"550\" height=\"310\">\n");
      out.write("                                     <source src=\"videos/IWT_3.mp4\" type=\"video/mp4\">\n");
      out.write("                           </video>\n");
      out.write("                          <div id=\"video_controls_bar_3\">\n");
      out.write("                                        <button id=\"playpausebtn_3\">Pause</button>\n");
      out.write("                                        <input id=\"seekslider_3\" type=\"range\" min=\"0\" max=\"100\" value=\"0\" step=\"1\">\n");
      out.write("                                        <span id=\"curtimetext_3\">00:00</span> / <span id=\"durtimetext_3\">00:00</span>\n");
      out.write("                                        <button id=\"mutebtn_3\">Mute</button>\n");
      out.write("                                        <input id=\"volumeslider_3\" type=\"range\" min=\"0\" max=\"100\" value=\"100\" step=\"1\">\n");
      out.write("                         </div>\n");
      out.write("       </div>\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("function openSub(evt, subName) {\n");
      out.write("  var i, tabcontent, tablinks;\n");
      out.write("  tabcontent = document.getElementsByClassName(\"tabcontent\");\n");
      out.write("  for (i = 0; i < tabcontent.length; i++) {\n");
      out.write("    tabcontent[i].style.display = \"none\";\n");
      out.write("  }\n");
      out.write("  tablinks = document.getElementsByClassName(\"tablinks\");\n");
      out.write("  for (i = 0; i < tablinks.length; i++) {\n");
      out.write("    tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\n");
      out.write("  }\n");
      out.write("  document.getElementById(subName).style.display = \"block\";\n");
      out.write("  evt.currentTarget.className += \" active\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("// Get the element with id=\"defaultOpen\" and click on it\n");
      out.write("document.getElementById(\"defaultOpen\").click();\n");
      out.write("</script>\n");
      out.write("<script src=\"js/videoRedirect_1.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/videoRedirect_2.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/videoRedirect_3.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
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
