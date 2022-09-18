package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class User {
	public static void Write(String nome, String sobrenome, String aniversario, String idade, String sexo, String cpf, String email, String senha) throws ClassNotFoundException, SQLException {
		Connection connection = SqlConnector.getConnection();
		String sql_ident = "INSERT INTO identify (fName, lName, bDate, age, sex, cpf)  values (?, ?, ?, ?, ?, ?);";
		String sql_regis = "INSERT INTO register (email, keyword, regDate, lastUpdt)  values (?, ?, current_date(), current_date());";
		PreparedStatement ps_id = (PreparedStatement) connection.prepareStatement(sql_ident);
		PreparedStatement ps_rg = (PreparedStatement) connection.prepareStatement(sql_regis);
		
		ps_id.setString(1, nome);
		ps_id.setString(2, sobrenome);
		ps_id.setString(3, aniversario);
		ps_id.setString(4, idade);
		ps_id.setString(5, sexo);
		ps_id.setString(6, cpf);
		ps_id.execute();
		ps_id.close();
		ps_rg.setString(1, email);
		ps_rg.setString(2, senha);
		ps_rg.execute();
		ps_rg.close();
		connection.close();
	}
	public static boolean Read(String email, String senha) throws ClassNotFoundException, SQLException {
		Connection connection = SqlConnector.getConnection();
		String sql_login = "select email from register WHERE email=?;";
		String Keyword = new String();
		boolean isCorrect = false;
		PreparedStatement ps_login = (PreparedStatement) connection.prepareStatement(sql_login);
		ps_login.setString(1, email);
		ps_login.execute();
		ResultSet rs_login = ps_login.executeQuery();
		if(rs_login.next()) {
			String sql_key = "select keyword from register WHERE email=?;";
			PreparedStatement ps_key = (PreparedStatement) connection.prepareStatement(sql_key);
			ps_key.setString(1,email);
			ps_key.execute();
			ResultSet rs_key = ps_key.executeQuery();
			while(rs_key.next())
				Keyword = rs_key.getString("keyword");
			if(senha.equals(Keyword)) {
				isCorrect = true;
			}
			else {
				isCorrect = false;
			}
			ps_key.close();
			rs_key.close();
		}
		else {
			isCorrect = false;
		}
		ps_login.close();
		rs_login.close();
		connection.close();
		return isCorrect;
	}


	public static void ReWrite(String senha, String email) throws ClassNotFoundException, SQLException {
		Connection connection = SqlConnector.getConnection();
		String sql = "UPDATE register SET keyword=? WHERE email=?;";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ps.setString(1, senha);
		ps.setString(2, email);
		ps.execute();
		ps.close();
		connection.close();
	}
}