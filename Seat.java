package Lesson7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String seatNumber;
    private String seatClass;
    private SeatStatus status;
    private String passengerName;
    private LocalDateTime bookingTime;
    private LocalDateTime flightDeparture;

    public void reserve( String name ) {
        this.passengerName = name;
        this.status = SeatStatus.BOOKED;
        this.bookingTime = LocalDateTime.now();
    }

    public void pay() {
        this.status = SeatStatus.PAID;
    }

    public void cancel() {
        this.passengerName = "";
        this.status = SeatStatus.AVAILABLE;
        this.bookingTime = null;
    }

    public boolean isExpired() {
        if ( status == SeatStatus.BOOKED && bookingTime != null ) {
            return bookingTime.plusMinutes( 24 ).isBefore( LocalDateTime.now() );
        }
        return false;
    }

    @Override
    public String toString() {
        String bookingInfo = (bookingTime != null)
                ? bookingTime.format( DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" ) )
                : "-";
        String flightInfo = (flightDeparture != null)
                ? flightDeparture.format( DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" ) )
                : "-";
        return String.format( "%-5s | %-10s | %-9s | %-15s | %-16s | %-16s",
                seatNumber,
                seatClass,
                status,
                passengerName.isEmpty() ? "-" : passengerName,
                bookingInfo,
                flightInfo );
    }
}
