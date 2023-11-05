package allLec.lecture22;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/age","/"})
public class AgeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        String ageStr = req.getParameter("age");

        if (ageStr != null && !ageStr.isEmpty()) {
            try {
                int age = Integer.parseInt(ageStr);

                if (age >= 18) {
                    resp.getWriter().write("Over 18");
                } else {
                    resp.getWriter().write("Under 18");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().write("Invalid age format");
            }
        } else {
            resp.getWriter().write("Please provide an age parameter.");
        }

    }

}