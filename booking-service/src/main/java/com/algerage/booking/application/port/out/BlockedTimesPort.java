package com.algerage.booking.application.port.out;

import com.algerage.booking.domain.model.BlockedTimes;
import com.algerage.booking.domain.model.Client;
import com.algerage.booking.domain.model.Service;

import java.time.LocalDate;
import java.util.List;

public interface BlockedTimesPort {

    List<BlockedTimes> getBlockedTimes(final Client client, Service service, LocalDate date);
}
