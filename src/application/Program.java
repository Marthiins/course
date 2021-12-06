package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); // entrar data formato de texto e vai ser convertido por date
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);// Instanciar da classe Reservation
			System.out.println("Reservation: " + reservation);// Mostrar dado da Reserva

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());// entrar data formato de texto e vai ser convertido por date
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);// atualizar reserva
			System.out.println("Reservation: " + reservation);// Mostrar dado da Reserva
		} catch (ParseException e) { //Excessão que sei que pode acontecer
			System.out.println("Invalid date format");
		}
		catch (DomainExceptions e) { //Excessão personalizada
			System.out.println("Error in reservation: " + e.getMessage());
			
		}
		catch(RuntimeException e) {//Tipo de excessão generica msg generica
			System.out.println("Unexpected error");
			
		}
		sc.close();

	}
}
