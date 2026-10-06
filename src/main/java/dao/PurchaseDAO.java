package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Purchase;

public class PurchaseDAO {

    private static final String URL =
            "jdbc:h2:tcp://localhost/~/MyShopping";

    private static final String USER = "sa";

    private static final String PASSWORD = "";

    public void insert(Product product, int quantity, int userId) {

        String sql =
                "INSERT INTO PURCHASE " +
                "(PRODUCT_ID, PRODUCT_NAME, PRICE, PURCHASE_DATE, QUANTITY, USER_ID) " +
                "VALUES (?, ?, ?, ?,?,?)";

        try (
            Connection conn =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps =
                    conn.prepareStatement(sql);
        ) {

            ps.setInt(1, product.getId());

            ps.setString(2, product.getName());

            ps.setInt(3, product.getPrice());

            ps.setTimestamp(
                    4,
                    Timestamp.valueOf(LocalDateTime.now())
            );
            
            ps.setInt(5, quantity);
            
            ps.setInt(6, userId);

            ps.executeUpdate();

            System.out.println("購入履歴登録成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
       }
    public List<Purchase> findAll() {

        List<Purchase> purchases = new ArrayList<>();

        String sql =
                "SELECT * FROM PURCHASE ORDER BY PURCHASE_DATE DESC";

        try (
            Connection conn =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();
        ) {

            while (rs.next()) {

                Purchase purchase = new Purchase();

                purchase.setId(rs.getInt("ID"));
                purchase.setProductId(rs.getInt("PRODUCT_ID"));
                purchase.setProductName(rs.getString("PRODUCT_NAME"));
                purchase.setPrice(rs.getInt("PRICE"));
                
                purchase.setQuantity(rs.getInt("QUANTITY"));


                purchase.setPurchaseDate(
                        rs.getTimestamp("PURCHASE_DATE")
                          .toLocalDateTime()
                );

                purchases.add(purchase);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return purchases;
    }
    public List<Purchase> findByUserId(int userId) {

        List<Purchase> purchases = new ArrayList<>();

        String sql =
                "SELECT * FROM PURCHASE " +
                "WHERE USER_ID = ? " +
                "ORDER BY PURCHASE_DATE DESC";

        try (
            Connection conn =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps =
                    conn.prepareStatement(sql);
        ) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Purchase purchase = new Purchase();

                purchase.setId(rs.getInt("ID"));
                purchase.setProductId(rs.getInt("PRODUCT_ID"));
                purchase.setProductName(rs.getString("PRODUCT_NAME"));
                purchase.setPrice(rs.getInt("PRICE"));
                purchase.setQuantity(rs.getInt("QUANTITY"));

                purchase.setPurchaseDate(
                        rs.getTimestamp("PURCHASE_DATE")
                          .toLocalDateTime()
                );

                purchases.add(purchase);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return purchases;
    }
}
