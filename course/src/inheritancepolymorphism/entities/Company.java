package inheritancepolymorphism.entities;

public class Company extends TaxPayer {

	private Integer numberOfEmployees;

	public Company() {

	}

	public Company(String name, Double annualIncome, Integer numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public final double tax() {
		return super.getAnnualIncome() * (numberOfEmployees > 10 ? 14 : 16) / 100;
	}

}
