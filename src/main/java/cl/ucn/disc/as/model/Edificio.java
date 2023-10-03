/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
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
    @Getter
    @NotNull
    private String direccion;

    /**
     * The Nombre.
     */
    @Getter
    @NotNull
    private String nombre;
}
