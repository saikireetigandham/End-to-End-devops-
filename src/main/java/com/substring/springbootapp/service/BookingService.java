package com.substring.springbootapp.service;

import com.substring.springbootapp.model.Booking;
import com.substring.springbootapp.model.BookingRequest;
import com.substring.springbootapp.model.BookingStatus;
import com.substring.springbootapp.model.BookingType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookingService {
    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1L);

    public Booking createBooking(BookingRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Booking request is required");
        }
        if (request.getUserName() == null || request.getUserName().isBlank()) {
            throw new IllegalArgumentException("User name is required");
        }
        if (request.getBookingType() == null) {
            throw new IllegalArgumentException("Booking type is required");
        }
        if (request.getPassengers() <= 0) {
            throw new IllegalArgumentException("Passengers must be greater than zero");
        }
        if (request.getPaymentMethod() == null || request.getPaymentMethod().isBlank()) {
            throw new IllegalArgumentException("Payment method is required");
        }
        if (request.getPaymentReference() == null || request.getPaymentReference().isBlank()) {
            throw new IllegalArgumentException("Payment reference is required");
        }

        boolean urgentBooking = request.isUrgentBooking() && request.getBookingType() != BookingType.CAB;
        double totalPrice = calculatePrice(request.getBookingType(), request.getPassengers(), urgentBooking);
        long bookingId = sequence.getAndIncrement();
        String pnr = String.format("TRP%06d", bookingId);
        Booking booking = new Booking(
            bookingId,
                request.getUserName(),
                request.getBookingType(),
                request.getTitle(),
                request.getSource(),
                request.getDestination(),
                request.getDepartureDate(),
                request.getPassengers(),
                totalPrice,
                BookingStatus.CONFIRMED,
                pnr,
                "PAID",
                request.getPaymentReference(),
                urgentBooking
        );

        bookings.add(booking);
        return booking;
    }

    public List<Booking> findAll() {
        return bookings;
    }

    private double calculatePrice(BookingType bookingType, int passengers, boolean urgentBooking) {
        double baseRate = switch (bookingType) {
            case HOTEL -> 120.0;
            case FLIGHT -> 280.0;
            case TRAIN -> 90.0;
            case BUS -> 65.0;
            case CAB -> 35.0;
            case HOLIDAY -> 450.0;
        };
        double urgencyMultiplier = urgentBooking ? 1.25 : 1.0;
        return baseRate * passengers * urgencyMultiplier;
    }
}
