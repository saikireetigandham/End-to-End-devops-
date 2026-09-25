package com.substring.springbootapp.model;

import java.time.LocalDate;

public class Booking {
    private Long id;
    private String userName;
    private BookingType bookingType;
    private String title;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private int passengers;
    private double totalPrice;
    private BookingStatus status;
    private String pnr;
    private String paymentStatus;
    private String paymentReference;
    private boolean urgentBooking;

    public Booking() {
    }

    public Booking(Long id, String userName, BookingType bookingType, String title,
                   String source, String destination, LocalDate departureDate,
                   int passengers, double totalPrice, BookingStatus status) {
            this(id, userName, bookingType, title, source, destination, departureDate,
                passengers, totalPrice, status, null, null, null, false);
            }

            public Booking(Long id, String userName, BookingType bookingType, String title,
                   String source, String destination, LocalDate departureDate,
                   int passengers, double totalPrice, BookingStatus status,
                   String pnr, String paymentStatus, String paymentReference,
                   boolean urgentBooking) {
        this.id = id;
        this.userName = userName;
        this.bookingType = bookingType;
        this.title = title;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.passengers = passengers;
        this.totalPrice = totalPrice;
        this.status = status;
        this.pnr = pnr;
        this.paymentStatus = paymentStatus;
        this.paymentReference = paymentReference;
        this.urgentBooking = urgentBooking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public boolean isUrgentBooking() {
        return urgentBooking;
    }

    public void setUrgentBooking(boolean urgentBooking) {
        this.urgentBooking = urgentBooking;
    }
}
