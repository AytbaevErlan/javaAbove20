package allLec.lecture23.servlet;

import allLec.lecture23.dto.CartDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static allLec.lecture23.servlet.SessionServlet.SESSION_ATTRIBUTE_NAME;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartDto cartDto = (CartDto) req.getSession().getAttribute(SESSION_ATTRIBUTE_NAME);
        resp.getWriter().println(cartDto);
    }
}
