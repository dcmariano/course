package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import exceptions.DBException;

public class DB {
	private static Connection connection = null;

	public static Connection getConnection() {
		Properties props = loadProperties();
		String url = props.getProperty("dburl");
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}

		return connection;
	}

	public static void closeConnection() {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DBException(e.getMessage());
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
}
