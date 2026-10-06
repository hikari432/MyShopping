package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Category;


public class CategoryDAO {
	
	private static final String URL = "jdbc:h2:tcp://localhost/~/MyShopping";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	public List<Category> findAll() {

	    List<Category> categories = new ArrayList<>();
	    
	    String sql = "SELECT * FROM CATEGORY";
	    
	    try {
	        Class.forName("org.h2.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    
	    try (
	    	    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	    	) {
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ResultSet rs = ps.executeQuery();
	    	
	    	while (rs.next()) {
	    		
	    		Category category = new Category();
	    		
	    		 category.setId(rs.getInt("ID"));
	    		    category.setCategoryName(rs.getString("CATEGORY_NAME"));

	    		    categories.add(category);
             }
         }  catch (Exception e) {
             e.printStackTrace();
         }  
	    return categories;
   }

}
