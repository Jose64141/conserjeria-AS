/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.dao;

import cl.ucn.disc.as.model.Edificio;
import io.ebean.Finder;


/**
 * The Finder of Edificio.
 *
 * @author José Alcayaga.
 */
public class EdificioFinder extends Finder<Long, Edificio> {

    /**
     * The Constructor.
     */
    public EdificioFinder() {
        super(Edificio.class);
    }
}
