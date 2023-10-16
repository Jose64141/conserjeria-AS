/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.dao;

import cl.ucn.disc.as.model.Contrato;
import io.ebean.Finder;

import java.util.List;

/**
 * The Finder of Contrato.
 *
 * @author José Alcayaga.
 */
public class ContratoFinder extends Finder<Long, Contrato> {

    /**
     * The Constructor.
     */
    public ContratoFinder() {
        super(Contrato.class);
    }
}