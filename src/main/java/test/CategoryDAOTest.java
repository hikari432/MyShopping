package test;

import java.util.List;

import dao.CategoryDAO;
import model.Category;

public class CategoryDAOTest {

    public static void main(String[] args) {

        CategoryDAO dao = new CategoryDAO();

        List<Category> categories = dao.findAll();

        for (Category category : categories) {

            System.out.println(category.getId());
            System.out.println(category.getCategoryName());

        }
    }
}
