package com.algerage.search.domain.model;

public record BookingMessageAck (String clientId, String date, String time, String court, boolean result, String message) {
    public BookingMessageAck (final BookingMessage bookingMessage, final boolean result, final String message) {
        this(bookingMessage.clientId(), bookingMessage.date(), bookingMessage.timeSlotId(), bookingMessage.courtId(), result, message);
    }
}
