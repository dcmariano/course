package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println("Seller: " + seller);

		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(dep);
		sellers.forEach(System.out::println);

		System.out.println("\n=== Test 3: seller findAll ===");
		List<Seller> sellers2 = sellerDao.findAll();
		sellers2.forEach(System.out::println);

		System.out.println("\n=== Test 4: seller insert ===");
		Seller seller2 = new Seller(null, "Davi", "davi@fakedomain.com", new Date(), 2000.0, dep);
		sellerDao.insert(seller2);
		System.out.println("Inserted! New id= " + seller2.getId());

		System.out.println("\n=== Test 5: seller update ===");
		Seller seller3 = sellerDao.findById(10);
		seller3.setName("Davi Cristian Mariano");
		sellerDao.update(seller3);
		System.out.println("Update completed!");

		System.out.println("\n=== Test 5: seller deleteById ===");
		sellerDao.deleteById(10);
		System.out.println("Delete completed!");
		
		

		System.out.println("=== Test 6: department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println("Department: " + department);

		System.out.println("\n=== Test 7: department findAll ===");
		List<Department> departments = departmentDao.findAll();
		departments.forEach(System.out::println);

		System.out.println("\n=== Test 8: department insert ===");
		Department department2 = new Department(null, "Adm");
		departmentDao.insert(department2);
		System.out.println("Inserted! New id= " + department2.getId());

		System.out.println("\n=== Test 9: department update ===");
		Department department3 = departmentDao.findById(4);
		department3.setName("Accounting");
		departmentDao.update(department3);
		System.out.println("Update completed!");

		System.out.println("\n=== Test 10: department deleteById ===");
		departmentDao.deleteById(5);
		System.out.println("Delete completed!");
	}

}
