package exceptionhandling.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationGoodSolution {

	private Integer roomNuber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ReservationGoodSolution() {

	}

	public ReservationGoodSolution(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new IllegalArgumentException("Check-out date must be after check-in date");
		}
		this.roomNuber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNuber() {
		return roomNuber;
	}

	public void setRoomNuber(Integer roomNuber) {
		this.roomNuber = roomNuber;
	}

	public Date getcheckIn() {
		return checkIn;
	}

	public void setcheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getcheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new IllegalArgumentException("Reservation dates for update must be future dates");
		} else if (!checkOut.after(checkIn)) {
			throw new IllegalArgumentException("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + roomNuber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}

}
