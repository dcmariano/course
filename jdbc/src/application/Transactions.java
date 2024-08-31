package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import exceptions.DBException;

public class Transactions {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;

		try {
			con = DB.getConnection();

			con.setAutoCommit(false);

			st = con.createStatement();

			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

			int x = 1;
			if (x == 1) {
				throw new DBException("Fake error");
			}
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			System.out.println("rows1: " + rows1);
			System.out.println("rows2: " + rows2);

		} catch (SQLException e) {
			try {
				con.rollback();
				throw new DBException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DBException("Error trying to rollback! Caused by: " + e.getMessage());

			}
		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}
	}

}
