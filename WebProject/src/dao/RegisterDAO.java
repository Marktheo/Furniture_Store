package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.Identity;

public class RegisterDAO {
	// Create Register Method
	public static String createRegister(String fName, String lName, String birthday, String sex, String cpf, String email, String keyword) throws ClassNotFoundException, SQLException {
		Connection connection = dao.SqlConnector.getConnection();

		// Strings SQL
		String sql_identity = "INSERT INTO identity (fName, lName, bDate, sex, cpf)  values (?, ?, ?, ?, ?);";
		String sql_register = "INSERT INTO register (email, keyword, regDate)  values (?, ?, current_date());";
		String sql_verif_cpf = "SELECT cpf FROM identity WHERE cpf=?";
		String sql_verif_email = "SELECT email FROM register WHERE email=?";

		// Prepared Statements
		PreparedStatement ps_id = (PreparedStatement) connection.prepareStatement(sql_identity);
		PreparedStatement ps_rg = (PreparedStatement) connection.prepareStatement(sql_register);
		PreparedStatement ps_v1 = (PreparedStatement) connection.prepareStatement(sql_verif_cpf);
		PreparedStatement ps_v2 = (PreparedStatement) connection.prepareStatement(sql_verif_email);

		// Find Existing CPF
		String Cpf = null;
		ps_v1.setString(1, cpf);
		ps_v1.execute();
		ResultSet rs_v1 = ps_v1.executeQuery();
		if (rs_v1.next()) {
			Cpf = rs_v1.getString("cpf");
		}
		ps_v1.close();
		rs_v1.close();

		// Find Existing Email
		String Email = null;
		ps_v2.setString(1, email);
		ps_v2.execute();
		ResultSet rs_v2 = ps_v2.executeQuery();
		if (rs_v2.next()) {
			Email = rs_v2.getString("email");
		}
		ps_v2.close();
		rs_v2.close();

		// Error Message
		String message = "Error:";
		String errors = "";

		// Verify If Null or Empty
		if (fName == null || fName == "") {
			errors = errors + " Invalid First Name ";
		} else if (lName == null || lName == "") {
			errors = errors + " Invalid Last Nome";
		} else if (birthday == null || birthday == "") {
			errors = errors + " Invalid Birthday";
		} else if (sex == null || sex == "") {
			errors = errors + " Invalid Sex";
		} else if (cpf == null || cpf == "") {
			errors = errors + " Invalid Cpf";
		} else if (email == null || email == "") {
			errors = errors + " Invalid E-mail";
		} else if (keyword == null || keyword == "") {
			errors = errors + " Invalid Password";
		} else {
			// Verify If Exists
			if (Cpf != null && Cpf != "") {
				errors = errors + " Cpf Already Exists";
			} else if (Email != null) {
				errors = errors + " E-mail Already Exists";
			} else {
				// Set Message as Successful
				errors = null;
				message = "Account Generated Successfully";

				// Execute Register Creation
				ps_id.setString(1, fName);
				ps_id.setString(2, lName);
				ps_id.setString(3, birthday);
				ps_id.setString(4, sex);
				ps_id.setString(5, cpf);
				ps_id.execute();
				ps_id.close();

				ps_rg.setString(1, email);
				ps_rg.setString(2, keyword);
				ps_rg.execute();
				ps_rg.close();
			}
		}
		if (errors != null) {
			message = message + errors;
		}
		connection.close();
		return message;
	}

	// Read Register Method
	public static Identity readRegister(String email, String keyword) throws ClassNotFoundException, SQLException {
		Connection connection = SqlConnector.getConnection();

		// Strings SQL
		String sql_email = "SELECT email FROM register WHERE email=?";
		String sql_key = "SELECT keyword FROM register WHERE email=?";
		
		String sql_id = "SELECT idReg FROM register WHERE email=?";
		String sql_user = "SELECT fName, lName, bDate, sex, cpf FROM identity WHERE id=?";

		// Prepared Statements
		PreparedStatement ps_email = (PreparedStatement) connection.prepareStatement(sql_email);
		PreparedStatement ps_key = (PreparedStatement) connection.prepareStatement(sql_key);
		
		PreparedStatement ps_id = (PreparedStatement) connection.prepareStatement(sql_id);
		PreparedStatement ps_user = (PreparedStatement) connection.prepareStatement(sql_user);

		// Find Existing Email
		String Email = null;
		ps_email.setString(1, email);
		ps_email.execute();
		ResultSet rs_email = ps_email.executeQuery();
		if (rs_email.next()) {
			Email = rs_email.getString("email");
		}

		// Variables
		String Keyword = new String();
		//ArrayList <String> profile = new ArrayList<>();
		Identity identity = new Identity();
		String Id = new String();
		
		// Verify If Null or Empty
		if (Email == null || Email == "") {
			identity.setState("Error: Invalid E-mail");
		} else if (keyword == null || keyword == "") {
			identity.setState("Error: Invalid Password");
		} else {
			// Execute Login Process
			rs_email = ps_email.executeQuery();
			if (rs_email.next()) {
				ps_key.setString(1, email);
				ps_key.execute();
				ResultSet rs_key = ps_key.executeQuery();
				while (rs_key.next()) {
					Keyword = rs_key.getString("keyword");
				}
				if (keyword.equals(Keyword)) {
					ps_id.setString(1, email);
					ps_id.execute();
					ResultSet rs_id = ps_id.executeQuery();
					if (rs_id.next()) {
						Id = rs_id.getString("idReg");
					}
					ps_user.setString(1, Id);
					ps_user.execute();
					ResultSet rs_user = ps_user.executeQuery();
					if (rs_user.next()) {
						identity.setState("Account Logged Successfully");
						identity.setfName(rs_user.getString("fName"));
						identity.setlName(rs_user.getString("lName"));
						identity.setbDate(rs_user.getString("bDate"));
						identity.setSex(rs_user.getString("sex"));
						identity.setCpf(rs_user.getString("cpf"));
					}
					ps_id.close();
					rs_id.close();
					ps_user.close();
					rs_user.close();
				} else {
					identity.setState("Error: Wrong E-mail or Password");
				}
				ps_key.close();
				rs_key.close();
				ps_email.close();
				rs_email.close();
			}
		}
		connection.close();
		return identity;
	}

	// Update Register Method
	public static String updateRegister(String keyword, String email) throws ClassNotFoundException, SQLException {
		Connection connection = SqlConnector.getConnection();
		
		//Strings SQL
		String sql = "UPDATE register SET keyword=? WHERE email=?";
		String sql_email = "SELECT email FROM register WHERE email=?";
		
		//Prepared Statements
		PreparedStatement ps_email = (PreparedStatement) connection.prepareStatement(sql_email);
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		
		// Find Existing Email
		String Email = null;
		ps_email.setString(1, email);
		ps_email.execute();
		ResultSet rs_email = ps_email.executeQuery();
		if (rs_email.next()) {
			Email = rs_email.getString("email");
		}
		
		//Variables
		String message = "Error:";
		String errors = "";
		
		// Verify If Null or Empty
		if (Email == null || Email == "") {
			errors = errors + " Invalid E-mail";
		} else if (keyword == null || keyword == "") {
			errors = errors + " Invalid Password";
		} else {
			errors = null;
			message = null;
			ps.setString(1, keyword);
			ps.setString(2, email);
			ps.execute();
		}
		if (errors != null) {
			message = message + errors;
		}
		ps_email.close();
		rs_email.close();	
		ps.close();
		connection.close();
		return message;
	}
}
