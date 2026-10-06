package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	String subCategoryId = request.getParameter("subCategoryId");
    	
    	String categoryId = request.getParameter("categoryId");

    	ProductDAO dao = new ProductDAO();

    	List<Product> products =
    	        dao.findBySubCategoryId(Integer.parseInt(subCategoryId));
    	
        System.out.println("商品件数：" + products.size());
        
        for (Product product : products) {
            System.out.println("商品名：" + product.getName());
        }

        request.setAttribute("products", products);
        
        request.setAttribute("categoryId", categoryId);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/productList.jsp");

        dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
