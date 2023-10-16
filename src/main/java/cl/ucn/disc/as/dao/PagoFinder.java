/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.dao;

import cl.ucn.disc.as.model.Pago;
import cl.ucn.disc.as.model.query.QPago;
import io.ebean.Finder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The Finder of Pago.
 *
 * @author José Alcayaga.
 */
public class PagoFinder extends Finder<Long, Pago> {


    /**
     * The Constructor.
     */
    public PagoFinder() {
        super(Pago.class);
    }

    /**
     * Find a list of Pagos by a Persona rut.
     *
     * @param rut to use.
     * @return the list of Pagos.
     */
    public List<Pago> byRut(@NotNull String rut) {
        return new QPago()
                .raw("contrato_id = (select id from contrato where persona_id = (select id from persona where rut = ?))", rut)
                .findList();
    }
}
