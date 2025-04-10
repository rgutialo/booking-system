package com.algerage.booking.infraestructure.adapter.out;

import com.algerage.booking.application.port.out.BlockedTimesPort;
import com.algerage.booking.domain.model.BlockedTimes;
import com.algerage.booking.domain.model.Client;
import com.algerage.booking.infraestructure.adapter.in.mappers.BlockedTimesMapper;
import com.algerage.booking.infraestructure.adapter.in.mappers.ClientMapper;
import com.algerage.booking.infraestructure.adapter.in.mappers.ServiceMapper;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.BlockedTimesEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ClientEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ServiceEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.repository.IBlockedTimesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BlockedTimesAdapter implements BlockedTimesPort {

    private final IBlockedTimesRepo blockedTimesRepo;
    private final ClientMapper clientMapper;
    private final ServiceMapper serviceMapper;
    private final BlockedTimesMapper blockedTimesMapper;

    @Override
    public List<BlockedTimes> getBlockedTimes(Client client, com.algerage.booking.domain.model.Service service, LocalDate date) {
        ClientEntity clientEntity = clientMapper.createEntityFromModel(client);
        ServiceEntity serviceEntity = serviceMapper.createEntityFromModel(service);
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59);
        List<BlockedTimesEntity> blockedTimes = blockedTimesRepo
                .findByClientAndServiceAndWeekdayAndStartDateTimeGreaterThanEqualAndEndDateTimeLessThanEqual(clientEntity, serviceEntity, date.getDayOfWeek().name(),startOfDay, endOfDay);

        return blockedTimes.stream().map(blockedTimesMapper::createModelFromEntity).toList();
    }
}
