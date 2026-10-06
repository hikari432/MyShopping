package test;

import java.util.List;

import dao.ProductDAO;
import model.Product;

public class ProductDAOTest {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        List<Product> products = dao.findAll();

        for (Product product : products) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getCategory());
            System.out.println(product.getMemo());
        }
    }
}