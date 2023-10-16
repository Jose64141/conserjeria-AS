/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.dao;

import cl.ucn.disc.as.model.Departamento;
import cl.ucn.disc.as.model.query.QDepartamento;
import io.ebean.Finder;


/**
 * The Finder of Departamento.
 *
 * @author José Alcayaga.
 */
public class DepartamentoFinder extends Finder<Long, Departamento> {


    /**
     * The Constructor.
     */
    public DepartamentoFinder() {
        super(Departamento.class);
    }

    public Departamento byEdificio(Long edificioId, Integer numero) {
        return new QDepartamento()
                .raw("edificio_id = ? and numero = ?", edificioId, numero)
                .findOne();
    }
}
