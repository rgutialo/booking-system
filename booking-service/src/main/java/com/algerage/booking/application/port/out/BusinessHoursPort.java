package com.algerage.booking.application.port.out;

import com.algerage.booking.domain.model.BusinessHours;
import com.algerage.booking.domain.model.Service;

import java.time.LocalDate;
import java.util.Optional;

public interface BusinessHoursPort {

    Optional<BusinessHours> getBusinessHours(final Service service, final LocalDate date);
}
