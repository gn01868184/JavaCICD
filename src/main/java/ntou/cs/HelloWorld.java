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
        PrintWriter writer = resp.getWriter();
        writer.println('<head>
            <meta charset="utf-8">
            <title>Basic DOM</title>
            <style type="text/CSS">
                @import url(https://fonts.googleapis.com/earlyaccess/cwtexyen.css);

                h1 {
        			font-size: 50px;
        			font-family: cwTeXYen;
        		}

        		div {
        			font-size: 80px;
        			font-family: Consolas;
        			margin: 5px;
        			float: left;
        		}
        		div.number {
        			border: 1px solid black;
        			color: dodgerblue;
        		}
        	</style>
        </head>');
        writer.println('<body>
            <h1>四則運算結果:</h1>
            <div class="number" id="num1">Number1</div>
            <div id="op">+</div>
            <div class="number" id="num2">Number2</div>
            <div>=</div>
            <div class="number" id="result">Result</div>
        </body>');


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
