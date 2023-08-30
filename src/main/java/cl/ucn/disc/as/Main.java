package cl.ucn.disc.as;

import cl.ucn.disc.as.dao.PersonaFinder;
import cl.ucn.disc.as.model.Persona;
import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 *
 */
@Slf4j
public final class Main {
    /**
     * Entrypoint
     * @param args
     */
    public static void main(String[] args){
        log.debug("Starting...");

        // Get the database
        Database db = DB.getDefault();

        // Build the person
        Persona persona = Persona.builder()
                .apellidos("Alc Mar")
                .nombre("Joses")
                .email("a@aol.com")
                .rut(123)
                .telefono("+56123")
                .build();
        log.debug("Created Persona ${}", persona);

        // Save person to database
        db.save(persona);
        log.debug("Saved Persona ${}", persona);

        // Search created person
        PersonaFinder finder = new PersonaFinder();
        Optional<Persona> result = finder.byRut(123);
        result.ifPresent(p -> log.debug("Persona ${}", p));

        log.debug("Done");
    }
}
