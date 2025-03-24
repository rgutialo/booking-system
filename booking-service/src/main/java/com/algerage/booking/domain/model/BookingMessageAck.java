package com.algerage.booking.domain.model;

public record BookingMessageAck (String clientId, String date, String time, boolean result, String message) {
    public BookingMessageAck (final BookingMessage bookingMessage, final boolean result, final String message) {
        this(bookingMessage.clientId(), bookingMessage.date(), bookingMessage.time(), result, message);
    }
}
