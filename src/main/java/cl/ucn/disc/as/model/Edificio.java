/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * The Edificio class.
 *
 * @author José Alcayaga.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Edificio extends BaseModel {

    /**
     * The Dirección.
     */
    @NotNull
    private String direccion;

    /**
     * The Nombre.
     */
    @NotNull
    private String nombre;

    /**
     * The Pisos.
     */
    @NotNull
    private Integer pisos;

}
