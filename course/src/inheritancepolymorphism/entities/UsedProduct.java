package inheritancepolymorphism.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private Date manufactureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public final String priceTag() {
		return super.getName() + " (used) $" + String.format("%.2f", super.getPrice()) + " (Manufacture date: "
				+ formatterDate(manufactureDate) + ")";
	}

	private String formatterDate(Date date) {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		return fmt.format(date);
	}
}
