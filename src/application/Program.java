package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); // entrar data formato de texto e vai ser convertido por date
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {// Instanciar minha reserva, testar data depois do check-in
			System.out.println("Error in reservation: Check-out date must be after check-in date");

		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);// Instanciar da classe Reservation
			System.out.println("Reservation: " + reservation);// Mostrar dado da Reserva

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());// entrar data formato de texto e vai ser convertido por date
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {// se a data de check-in e checkout for antes que agora
																// não aceitar
				System.out.println("Error in reservation: Reservation dates for update must be future dates ");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {

				reservation.updateDates(checkIn, checkOut);// atualizar reserva
				System.out.println("Reservation: " + reservation);// Mostrar dado da Reserva
			}
		}
		
		sc.close();

	}

}
