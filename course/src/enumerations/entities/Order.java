package enumerations.entities;

import java.util.Date;

import enumerations.entities.enums.OrderStatus;

public class Order {

	private Integer id;
	private Date moment;
	private OrderStatus status;

	public Order() {

	}

	public Order(Integer id, Date moment, OrderStatus status) {
		this.id = id;
		this.moment = moment;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return moment;
	}

	public void setDate(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return status;
	}

	public void setOrderStatus(OrderStatus status) {
		this.status = status;
	}

	public String toString() {
	    return String.format("Order {%n\tid: %d%n\tmoment: %s%n\tstatus: %s%n}",
	            id, moment, status);
	}

}
