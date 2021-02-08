import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(
        name = "registrationservlet",
        urlPatterns = "/registration"
)

public class Registration extends HttpServlet{
    private ArrayList<Account> lisOfAccounts = new ArrayList<>();

    Login logIn = new Login();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;cha" + "rset=UTF-8");
        try(PrintWriter out = resp.getWriter()){
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            Account testAcc = new Account(username, password);
            logIn.regisrtationFunc(testAcc);
            out.println("Registration was successfully");
            resp.sendRedirect("home.jsp");

        }
    }
}
