package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Select {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM city");
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
	}
}
