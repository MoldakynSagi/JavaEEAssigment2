import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(
        name = "loginservlet",
        urlPatterns = "/login"
)

public class Login extends HttpServlet{

    private ArrayList<Account> Accounts = new ArrayList<>();

    public void regisrtationFunc(Account account1){
        Accounts.add(account1);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        Account firstAcc = new Account("admin", "1234");
        Account secondAcc = new Account("user", "1234");
        Accounts.add(firstAcc);
        Accounts.add(secondAcc);
        try(PrintWriter out = resp.getWriter()){
            for(int i = 0; i < Accounts.size(); i++) {
                String username = req.getParameter("username");
                String password = req.getParameter("password");

                if (username != null && password != null) {
                    if (username.equals(Accounts.get(i).getUsername())) {
                        if (password.equals(Accounts.get(i).getPassword())) {
                            resp.sendRedirect("home.jsp");
                        } else {
                            out.println("Invalid password");
                        }
                    } else {
                        out.println("Invalid username");
                    }
                } else {
                    out.println("Please add the data");
                }
            }

        }
    }







}
