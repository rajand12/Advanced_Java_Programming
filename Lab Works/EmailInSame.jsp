<!DOCTYPE html>
<html>
<head>
    <title>Email Submission</title>
</head>
<body>
    <h2>Email Submission</h2>
    <form action="" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <input type="submit" value="Submit">
    </form>

    <%-- JSP code to handle form submission --%>
    <%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String email = request.getParameter("email");

        // Get or create the HttpSession object for the current user
        HttpSession session = request.getSession(true);

        // Store the email information in the session
        session.setAttribute("userEmail", email);

        // Redirect the user back to the same page (index.jsp)
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
    %>
</body>
</html>
