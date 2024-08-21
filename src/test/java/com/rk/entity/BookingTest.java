package com.rk.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;

public class BookingTest {

    @Test
    public void testBookingGettersAndSetters() {
        // Arrange
        Booking booking = new Booking();
        LocalDate today = LocalDate.now();

        // Set values
        booking.setId(1L);
        booking.setCheckInDate(today);
        booking.setCheckOutDate(today.plusDays(2));
        booking.setGuestName("John Doe");
        booking.setSpecialRequests("Late check-in");
        booking.setTotalPrice(200.0);
        booking.setBookingStatus("Confirmed");
        booking.setBookingDate(today);
        booking.setNumberOfGuests(2);
        booking.setPaymentMethod("Credit Card");
        booking.setConfirmationNumber("ABC123");

        // Assert
        assertThat(booking.getId()).isEqualTo(1L);
        assertThat(booking.getCheckInDate()).isEqualTo(today);
        assertThat(booking.getCheckOutDate()).isEqualTo(today.plusDays(2));
        assertThat(booking.getGuestName()).isEqualTo("John Doe");
        assertThat(booking.getSpecialRequests()).isEqualTo("Late check-in");
        assertThat(booking.getTotalPrice()).isEqualTo(200.0);
        assertThat(booking.getBookingStatus()).isEqualTo("Confirmed");
        assertThat(booking.getBookingDate()).isEqualTo(today);
        assertThat(booking.getNumberOfGuests()).isEqualTo(2);
        assertThat(booking.getPaymentMethod()).isEqualTo("Credit Card");
        assertThat(booking.getConfirmationNumber()).isEqualTo("ABC123");
    }
}
