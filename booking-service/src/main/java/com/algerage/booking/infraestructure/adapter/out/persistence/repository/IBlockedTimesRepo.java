package com.algerage.booking.infraestructure.adapter.out.persistence.repository;

import com.algerage.booking.infraestructure.adapter.out.persistence.entity.BlockedTimesEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ClientEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IBlockedTimesRepo extends JpaRepository<BlockedTimesEntity, Long> {


    List<BlockedTimesEntity> findByClientAndServiceAndWeekdayAndStartDateTimeGreaterThanEqualAndEndDateTimeLessThanEqual(
            ClientEntity client, ServiceEntity service, String weekday, LocalDateTime date1, LocalDateTime date2);
}
