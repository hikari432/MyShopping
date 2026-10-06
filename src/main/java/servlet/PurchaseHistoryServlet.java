package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PurchaseDAO;
import model.Purchase;

@WebServlet("/PurchaseHistoryServlet")
public class PurchaseHistoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        PurchaseDAO dao = new PurchaseDAO();

        List<Purchase> purchases = dao.findAll();

        request.setAttribute("purchases", purchases);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/purchaseHistory.jsp");

        dispatcher.forward(request, response);
    }
}
