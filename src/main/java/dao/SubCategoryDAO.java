package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.SubCategory;

public class SubCategoryDAO {

    private static final String URL = "jdbc:h2:tcp://localhost/~/MyShopping";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public List<SubCategory> findByCategoryId(int categoryId) {

        List<SubCategory> subCategories = new ArrayList<>();

        String sql = "SELECT * FROM SUB_CATEGORY WHERE CATEGORY_ID = ?";

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setInt(1, categoryId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SubCategory subCategory = new SubCategory();

                subCategory.setId(rs.getInt("ID"));
                subCategory.setCategoryId(rs.getInt("CATEGORY_ID"));
                subCategory.setSubCategoryName(
                        rs.getString("SUB_CATEGORY_NAME"));

                subCategories.add(subCategory);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subCategories;
    }
}