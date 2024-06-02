package introductionobjectorientation.util;

public class CurrencyConverter {

	public static final double DOLLAR_QUOTATION = 4.92;

	public static double converter(double quantityValue) {
		double total = quantityValue * DOLLAR_QUOTATION;
		return total = total + (total * 0.06);
	}

	public static double converter(double quotation, double quantityValue) {
		double total = quotation * quantityValue;
		return total = total + (total * 0.06);
	}

}
