package com.algerage.booking.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class Client {

    private Long clientId;
    private String razon;
    private String documento;
    private String telefono;
    private Instant fechaAlta;
    private Instant fechaBaja;
    private byte[] logo;
}
