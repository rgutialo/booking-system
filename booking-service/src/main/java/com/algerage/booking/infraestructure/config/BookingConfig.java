package com.algerage.booking.infraestructure.config;

import com.algerage.booking.application.port.in.AvailabilityBookingUseCasePort;
import com.algerage.booking.application.port.in.RandomGeneratorPort;
import com.algerage.booking.application.port.out.*;
import com.algerage.booking.application.service.RandomGeneratorService;
import com.algerage.booking.domain.services.BookingHoursService;
import com.algerage.booking.domain.services.BookingSlotGenerator;
import com.algerage.booking.domain.services.BusinessHoursService;
import com.algerage.booking.domain.services.impl.BookingHoursServiceImpl;
import com.algerage.booking.domain.services.impl.BookingSlotGeneratorImpl;
import com.algerage.booking.domain.services.impl.BusinessHoursServiceImpl;
import com.algerage.booking.infraestructure.adapter.in.AvailabilityBookingUseCaseAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingConfig {

    @Bean
    public RandomGeneratorPort randomGeneratorPort() {
        return new RandomGeneratorService();
    }

    @Bean
    public BusinessHoursService businessHoursService() {
        return new BusinessHoursServiceImpl();
    }

    @Bean
    public BookingHoursService bookingHoursService() {
        return new BookingHoursServiceImpl();
    }

    @Bean
    public BookingSlotGenerator bookingSlotGenerator(final BookingHoursService bookingHoursService,
                                                     final BusinessHoursService businessHoursService) {
        return new BookingSlotGeneratorImpl(businessHoursService, bookingHoursService);
    }



    @Bean
    public AvailabilityBookingUseCasePort availabilityBookingUseCasePort(final BookingSlotGenerator bookingSlotGenerator,
                                                                         final BlockedTimesPort blockedTimesPort,
                                                                         final BookedTimesPort bookedTimesPort,
                                                                         final ServicePort servicePort,
                                                                         final ClientPort clientPort,
                                                                         final BusinessHoursPort businessHoursPort){
        return new AvailabilityBookingUseCaseAdapter(bookingSlotGenerator, blockedTimesPort,
                bookedTimesPort, servicePort, clientPort, businessHoursPort);
    }
}
