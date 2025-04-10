package com.algerage.booking.domain.services.impl;

import com.algerage.booking.domain.model.BlockedTimes;
import com.algerage.booking.domain.services.BusinessHoursService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BusinessHoursServiceImpl implements BusinessHoursService {


    @Override
    public boolean isSlotBlocked(LocalDateTime slotInit, LocalDateTime slotEnd, List<BlockedTimes> blockedTimes) {
        Optional<BlockedTimes> foundBlock = blockedTimes.stream().filter(blockedTime -> slotInit.isBefore(blockedTime.getEndDateTime())
                && slotEnd.isAfter(blockedTime.getStartDateTime())).findAny();

        return foundBlock.isPresent();
    }
}
