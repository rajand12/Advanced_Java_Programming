<!DOCTYPE html>
<html>
<head>
    <title>Fibonacci Series</title>
</head>
<body>
    <h2>Fibonacci Series</h2>
    <form action="" method="post">
        Enter a number: <input type="number" name="number" required>
        <input type="submit" name="fibo" value="Fibo">
    </form>

    <%-- JSP code to calculate and display the Fibonacci series --%>
    <% 
    if (request.getMethod().equalsIgnoreCase("post")) {
        int number = Integer.parseInt(request.getParameter("number"));

        int firstNum = 0;
        int secondNum = 1;

        out.println("<p>Fibonacci Series:</p>");
        out.print(firstNum + ", " + secondNum);

        while (firstNum + secondNum <= number) {
            int nextNum = firstNum + secondNum;
            out.print(", " + nextNum);
            firstNum = secondNum;
            secondNum = nextNum;
        }
    }
    %>
</body>
</html>
