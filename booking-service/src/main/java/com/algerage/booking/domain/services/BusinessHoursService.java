package com.algerage.booking.domain.services;

import com.algerage.booking.domain.model.BlockedTimes;

import java.time.LocalDateTime;
import java.util.List;

public interface BusinessHoursService {

    boolean isSlotBlocked(LocalDateTime slotInit, LocalDateTime slotEnd, List<BlockedTimes> blockedTimes);
}
