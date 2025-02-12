package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="MyServlet", urlPatterns = {"/myurl"})
public class MyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
     throws ServletException, IOException {

        PrintWriter p = new PrintWriter(resp.getWriter());
        p.print("Hello World");
        p.flush();
        //resp.getWriter().write("Hello World");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
     throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
