package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import exceptions.DBIntegrityException;

public class Delete {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DB.getConnection();

			pst = con.prepareStatement(
					"DELETE FROM seller " 
					+ "WHERE "
					+ "Name = ?");
			
			pst.setString(1, "Davi Cristian Mariano");
			
			int rowsAffected = pst.executeUpdate();
			
			System.out.println("Done! Rows ffected " + rowsAffected);
		} catch (SQLException e) {
			throw new DBIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}
	}
}
