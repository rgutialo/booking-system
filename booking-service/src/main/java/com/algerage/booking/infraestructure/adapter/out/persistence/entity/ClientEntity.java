package com.algerage.booking.infraestructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CLIENTS")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "razon", nullable = false)
    private String razon;

    @Column(name = "cod_documento", nullable = true)
    private String documento;

    @Column(name = "telefono", nullable = true)
    private String telefono;

    @Column(name = "fecha_alta", nullable = false)
    private Instant fechaAlta;

    @Column(name = "fecha_baja", nullable = true)
    private Instant fechaBaja;

    @Column(name = "logo", nullable = true)
    private byte[] logo;

    @Builder
    public ClientEntity(
            final Long clientId,
            final String razon,
            final String documento,
            final String telefono,
            final Instant fechaAlta,
            final Instant fechaBaja,
            final byte[] logo) {
        this.clientId = clientId;
        this.razon = razon;
        this.documento = documento;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.logo = logo;
    }

}
