/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.daos.implementaciones.PromocionDAOimpl;

import java.sql.SQLException;
import java.util.List;
import modelos.Promocion;

/**
 *
 * @author yael
 */
public class PromocionControlador {

    private final PromocionDAOimpl promocionDAO = new PromocionDAOimpl();

    public boolean crearPromocionCliente(int idCliente, double porcentaje, String fechaInicio, String fechaFin) throws SQLException {
        return promocionDAO.crearPromocionCliente(idCliente, porcentaje, fechaInicio, fechaFin);
    }

    public List<Promocion> obtenerPromocionesPorBebida(int idBebida) throws SQLException {
        return promocionDAO.obtenerPromocionesPorBebida(idBebida);
    }

    public List<Promocion> obtenerPromocionesPorCliente(int idCliente) throws SQLException {
        return promocionDAO.obtenerPromocionesPorCliente(idCliente);
    }

    public boolean crearPromocionBebida(int idBebida, double porcentaje, String fechaInicio, String fechaFin) throws SQLException {
        return promocionDAO.crearPromocionBebida(idBebida, porcentaje, fechaInicio, fechaFin);
    }
}
