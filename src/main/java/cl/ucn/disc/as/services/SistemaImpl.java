package cl.ucn.disc.as.services;

import cl.ucn.disc.as.dao.*;
import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.*;
import io.ebean.Database;
import io.ebean.Transaction;
import org.jetbrains.annotations.NotNull;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

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
            return edificio;
        }
        catch (PersistenceException ex){
            //TODO: save the exception
            log.error("Error", ex);
            throw new SistemaException("Error al agregar edificio", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Persona add(Persona persona) {
        try{
            this.database.save(persona);
            return persona;
        }
        catch (PersistenceException ex){
            log.error("Error", ex);
            throw new SistemaException("Error al agregar persona", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Departamento addDepartamento(Departamento departamento, Edificio edificio) {
        Transaction transaction = database.beginTransaction();
        try{
            edificio.add(departamento);
            this.database.save(edificio);
            departamento = new DepartamentoFinder().byEdificio(edificio.getId(), departamento.getNumero());
            transaction.commit();
            return departamento;
        }
        catch (PersistenceException ex){
            transaction.rollback();
            log.error("Error", ex);
            throw new SistemaException("Error al agregar departamento", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Departamento addDepartamento(Departamento departamento, long edificioId) {
        Transaction transaction = database.beginTransaction();
        try{
            Edificio edificio = new EdificioFinder().byId(edificioId);
            edificio.add(departamento);
            this.database.save(edificio);
            departamento = new DepartamentoFinder().byEdificio(edificio.getId(), departamento.getNumero());
            transaction.commit();
            return departamento;
        }
        catch (PersistenceException ex){
            transaction.rollback();
            log.error("Error", ex);
            throw new SistemaException("Error al agregar departamento", ex);
        }
        catch (NullPointerException ex){
            transaction.rollback();
            log.error("Error", ex);
            throw new SistemaException("Edificio de ID no existente", ex);
        }
    }
    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago) {
        try{
            Contrato contrato = Contrato.builder()
                    .departamento(departamento)
                    .persona(duenio)
                    .fechaPago(fechaPago)
                    .build();
            this.database.save(contrato);
            return contrato;
        }
        catch (PersistenceException ex){
            log.error("Error", ex);
            throw new SistemaException("Error al realizar contrato", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Contrato realizarContrato(long duenioId, long departamentoId, Instant fechaPago) {
                try{
            Departamento departamento = new DepartamentoFinder().byId(departamentoId);
            Persona duenio = new PersonaFinder().byId(duenioId);
            Contrato contrato = Contrato.builder()
                    .departamento(departamento)
                    .persona(duenio)
                    .fechaPago(fechaPago)
                    .build();
            this.database.save(contrato);
            return contrato;
        }
        catch (PersistenceException ex){
            log.error("Error", ex);
            throw new SistemaException("Error al realizar contrato", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public List<Contrato> getContratos() {
        try{
            return new ContratoFinder().all();
        }
        catch (PersistenceException ex){
            log.error("Error", ex);
            throw new SistemaException("Error al obtener contratos", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public List<Persona> getPersonas() {
        try{
            return new PersonaFinder().findAll();
        }
        catch (PersistenceException ex){
            log.error("Error", ex);
            throw new SistemaException("Error al obtener personas", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public List<Pago> getPagos(String rut) {
        try{
            return new PagoFinder().byRut(rut);
        }
        catch (PersistenceException ex){
            log.error("Error", ex);
            throw new SistemaException("Error al obtener pagos", ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Optional<Persona> getPersona(String rut) {
        try{
            return new PersonaFinder().byRut(rut);
        }
        catch (PersistenceException ex){
            log.error("Error", ex);
            throw new SistemaException("Error al obtener persona", ex);
        }
    }
}
