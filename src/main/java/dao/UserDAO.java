package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO {

	private static final String URL =
	        "jdbc:h2:tcp://localhost/~/MyShopping";

	private static final String USER = "sa";

	private static final String PASSWORD = "";
    
    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // ユーザーを登録する
    public void insert(User user) {

        String sql =
                "INSERT INTO USERS (USERNAME, PASSWORD) " +
                "VALUES (?, ?)";

        try (
            Connection conn =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps =
                    conn.prepareStatement(sql);
        ) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ps.executeUpdate();

            System.out.println("ユーザー登録成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ユーザー名とパスワードでユーザーを検索する
    public User findByUsernameAndPassword(
            String username, String password) {

        User user = null;

        String sql =
                "SELECT * FROM USERS " +
                "WHERE USERNAME = ? AND PASSWORD = ?";

        try (
            Connection conn =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps =
                    conn.prepareStatement(sql);
        ) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setId(rs.getInt("ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
