/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

/**
 * The Contrato class.
 *
 * @author José Alcayaga.
 */
@Getter
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
     * The owner.
     */
    @NotNull
    @ManyToOne(optional=false)
    private Persona persona;

    /**
     * The Departamento.
     */
    @NotNull
    @ManyToOne(optional=false)
    private Departamento departamento;

    /**
     * The Pagos of the Contrato
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pago> pagos;
}
