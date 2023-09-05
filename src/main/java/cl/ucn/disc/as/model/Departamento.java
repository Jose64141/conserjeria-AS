/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * The Departamento class.
 *
 * @author José Alcayaga.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Departamento extends BaseModel {

    /**
     * The Número.
     */
    @NotNull
    private String numero;

    /**
     * The Piso.
     */
    @NotNull
    private String piso;

    /**
     * The Dueño
     */
    @NotNull
    @OneToOne(optional = false)
    private Edificio edificio;

    /**
     * The Dueño
     */
    @OneToOne
    private Persona dueño;

}
