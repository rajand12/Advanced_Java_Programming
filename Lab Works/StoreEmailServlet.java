import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/StoreEmailServlet")
public class StoreEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        // Get or create the HttpSession object for the current user
        HttpSession session = request.getSession(true);

        // Store the email information in the session
        session.setAttribute("userEmail", email);

        // Redirect the user back to the index.html page
        response.sendRedirect("index.html");
    }
}
