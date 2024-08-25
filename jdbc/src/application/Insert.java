package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Insert {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			con = DB.getConnection();
			pst = con.prepareStatement(
					"INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, "Davi Cristian Mariano");
			pst.setString(2, "davi.fakedomain@fakedomain.com");
			pst.setDate(3, new java.sql.Date(sdf.parse("01/01/2000").getTime()));
			pst.setDouble(4, 5200.50);
			pst.setInt(5, 4);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				rs = pst.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! id=" + id);
				}
			} else {
				System.out.println("No rows affected");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeConnection();
			DB.closeStatement(pst);
			DB.closeResultSet(rs);

		}
	}

}
