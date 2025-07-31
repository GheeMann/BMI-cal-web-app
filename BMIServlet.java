import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BMIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String weightStr = request.getParameter("weight");
        String heightStr = request.getParameter("height");

        out.println("<html><head><title>BMI Result</title></head><body>");
        out.println("<h1>BMI Result</h1>");

        try {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);

            if (weight <= 0 || height <= 0) {
                out.println("<p style='color:red;'>Weight and height must be greater than zero.</p>");
            } else {
                double bmi = (weight * 703) / (height * height);
                out.printf("<p>Your BMI is: <strong>%.2f</strong></p>", bmi);
            }
        } catch (NumberFormatException | NullPointerException e) {
            out.println("<p style='color:red;'>Invalid input. Please enter valid numbers.</p>");
        }

        out.println("<form action='index.html' method='get'>");
        out.println("<button type='submit'>Calculate Again</button>");
        out.println("</form>");

        out.println("</body></html>");
    }
}
