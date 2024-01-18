package allLec.lecture23.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static allLec.lecture23.servlet.SessionServlet.SESSION_ATTRIBUTE_NAME;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession().removeAttribute(SESSION_ATTRIBUTE_NAME);
        req.getSession().invalidate();

        resp.sendRedirect(req.getContextPath()); //redirect to home page
    }
}
