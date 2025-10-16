package Lesson6;

import lombok.Cleanup;

import java.util.Scanner;

/**
 * author Shohjahon
 * version 1.1
 */

public class App {
    public static void main( String[] args ) {
        SeatManager manager = new SeatManager();
        @Cleanup Scanner scanner = new Scanner( System.in );
        int choice;

        do {
            System.out.println( "\n=== Airline Booking System ===" );
            System.out.println( "1. View all seats" );
            System.out.println( "2. Reserve a seat" );
            System.out.println( "3. Pay for a seat" );
            System.out.println( "4. Cancel reservation" );
            System.out.println( "5. View reservation by seat number" );
            System.out.println( "6. Exit" );
            System.out.print( "Enter your choice: " );

            try {
                choice = Integer.parseInt( scanner.nextLine() );
            } catch ( NumberFormatException e ) {
                System.out.println( "Invalid input! Enter a number 1–6." );
                choice = 0;
            }

            switch ( choice ) {
                case 1 -> manager.viewAllSeats();
                case 2 -> {
                    System.out.print( "Enter seat number (e.g., S5): " );
                    String seatNumber = scanner.nextLine().trim().toUpperCase();
                    System.out.print( "Enter passenger name: " );
                    String name = scanner.nextLine().trim();
                    manager.reserveSeat( seatNumber, name );
                }
                case 3 -> {
                    System.out.print( "Enter seat number to pay: " );
                    String seatNumber = scanner.nextLine().trim().toUpperCase();
                    manager.payForSeat( seatNumber );
                }
                case 4 -> {
                    System.out.print( "Enter seat number to cancel: " );
                    String seatNumber = scanner.nextLine().trim().toUpperCase();
                    manager.cancelReservation( seatNumber );
                }
                case 5 -> {
                    System.out.print( "Enter seat number to view: " );
                    String seatNumber = scanner.nextLine().trim().toUpperCase();
                    manager.viewReservation( seatNumber );
                }
                case 6 -> System.out.println( "Goodbye!" );
                default -> System.out.println( "Invalid option. Try again." );
            }
        } while ( choice != 6 );
    }
}
