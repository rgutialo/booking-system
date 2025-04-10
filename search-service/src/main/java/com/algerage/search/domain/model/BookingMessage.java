package com.algerage.search.domain.model;

public record BookingMessage(String clientId,
                             String userId,
                             String date,
                             String timeSlotId,
                             String courtId) {}
