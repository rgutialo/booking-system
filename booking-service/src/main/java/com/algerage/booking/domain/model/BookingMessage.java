package com.algerage.booking.domain.model;

public record BookingMessage(String clientId,
                             String userId,
                             String date,
                             String timeSlotId,
                             String courtId,
                             String amount,
                             String currency,
                             String bookOrder,
                             String urlOK,
                             String urlKO) {}