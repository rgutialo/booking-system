package com.algerage.search.infraestructure.adapter.in.rest;

import com.algerage.search.application.port.in.RandomGeneratorPort;
import com.algerage.search.infraestructure.adapter.out.RequestBookingService;
import com.algerage.search.domain.model.BookingMessage;
import com.algerage.search.infraestructure.adapter.in.dto.BookingRequest;
import com.algerage.search.infraestructure.adapter.in.dto.BookingResponse;
import com.algerage.search.infraestructure.mappers.BookingMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    private final RandomGeneratorPort randomGenerator;
    private final BookingMapper bookingMapper;
    private final RequestBookingService requestBookingService;

    public SearchController(RandomGeneratorPort randomGenerator, BookingMapper bookingMapper, RequestBookingService requestBookingService) {
        this.randomGenerator = randomGenerator;
        this.bookingMapper = bookingMapper;
        this.requestBookingService = requestBookingService;
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Search. Random result: " + randomGenerator.generateRandomNumber());
    }

    @PostMapping
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<BookingResponse> bookRequestExample(@RequestBody final BookingRequest bookingRequest) {
        BookingMessage modelFromRequest = bookingMapper.createModelFromRequest(bookingRequest);
        requestBookingService.requestBooking(modelFromRequest);
        return ResponseEntity.accepted().body(null);
    }

    @PostMapping("/request")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<String> bookRequest(@RequestBody final BookingRequest bookingRequest) {
        BookingMessage modelFromRequest = bookingMapper.createModelFromRequest(bookingRequest);
        requestBookingService.requestRealBooking(modelFromRequest);
        return ResponseEntity.accepted().body(null);
    }
}
