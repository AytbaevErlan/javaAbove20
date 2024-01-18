package allLec.lecture23.servlet;

import allLec.lecture23.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/request")
public class RequestScopeServlet extends HttpServlet {

    public static final String REQUEST_ATTRIBUTE_NAME = "reqAttr";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = new UserDto("Erlan","tbvrln");
        System.out.println("try to put attribute");
        req.setAttribute(REQUEST_ATTRIBUTE_NAME, userDto);
        System.out.println("attribute added");
        req.getRequestDispatcher("/other").forward(req, resp);
    }
}
