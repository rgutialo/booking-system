package com.algerage.booking.infraestructure.adapter.out;

import com.algerage.booking.application.port.out.BookedTimesPort;
import com.algerage.booking.domain.model.Booking;
import com.algerage.booking.domain.model.Client;
import com.algerage.booking.domain.model.Service;
import com.algerage.booking.infraestructure.adapter.in.mappers.BookingMapper;
import com.algerage.booking.infraestructure.adapter.in.mappers.ClientMapper;
import com.algerage.booking.infraestructure.adapter.in.mappers.ServiceMapper;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ClientEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ServiceEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.repository.IBookedTimesRepo;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class BookedTimesAdapter implements BookedTimesPort {

    private final ClientMapper clientMapper;
    private final ServiceMapper serviceMapper;
    private final BookingMapper bookingMapper;
    private final IBookedTimesRepo bookedTimesRepo;


    @Override
    public List<Booking> getBookedTimes(Client client, Service service, LocalDate date) {
        ClientEntity clientEntity = clientMapper.createEntityFromModel(client);
        ServiceEntity serviceEntity = serviceMapper.createEntityFromModel(service);

        return bookedTimesRepo
                .findByClientAndServiceAndBookingStartBetween(clientEntity, serviceEntity, date.atStartOfDay(), date.atTime(23, 59, 59))
                .stream()
                .map(bookingMapper::createModelFromEntity).toList();
    }
}
