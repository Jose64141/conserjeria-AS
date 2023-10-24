package cl.ucn.disc.as.services;

import cl.ucn.disc.as.model.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * System operations.
 */
public interface Sistema {

    /**
     * Agrega un edificio al sistema.
     *
     * @param edificio a agregar
     * @return
     */
    Edificio add(Edificio edificio);

    /**
     * Agrega una persona al sistema.
     *
     * @param persona a agregar
     * @return
     */
    Persona add(Persona persona);

    /**
     * Agrega un departamento a un edificio.
     *
     * @param departamento a agregar
     * @param edificio al cual agregar
     * @return
     */
    Departamento addDepartamento(Departamento departamento, Edificio edificio);

    /**
     * Agrega un departamento a un edificio.
     *
     * @param departamento a agregar
     * @param edificioId identificador del edificio al cual agregar
     * @return
     */
    Departamento addDepartamento(Departamento departamento, long edificioId);

    /**
     * Realizar un contrato a un dueño por un departamento.
     *
     * @param duenio solicitante del contrato.
     * @param departamento asociado al contrato.
     * @param fechaPago fecha de pago del contrato.
     * @return
     */
    Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago);

    /**
     * Realizar un contrato a un dueño por un departamento.
     *
     * @param duenioId identificador del dueño solicitante del contrato.
     * @param departamentoId identificador del departamento asociado al contrato.
     * @param fechaPago fecha de pago del contrato.
     * @return
     */
    Contrato realizarContrato(long duenioId, long departamentoId, Instant fechaPago);

    /**
     * Obtener listado de contratos del sistema.
     * @return
     */
    List<Contrato> getContratos();

    /**
     * Obtener listado de personas del sistema.
     * @return
     */
    List<Persona> getPersonas();

    /**
     * Obtener listado de pagos de una persona del sistema.
     *
     * @param rut de la persona a consultar.
     * @return
     */
    List<Pago> getPagos(String rut);

    /**
     * Obtener persona dado su RUT.
     *
     * @param rut de la persona a consultar.
     * @return
     */
    Optional<Persona> getPersona(String rut);
}
