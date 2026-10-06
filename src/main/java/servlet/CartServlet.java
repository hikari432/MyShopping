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

import dao.ProductDAO;
import model.CartItem;
import model.Product;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productId = request.getParameter("productId");
        String deleteProductId = request.getParameter("deleteProductId");
        String quantityParameter = request.getParameter("quantity");

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        // 削除ボタンが押された場合
        if (deleteProductId != null) {

            int id = Integer.parseInt(deleteProductId);

            for (int i = 0; i < cart.size(); i++) {

                if (cart.get(i).getProduct().getId() == id) {

                    cart.remove(i);

                    break;
                }
            }

        } else if (productId != null) {

            // カートに商品を追加する場合
            int id = Integer.parseInt(productId);

            int quantity = Integer.parseInt(quantityParameter);

            ProductDAO dao = new ProductDAO();

            Product product = dao.findById(id);

            boolean found = false;

            for (CartItem item : cart) {

                if (item.getProduct().getId() == id) {

                    item.setQuantity(
                            item.getQuantity() + quantity
                    );

                    found = true;

                    break;
                }
            }

            if (!found) {

                CartItem item =
                        new CartItem(product, quantity);

                cart.add(item);
            }
        }

        session.setAttribute("cart", cart);

        response.sendRedirect("CartServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<CartItem> cart =
                (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        request.setAttribute("cart", cart);

        request.getRequestDispatcher("/cart.jsp")
               .forward(request, response);
    }
}