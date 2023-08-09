import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubmitFormServlet")
public class SubmitFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String major = request.getParameter("major");
        String faculty = request.getParameter("faculty");

        String result = "Name: " + name + "<br>Major: " + major + "<br>Faculty: " + faculty;

        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><head><title>Form Submission Result</title></head><body>");
        response.getWriter().println("<h2>Form Submission Result</h2>");
        response.getWriter().println(result);
        response.getWriter().println("</body></html>");
    }
}
