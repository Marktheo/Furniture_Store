package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Identity;
import model.Register;

public class IdentityDAO {
	
	public static String updateIdentity(String fName, String lName, String birthday, String sex, String cpf, String email) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnector.getConnection();
		
		//Strings SQL
		String sql_id = "SELECT idReg FROM register WHERE email=?";
		String sql_user = "UPDATE identity SET fName=?, lName=?, bDate=?, sex=?, cpf=? WHERE id=?";
		String sql_reg = "UPDATE register SET email=? WHERE idReg=?";

		//Prepared Statements
		PreparedStatement ps_id = (PreparedStatement) connection.prepareStatement(sql_id);
		PreparedStatement ps_user = (PreparedStatement) connection.prepareStatement(sql_user);
		PreparedStatement ps_reg = (PreparedStatement) connection.prepareStatement(sql_reg);
		
		//Variables
		String Id = new String();
		
		// Error Message
		String message = "Error:";
		String errors = "";

		// Verify If Null or Empty
		if (fName == null || fName == "") {
			errors = errors + " Inválid First Name";
		} else if (lName == null || lName == "") {
			errors = errors + " Inválid Last Name";
		} else if (birthday == null || birthday == "") {
			errors = errors + " Inválid Birthday";
		} else if (sex == null || sex == "") {
			errors = errors + " Inválid Sex";
		} else if (cpf == null || cpf == "") {
			errors = errors + " Inválid Cpf";
		} else if (email == null || email == "") {
			errors = errors + " Inválid E-mail";
		} else {
			errors = null;
			message = null;
			ps_id.setString(1, email);
			ps_id.execute();
			ResultSet rs_id = ps_id.executeQuery();
			if (rs_id.next()) {
				Id = rs_id.getString("idReg");
			}
			ps_user.setString(1, fName);
			ps_user.setString(2, lName);
			ps_user.setString(3, birthday);
			ps_user.setString(4, sex);
			ps_user.setString(5, cpf);
			ps_user.setString(6, Id);
			ps_user.execute();
			
			ps_reg.setString(1, email);
			ps_reg.setString(2, Id);
			ps_reg.execute();
			
			ps_id.close();
			rs_id.close();
			ps_user.close();
			ps_reg.close();
	}
	if (errors != null) {
		message = message + errors;
	}
	connection.close();
	return message;
	}
	
	public static String deleteIdentity(String fName, String lName, String birthday, String sex, String cpf, String email) throws SQLException, ClassNotFoundException {
		Connection connection = SqlConnector.getConnection();
		
		//Strings SQL
		String sql_id = "SELECT idReg FROM register WHERE email=?";
		String sql_user = "DELETE FROM identity WHERE id=?";
		String sql_reg = "DELETE FROM register WHERE idReg=?";

		//Prepared Statements
		PreparedStatement ps_id = (PreparedStatement) connection.prepareStatement(sql_id);
		PreparedStatement ps_user = (PreparedStatement) connection.prepareStatement(sql_user);
		PreparedStatement ps_reg = (PreparedStatement) connection.prepareStatement(sql_reg);
		
		//Variables
		String Id = new String();
		
		// Error Message
		String message = "Error:";
		String errors = "";

		// Verify If Null or Empty
		if (fName == null || fName == "") {
			errors = errors + " Inválid First Name";
		} else if (lName == null || lName == "") {
			errors = errors + " Inválid Last Name";
		} else if (birthday == null || birthday == "") {
			errors = errors + " Inválid Birthday";
		} else if (sex == null || sex == "") {
			errors = errors + " Invalid Sex";
		} else if (cpf == null || cpf == "") {
			errors = errors + " Inválid Cpf";
		} else if (email == null || email == "") {
			errors = errors + " Invalid E-mail";
		} else {
			errors = null;
			message = null;
			ps_id.setString(1, email);
			ps_id.execute();
			ResultSet rs_id = ps_id.executeQuery();
			if (rs_id.next()) {
				Id = rs_id.getString("idReg");
			}
			ps_user.setString(1, Id);
			ps_user.execute();
			
			ps_reg.setString(1, Id);
			ps_reg.execute();
			
			ps_id.close();
			rs_id.close();
			ps_user.close();
			ps_reg.close();
	}
	if (errors != null) {
		message = message + errors;
	}
	connection.close();
	return message;
	}
}
