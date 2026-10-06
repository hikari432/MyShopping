package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.PurchaseDAO;
import model.CartItem;
import model.User;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        String action = request.getParameter("action");

        // 購入を確定する場合
        if ("confirm".equals(action)) {

            PurchaseDAO dao = new PurchaseDAO();

            User user = (User) session.getAttribute("user");

            for (CartItem item : cart) {

                dao.insert(
                        item.getProduct(),
                        item.getQuantity(),
                        user.getId()
                );
            }

            // 購入後はカートを空にする
            cart.clear();

            session.setAttribute("cart", cart);

            request.getRequestDispatcher("/purchaseComplete.jsp")
                   .forward(request, response);

        } else {

            // 購入確認画面を表示する
            request.setAttribute("cart", cart);

            request.getRequestDispatcher("/purchaseConfirm.jsp")
                   .forward(request, response);
        }
    }
}