package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// formata da Data

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;

	}

	public long duration() {// data vamos usar o long
		long diff = checkOut.getTime() - checkIn.getTime(); // criar a variavel vamos implementar diferença as datas em
															// milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// converter milesegundos para dia usar variavel
	}

	public void updateDates(Date checkIn, Date checkOut){
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {// se a data de check-in e checkout for antes que agoranão aceitar
			throw new DomainExceptions("Reservation dates for update must be future dates ") ;
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;// fazer checkIn do meu objeto receber o checkIn do meu do argumento do metodo
		this.checkOut = checkOut;
		
	}

	@Override
	public String toString() {
		return "Room " 
	+ roomNumber 
	+ ", check-in: " 
	+ sdf.format(checkIn) 
	+ ", check-out: " 
	+ sdf.format(checkOut)
	+ ", " 
	+ duration() 
	+ " nights";
	}

}