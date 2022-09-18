package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
	public static String readProduct(String pName) throws ClassNotFoundException, SQLException{
		Connection connection = SqlConnector.getConnection();
		
		String sql = "SELECT pName, material FROM product WHERE pName=?";
		
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		
		String material = null;
		
		ps.setString(1, pName);
		ps.execute();
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			pName = rs.getString("pName");
			material = rs.getString("material");
		}
		
		String description = pName + " - " + material;
		
		ps.close();
		rs.close();
		connection.close();
		return description;
	}
}
