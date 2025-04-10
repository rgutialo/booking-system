package com.algerage.booking.infraestructure.adapter.in.rest;

import com.algerage.booking.application.port.in.AvailabilityBookingUseCasePort;
import com.algerage.booking.application.port.in.RandomGeneratorPort;
import com.algerage.booking.domain.model.Booking;
import com.algerage.booking.domain.model.BookingAvailableSlot;
import com.algerage.booking.infraestructure.adapter.in.AvailabilityBookingRequest;
import com.algerage.booking.infraestructure.adapter.in.dto.BookingRequest;
import com.algerage.booking.infraestructure.adapter.in.mappers.BookingAvailableSlotResponseMapper;
import com.algerage.booking.infraestructure.adapter.in.mappers.BookingMapper;
import com.algerage.booking.infraestructure.adapter.out.rest.dto.BookingAvailableSlotResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/booking")
@AllArgsConstructor
public class BookingController {

    private final RandomGeneratorPort randomGenerator;
    private final BookingMapper bookingMapper;
    private final AvailabilityBookingUseCasePort availabilityBookingUseCasePort;
    private final BookingAvailableSlotResponseMapper bookingAvailableSlotResponseMapper;

    @GetMapping
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Booking. Random result: " + randomGenerator.generateRandomNumber());
    }

    @PostMapping("/request")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<String> bookingRequest(@RequestBody final BookingRequest bookingRequest) {
        Booking booking = bookingMapper.createModelFromRequest(bookingRequest);

        return ResponseEntity.ok("Request done in booking service");
    }

    @GetMapping("/availability")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<List<BookingAvailableSlotResponse>> obtainAvailableSlots(@Param("clientId") final Long clientId, @Param("serviceId") final Long serviceId, @Param("date") final String date) throws Exception {
        final AvailabilityBookingRequest availabilityBookingRequest = AvailabilityBookingRequest.builder()
                .clientId(clientId)
                .serviceId(serviceId)
                .date(LocalDate.now())
                .build();
        List<BookingAvailableSlot> bookingAvailableSlots = availabilityBookingUseCasePort.bookAvailability(availabilityBookingRequest);
        List<BookingAvailableSlotResponse> bookingAvailableResponse = bookingAvailableSlots.stream()
                .map(bookingAvailableSlotResponseMapper::createResponseFromModel).toList();
        return ResponseEntity.ok(bookingAvailableResponse);
    }
}
