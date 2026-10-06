package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.SubCategoryDAO;
import model.SubCategory;

@WebServlet("/SubCategoryListServlet")
public class SubCategoryListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String categoryId = request.getParameter("categoryId");
        
        request.setAttribute("categoryId", categoryId);

        SubCategoryDAO dao = new SubCategoryDAO();

        List<SubCategory> subCategories =
                dao.findByCategoryId(Integer.parseInt(categoryId));

        request.setAttribute("subCategories", subCategories);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/subCategory.jsp");

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}