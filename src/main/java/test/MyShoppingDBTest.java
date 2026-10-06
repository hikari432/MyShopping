package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyShoppingDBTest {

    public static void main(String[] args) {

        String url = "jdbc:h2:~/MyShopping";

        try (Connection conn = DriverManager.getConnection(url, "sa", "")) {

            System.out.println("MyShopping DB作成・接続成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}