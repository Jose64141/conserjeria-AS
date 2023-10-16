package cl.ucn.disc.as;

import cl.ucn.disc.as.model.Departamento;
import cl.ucn.disc.as.model.Edificio;
import cl.ucn.disc.as.model.Persona;
import cl.ucn.disc.as.services.Sistema;
import cl.ucn.disc.as.services.SistemaImpl;
import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

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

        // Instantiate impl
        Sistema sistema = new SistemaImpl(db);

        Persona persona = Persona.builder()
                .apellidos("Alc Mar")
                .nombre("Joses")
                .email("a@aol.com")
                .rut("11111111-1")
                .telefono("+56123")
                .build();
        sistema.add(persona);
        log.debug("Done");

        Edificio edif = Edificio.builder()
                .nombre("Y1")
                .direccion("Angamos 610")
                .build();
        log.debug("Edif");
        log.debug("a {}",edif);
        edif = sistema.add(edif);
        log.debug("a {}",edif);
        log.debug("Done");

        Departamento dep = Departamento.builder()
                .numero(100)
                .piso(1)
                .build();
        dep = sistema.addDepartamento(dep, edif);
        log.debug("d {}",dep);


        Departamento dep2 = Departamento.builder()
                .numero(101)
                .piso(2)
                .build();
        dep2 = sistema.addDepartamento(dep2, edif.getId());
        log.debug("d {}",dep2);

        sistema.realizarContrato(persona, dep, Instant.now());
        sistema.realizarContrato(persona.getId(), dep2.getId(), Instant.now());

        log.debug("Contratos {}", sistema.getContratos());
        log.debug("Personas {}", sistema.getPersonas());
        log.debug("Pagos {}", sistema.getPagos("11111111-1"));
        log.debug("Done");
    }
}
