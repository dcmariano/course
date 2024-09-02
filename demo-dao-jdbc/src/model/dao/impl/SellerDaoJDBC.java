package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.DBException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection con;

	public SellerDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Seller seller) {
		StringBuilder insert = new StringBuilder();
		insert.append("INSERT INTO seller ");
		insert.append("(Name, Email, BirthDate, BaseSalary, DepartmentId) ");
		insert.append("VALUES (?, ?, ?, ?, ?) ");

		try (PreparedStatement pst = con.prepareStatement(insert.toString(), Statement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, seller.getName());
			pst.setString(2, seller.getEmail());
			pst.setDate(3, new java.sql.Date(seller.getBirthDay().getTime()));
			pst.setDouble(4, seller.getBaseSalary());
			pst.setInt(5, seller.getDepartment().getId());

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected < 0) {
				throw new DBException("Unexpected error! No rows affected!");
			}

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				seller.setId(id);
			}

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

	@Override
	public void update(Seller seller) {
		StringBuilder update = new StringBuilder();
		update.append("UPDATE seller ");
		update.append("SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? ");
		update.append("WHERE Id = ?");

		try (PreparedStatement pst = con.prepareStatement(update.toString())) {
			pst.setString(1, seller.getName());
			pst.setString(2, seller.getEmail());
			pst.setDate(3, new java.sql.Date(seller.getBirthDay().getTime()));
			pst.setDouble(4, seller.getBaseSalary());
			pst.setInt(5, seller.getDepartment().getId());
			pst.setInt(6, seller.getId());

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer id) {
		StringBuilder delete = new StringBuilder();
		delete.append("DELETE FROM seller ");
		delete.append("WHERE Id = ?");

		try (PreparedStatement pst = con.prepareStatement(delete.toString())) {
			pst.setInt(1, id);

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

	@Override
	public Seller findById(Integer id) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT ");
		query.append("    s.*, ");
		query.append("    d.Name as DepName ");
		query.append("FROM ");
		query.append("    seller s ");
		query.append("INNER JOIN ");
		query.append("    department d ");
		query.append("    ON s.DepartmentId = d.Id ");
		query.append("WHERE ");
		query.append("    s.Id = ? ");

		try (PreparedStatement pst = con.prepareStatement(query.toString())) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					Department department = instantiateDepartment(rs);
					Seller seller = instantiateSeller(rs, department);
					return seller;
				}
				return null;
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setBirthDay(rs.getDate("BirthDate"));
		seller.setDepartment(department);
		return seller;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("DepartmentId"));
		department.setName(rs.getString("DepName"));
		return department;
	}

	@Override
	public List<Seller> findAll() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT ");
		query.append("    s.*, ");
		query.append("    d.Name as DepName ");
		query.append("FROM ");
		query.append("    seller s ");
		query.append("INNER JOIN ");
		query.append("    department d ");
		query.append("    ON s.DepartmentId = d.Id ");
		query.append("ORDER BY s.Name");

		List<Seller> sellers = new ArrayList<>();
		Map<Integer, Department> map = new HashMap<>();

		try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query.toString())) {

			while (rs.next()) {
				Department dep = map.get(rs.getInt("DepartmentId"));

				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(dep.getId(), dep);
				}
				Seller seller = instantiateSeller(rs, dep);
				sellers.add(seller);
			}
			return sellers;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT ");
		query.append("    s.*, ");
		query.append("    d.Name as DepName ");
		query.append("FROM ");
		query.append("    seller s ");
		query.append("INNER JOIN ");
		query.append("    department d ");
		query.append("    ON s.DepartmentId = d.Id ");
		query.append("WHERE ");
		query.append("    d.Id = ? ");
		query.append("ORDER BY s.Name");

		List<Seller> sellers = new ArrayList<>();
		Map<Integer, Department> map = new HashMap<>();

		try (PreparedStatement pst = con.prepareStatement(query.toString())) {
			pst.setInt(1, department.getId());
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					Department dep = map.get(rs.getInt("DepartmentId"));

					if (dep == null) {
						dep = instantiateDepartment(rs);
						map.put(dep.getId(), dep);
					}
					Seller seller = instantiateSeller(rs, dep);
					sellers.add(seller);
				}
				return sellers;
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}

}
