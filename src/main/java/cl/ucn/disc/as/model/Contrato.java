/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;

/**
 * The Contrato class.
 *
 * @author José Alcayaga.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Contrato extends BaseModel {

    /**
     * The Fecha de Pago.
     */
    @NotNull
    private Instant fechaPago;

    /**
     * The Dueño.
     */
    @NotNull
    @ManyToOne(optional=false)
    private Persona dueño;

}
