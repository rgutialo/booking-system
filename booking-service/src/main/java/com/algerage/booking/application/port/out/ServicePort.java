package com.algerage.booking.application.port.out;

import com.algerage.booking.domain.model.Client;
import com.algerage.booking.domain.model.Service;

import java.util.List;
import java.util.Optional;

public interface ServicePort {

    List<Service> getServicesPerClient(final Client client);
    Optional<Service> getServiceById(final Long serviceId);
}
