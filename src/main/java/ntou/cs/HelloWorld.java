package ntou.cs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
 public class HelloWorld extends HttpServlet {

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp)
             throws ServletException, IOException {
         resp.getWriter().print("Hello from Java!\n");
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
