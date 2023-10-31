package allLec.lecture22;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@WebServlet(urlPatterns = {"/minsk", "/washington", "/beijing"})
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI(); // Get the full request URI, e.g., /javaAbove20_war/minsk
        TimeZone timeZone = null;

        if (requestURI.endsWith("/minsk")) {
            timeZone = TimeZone.getTimeZone("Europe/Minsk");
        } else if (requestURI.endsWith("/washington")) {
            timeZone = TimeZone.getTimeZone("America/New_York");
        } else if (requestURI.endsWith("/beijing")) {
            timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        }

        if (timeZone != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            sdf.setTimeZone(timeZone);
            String time = sdf.format(new Date());

            resp.setContentType("text/plain");
            resp.getWriter().write("Time in " + timeZone.getDisplayName() + ": " + time);
        } else {
            resp.setContentType("text/plain");
            resp.getWriter().write("Unknown city");
        }
    }


}
