package com.substring.springbootapp.controller;

import com.substring.springbootapp.model.Booking;
import com.substring.springbootapp.model.BookingRequest;
import com.substring.springbootapp.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WelcomeController {
    private final BookingService bookingService;

    public WelcomeController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<Map<String, String>> welcome() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to the Ticket Booking Portal");
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return bookingService.findAll();
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request) {
        try {
            Booking booking = bookingService.createBooking(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(booking);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}

