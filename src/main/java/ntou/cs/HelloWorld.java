package ntou.cs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class HelloWorld extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset='utf-8'>");
        writer.println("<title>Basic DOM</title>");
        writer.println("<style type='text/CSS'>");
        writer.println("@import url(https://fonts.googleapis.com/earlyaccess/cwtexyen.css);");
        writer.println("h1 {");
        writer.println("font-size: 50px;");
        writer.println("font-family: cwTeXYen;");
        writer.println("}");
        writer.println("div {");
        writer.println("font-size: 80px;");
        writer.println("font-family: Consolas;");
        writer.println("margin: 5px;");
        writer.println("float: left;");
        writer.println("}");
        writer.println("div.number {");
        writer.println("border: 1px solid black;");
        writer.println("color: dodgerblue;");
        writer.println("}");
        writer.println("</style>");
        writer.println("</head>");

        writer.println("<body>");
        writer.println("<h1>四則運算結果:</h1>");
        writer.println("<div class='number' id='num1'>Number1</div>");
        writer.println("<div id='op'>+</div>");
        writer.println("<div class='number' id='num2'>Number2</div>");
        writer.println("<div>=</div>");
        writer.println("<div class='number' id='result'>Result</div>");
        writer.println("</body>");
        writer.println("</html>");

        writer.close();
    }

    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HelloWorld()),"/*");
        server.start();
        server.join();
    }
}
