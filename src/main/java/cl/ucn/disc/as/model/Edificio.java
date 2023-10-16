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
import javax.persistence.OneToMany;
import java.util.List;

/**
 * The Edificio class.
 *
 * @author José Alcayaga.
 */
@Getter
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Edificio extends BaseModel {

    /**
     * The Nombre.
     */
    @NotNull
    private String nombre;

    /**
     * The Dirección.
     */
    @NotNull
    private String direccion;

    /**
     * The Departamentos of the Edificio
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Departamento> departamentos;

    /**
     * Adds a Departamento to the Edificio
     * @param departamento to add
     */
    public void add(Departamento departamento)
    {
        departamentos.add(departamento);
    }
}
