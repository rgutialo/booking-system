package com.algerage.booking.infraestructure.adapter.in;

import com.algerage.booking.application.port.in.AvailabilityBookingUseCasePort;
import com.algerage.booking.application.port.out.*;
import com.algerage.booking.domain.model.*;
import com.algerage.booking.domain.services.BookingSlotGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AvailabilityBookingUseCaseAdapter implements AvailabilityBookingUseCasePort {

    private final BookingSlotGenerator bookingSlotGenerator;
    private final BlockedTimesPort blockedTimesPort;
    private final BookedTimesPort bookedTimesPort;
    private final ServicePort servicePort;
    private final ClientPort clientPort;
    private final BusinessHoursPort businessHoursPort;

    @Override
    public List<BookingAvailableSlot> bookAvailability(AvailabilityBookingRequest availabilityBookingRequest) throws Exception {

        Client client = clientPort.obtainClient(availabilityBookingRequest.getClientId())
                .stream().findAny()
                .orElseThrow();

        LocalDate date = availabilityBookingRequest.getDate();

        com.algerage.booking.domain.model.Service service = servicePort.getServiceById(availabilityBookingRequest.getServiceId())
                .stream().findAny().orElseThrow();

        BusinessHours businessHours = businessHoursPort.getBusinessHours(service, date).stream().findAny().orElseThrow();

        List<BlockedTimes> blockedTimes = blockedTimesPort.getBlockedTimes(client, service, date);
        List<Booking> bookedTimes = bookedTimesPort.getBookedTimes(client, service, date);

        return bookingSlotGenerator.calculateAvailableSlots(service, date, businessHours, blockedTimes, bookedTimes);
    }
}
