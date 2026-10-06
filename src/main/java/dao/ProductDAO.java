package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Product;


public class ProductDAO {

    private static final String URL = "jdbc:h2:tcp://localhost/~/MyShopping";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    
    public void insert(Product product) {

        String sql = "INSERT INTO PRODUCT (ID, NAME, PRICE, CATEGORY, MEMO) VALUES (?, ?, ?, ?, ?)";

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql); ) {
        		
        		ps.setInt(1, product.getId());
        		ps.setString(2, product.getName());
        		ps.setInt(3, product.getPrice());
        		ps.setString(4, product.getCategory());
        		ps.setString(5, product.getMemo());

        		ps.executeUpdate();
        		
        		System.out.println("INSERT成功");
          }catch (Exception e) {
              e.printStackTrace();
         } 
    }
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();
        
        System.out.println("DB接続先：" + URL);
        
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM PRODUCT";

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                Product product = new Product();

                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setPrice(rs.getInt("PRICE"));
                product.setCategory(rs.getString("CATEGORY"));
                product.setMemo(rs.getString("MEMO"));

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
    
    public List<Product> findByCategoryId(int categoryId) {

        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM PRODUCT WHERE CATEGORY_ID = ?";

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

                Product product = new Product();

                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setPrice(rs.getInt("PRICE"));
                product.setCategory(rs.getString("CATEGORY"));
                product.setMemo(rs.getString("MEMO"));

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
    public List<Product> findBySubCategoryId(int subCategoryId) {

        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM PRODUCT WHERE SUB_CATEGORY_ID = ?";

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setInt(1, subCategoryId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product product = new Product();

                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setPrice(rs.getInt("PRICE"));
                product.setCategory(rs.getString("CATEGORY"));
                product.setMemo(rs.getString("MEMO"));

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
    public Product findById(int id) {

        Product product = null;

        String sql = "SELECT * FROM PRODUCT WHERE ID = ?";

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                product = new Product();

                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setPrice(rs.getInt("PRICE"));
                product.setCategory(rs.getString("CATEGORY"));
                product.setMemo(rs.getString("MEMO"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }
    
}