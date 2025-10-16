package Lesson6;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class SeatManager {
    private static final String DATA_FILE = "seats.dat";
    private ArrayList< Seat > seats;

    public SeatManager() {
        seats = new ArrayList<>();
        loadSeats();
    }

    private void initializeSeats() {
        for ( int i = 1; i <= 30; i++ ) {
            String seatClass = (i <= 10) ? "First" : (i <= 20) ? "Business" : "Economy";
            LocalDateTime flightDate = LocalDateTime.now().plusDays( 1 );
            seats.add( new Seat( "S" + i, seatClass, SeatStatus.AVAILABLE, "", null, flightDate ) );
        }
    }

    private void resetExpiredBookings() {
        for ( Seat seat : seats ) {
            if ( seat.isExpired() ) {
                seat.cancel();
            }
        }
    }

    public void viewAllSeats() {
        resetExpiredBookings();
        System.out.println( "\nSeat | Class      | Status    | Passenger       | Booked Time     | Flight Time" );
        System.out.println( "-------------------------------------------------------------------------------" );
        for ( Seat seat : seats ) {
            System.out.println( seat );
        }
    }

    public void reserveSeat( String seatNumber, String name ) {
        Seat seat = findSeat( seatNumber );
        if ( seat == null ) {
            System.out.println( "Seat not found!" );
            return;
        }
        if ( seat.getStatus() == SeatStatus.PAID ) {
            System.out.println( "Seat already paid for by " + seat.getPassengerName() );
            return;
        }
        if ( seat.getStatus() == SeatStatus.BOOKED && !seat.isExpired() ) {
            System.out.println( "Seat already booked by " + seat.getPassengerName() );
            return;
        }

        seat.reserve( name );
        saveSeats();
        System.out.println( "Seat " + seatNumber + " successfully reserved for " + name + "." );
    }

    public void payForSeat( String seatNumber ) {
        Seat seat = findSeat( seatNumber );
        if ( seat == null ) {
            System.out.println( "Seat not found!" );
            return;
        }
        if ( seat.getStatus() != SeatStatus.BOOKED ) {
            System.out.println( "Seat must be booked first before payment." );
            return;
        }
        seat.pay();
        saveSeats();
        System.out.println( "Seat " + seatNumber + " successfully paid for." );
    }

    public void cancelReservation( String seatNumber ) {
        Seat seat = findSeat( seatNumber );
        if ( seat == null ) {
            System.out.println( "Seat not found!" );
            return;
        }
        if ( seat.getStatus() == SeatStatus.AVAILABLE ) {
            System.out.println( "Seat is not currently booked." );
            return;
        }
        seat.cancel();
        saveSeats();
        System.out.println( "Reservation for seat " + seatNumber + " canceled." );
    }

    public void viewReservation( String seatNumber ) {
        resetExpiredBookings();
        Seat seat = findSeat( seatNumber );
        if ( seat == null ) {
            System.out.println( "Seat not found!" );
            return;
        }

        System.out.println( "\n--- Seat Details ---" );
        System.out.println( "Seat Number : " + seat.getSeatNumber() );
        System.out.println( "Class       : " + seat.getSeatClass() );
        System.out.println( "Status      : " + seat.getStatus() );
        System.out.println( "Passenger   : " + (seat.getPassengerName().isEmpty() ? "-" : seat.getPassengerName()) );
        System.out.println( "Booking Time: " + (seat.getBookingTime() != null ? seat.getBookingTime() : "-") );
        System.out.println( "Flight Time : " + seat.getFlightDeparture() );
    }

    private Seat findSeat( String seatNumber ) {
        for ( Seat seat : seats ) {
            if ( seat.getSeatNumber().equalsIgnoreCase( seatNumber ) ) {
                return seat;
            }
        }
        return null;
    }

    @SuppressWarnings( "unchecked" )
    private void loadSeats() {
        File file = new File( DATA_FILE );
        if ( !file.exists() ) {
            initializeSeats();
            saveSeats();
            return;
        }

        try ( ObjectInputStream ois = new ObjectInputStream( new FileInputStream( file ) ) ) {
            seats = ( ArrayList< Seat > ) ois.readObject();
            System.out.println( "Previous seat data loaded successfully." );
        } catch ( Exception e ) {
            System.out.println( "Error loading saved data. Reinitializing seats..." );
            initializeSeats();
        }
    }

    private void saveSeats() {
        try ( ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( DATA_FILE ) ) ) {
            oos.writeObject( seats );
        } catch ( IOException e ) {
            System.out.println( "Error saving seat data: " + e.getMessage() );
        }
    }
}
