package inheritancepolymorphism.entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthSpending() {
		return healthExpenditures;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthExpenditures = healthSpending;
	}

	@Override
	public final double tax() {
		return (super.getAnnualIncome() * (super.getAnnualIncome() < 20000 ? 15 : 25) / 100)
				- (healthExpenditures > 0 ? healthExpenditures / 2 : 0);
	}
}
