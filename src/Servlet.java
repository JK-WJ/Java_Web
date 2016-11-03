import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by WJPC on 2016/11/1.
 */
public class Servlet extends HttpServlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Post 中文乱码解决：
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        // 通过设置响应头控制游览器以UTF-8的编码显示数据
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.print(" get name:" + name);
        out.println(", using the Post method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get 中文乱码解决：
        String name1 = request.getParameter("name");
        name1 = new String(name1.getBytes("ISO8859-1"), "UTF-8") ;
        // 通过设置响应头控制游览器以UTF-8的编码显示数据
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.getWriter().print("name=" + name1);
        response.getWriter().print("<hr/>");

        // 获取在web.xml中配置的初始化参数
        String paramVal = this.config.getInitParameter("name");
        response.getWriter().print(paramVal);
        response.getWriter().print("<hr/>");

        // 获取所有的初始化参数
        Enumeration<String> e = config.getInitParameterNames();
        while(e.hasMoreElements()) {
            String name = e.nextElement();
            String value = config.getInitParameter(name);
            response.getWriter().print(name + "=" + value + "<br/>");
        }
        response.getWriter().print("<hr/>");
    }
}
