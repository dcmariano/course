package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exceptions.DBException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection con;

	public DepartmentDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Department department) {
		StringBuilder insert = new StringBuilder();
		insert.append("INSERT INTO department ");
		insert.append("(Name) ");
		insert.append("VALUES (?) ");

		try (PreparedStatement pst = con.prepareStatement(insert.toString(), Statement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, department.getName());

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected < 0) {
				throw new DBException("Unexpected error! No rows affected!");
			}

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				department.setId(id);
			}

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}

	}

	@Override
	public void update(Department department) {
		StringBuilder update = new StringBuilder();
		update.append("UPDATE department ");
		update.append("SET Name = ? ");
		update.append("WHERE Id = ?");

		try (PreparedStatement pst = con.prepareStatement(update.toString())) {
			pst.setString(1, department.getName());
			pst.setInt(2, department.getId());
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

	@Override
	public void deleteById(Integer id) {
		StringBuilder delete = new StringBuilder();
		delete.append("DELETE FROM department ");
		delete.append("WHERE Id = ?");

		try (PreparedStatement pst = con.prepareStatement(delete.toString())) {
			pst.setInt(1, id);

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}

	}

	@Override
	public Department findById(Integer id) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT ");
		query.append("    * ");
		query.append("FROM ");
		query.append("    department ");
		query.append("WHERE ");
		query.append("    Id = ? ");

		try (PreparedStatement pst = con.prepareStatement(query.toString())) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					Department department = instantiateDepartment(rs);
					return department;
				}
				return null;
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

	@Override
	public List<Department> findAll() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT ");
		query.append("    * ");
		query.append("FROM ");
		query.append("    department ");
		query.append("ORDER BY Name");

		List<Department> departments = new ArrayList<>();

		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query.toString())) {

			while (rs.next()) {
				Department department = instantiateDepartment(rs);
				departments.add(department);
			}
			return departments;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("Id"));
		department.setName(rs.getString("Name"));
		return department;
	}

}
