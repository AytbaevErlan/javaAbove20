package allLec.lecture23.servlet;

import allLec.lecture23.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static allLec.lecture23.servlet.ContextServlet.SERVLET_CONTEXT_ATTRIBUTE_NAME;
import static allLec.lecture23.servlet.RequestScopeServlet.REQUEST_ATTRIBUTE_NAME;

@WebServlet(urlPatterns = "/other", name = "yetAnotherServlet")
public class YetAnotherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = (UserDto) req.getAttribute(REQUEST_ATTRIBUTE_NAME);
        if(userDto == null){
            resp.setHeader("Content-Type", "text/html");
            resp.getWriter().print("You should fetch <a href =\"request\">/request</a>");
        } else {
            resp.setHeader("Content-Type", "text/html");
            resp.getWriter().print("User name %s and login %s".formatted(userDto.getName(), userDto.getLogin()));
            resp.getWriter().print("<br/>Amount of visit /context %s".formatted(Objects.toString(getServletContext().
                    getAttribute(SERVLET_CONTEXT_ATTRIBUTE_NAME))));
        }
    }
}
