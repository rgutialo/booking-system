package com.algerage.booking.domain.model;

public record BookingMessageAck (String clientId,
                                 String userId,
                                 String date,
                                 String timeSlotId,
                                 String courtId,
                                 String amount,
                                 String currency,
                                 String bookOrder,
                                 String urlOK,
                                 String urlKO,
                                 boolean result,
                                 String message) {
    public BookingMessageAck (final BookingMessage bookingMessage, final boolean result, final String message) {
        this(bookingMessage.clientId(), bookingMessage.userId(), bookingMessage.date(),
                bookingMessage.timeSlotId(), bookingMessage.courtId(), bookingMessage.amount(),
                bookingMessage.currency(), bookingMessage.bookOrder(), bookingMessage.urlOK(), bookingMessage.urlKO(), result, message);
    }
}
