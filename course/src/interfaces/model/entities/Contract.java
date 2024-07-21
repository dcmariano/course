package interfaces.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

	private Integer number;
	private LocalDate date;
	private Double contractValue;

	private List<Installment> instalments = new ArrayList<>();

	public Contract() {

	}

	public Contract(Integer number, LocalDate date, Double contractValue) {
		this.number = number;
		this.date = date;
		this.contractValue = contractValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getContractValue() {
		return contractValue;
	}

	public void setContractValue(Double contractValue) {
		this.contractValue = contractValue;
	}

	public List<Installment> getInstalments() {
		return instalments;
	}

}
