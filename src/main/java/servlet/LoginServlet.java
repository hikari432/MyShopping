package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        UserDAO dao = new UserDAO();

        User user =
                dao.findByUsernameAndPassword(username, password);

        if (user != null) {

            HttpSession session =
                    request.getSession();

            session.setAttribute("user", user);

            response.sendRedirect("CategoryListServlet");

        } else {

            response.sendRedirect("login.jsp");
        }
    }
}
