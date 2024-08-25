package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Update {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pst = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			con = DB.getConnection();
			pst = con.prepareStatement(
					"UPDATE seller " 
					+ "SET BaseSalary = ?, " 
					+ "BirthDate = ? " 
					+ "WHERE Name LIKE ?",
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setDouble(1, 4000.00);
			pst.setDate(2, new java.sql.Date(sdf.parse("11/02/2001").getTime()));
			pst.setString(3, "%Davi%");

			int rowsAffected = pst.executeUpdate();
			pst.getGeneratedKeys();
			
			
			System.out.println("Rows affected " + rowsAffected);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeConnection();
			DB.closeStatement(pst);
		}
	}

}
