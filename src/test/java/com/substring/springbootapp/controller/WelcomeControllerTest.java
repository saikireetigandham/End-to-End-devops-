package com.substring.springbootapp.controller;

import com.substring.springbootapp.service.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WelcomeControllerTest {

    private final WelcomeController controller = new WelcomeController(new BookingService());

    @Test
    void welcomeReturnsOkResponseWithExpectedMessage() {
        ResponseEntity<Map<String, String>> response = controller.welcome();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("success", response.getBody().get("status"));
        assertEquals("Welcome to the Ticket Booking Portal", response.getBody().get("message"));
    }
}
