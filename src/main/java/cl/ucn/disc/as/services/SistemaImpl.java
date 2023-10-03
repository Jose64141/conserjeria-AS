package cl.ucn.disc.as.services;

import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.Edificio;
import io.ebean.Database;
import org.jetbrains.annotations.NotNull;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PersistenceException;

/**
 * System Implementation
 */
@Slf4j
public class SistemaImpl implements Sistema {

    /**
     * The database.
     */
    private final Database database;

    public SistemaImpl(@NotNull Database database) {
        this.database = database;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Edificio add(Edificio edificio) {
        try{
            this.database.save(edificio);
        }
        catch (PersistenceException ex){
            //TODO: save the exception
            log.error("Error", ex);
            throw new SistemaException("Error al agregar edificio", ex);
        }
        // WARN: need to retrieve id
        return edificio;
    }
}
