import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by WJPC on 2016/11/2.
 */
@WebServlet(name = "DefaultServlet")
public class DefaultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容
        response.setContentType("text/html");
        // 设置逻辑实现
        PrintWriter out = response.getWriter();
        out.println("<h1>" + "This is a default servlet hello" + "</h3>");
    }
}
