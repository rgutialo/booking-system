package com.algerage.search.infraestructure.adapter.in.dto;

public record BookingRequest(String clientId,
                             String userId,
                             String date,
                             String timeSlotId,
                             String courtId){

}

