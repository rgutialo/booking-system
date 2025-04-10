package com.algerage.booking.infraestructure.adapter.out;

import com.algerage.booking.application.port.out.BusinessHoursPort;
import com.algerage.booking.domain.model.BusinessHours;
import com.algerage.booking.domain.model.Service;
import com.algerage.booking.infraestructure.adapter.in.mappers.BusinessHoursMapper;
import com.algerage.booking.infraestructure.adapter.in.mappers.ServiceMapper;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ServiceEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.repository.IBusinessHoursRepo;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class BusinessHoursAdapter implements BusinessHoursPort {

    private final IBusinessHoursRepo businessHoursRepository;
    private final ServiceMapper serviceMapper;
    private final BusinessHoursMapper businessHoursMapper;

    @Override
    public Optional<BusinessHours> getBusinessHours(final Service service, final LocalDate date) {
        ServiceEntity serviceEntity = serviceMapper.createEntityFromModel(service);

        return businessHoursRepository.findByServiceAndWeekday(serviceEntity, date.getDayOfWeek().name())
                .map(businessHoursMapper::createModelFromEntity);
    }
}
