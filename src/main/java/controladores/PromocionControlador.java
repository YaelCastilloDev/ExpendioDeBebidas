/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.daos.implementaciones.PromocionDAOimpl;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yael
 */
public class PromocionControlador {

    private final PromocionDAOimpl promocionDAO = new PromocionDAOimpl();

    public boolean crearPromocionCliente(int idCliente, double porcentaje, String fechaInicio, String fechaFin) {
        try {
            return promocionDAO.crearPromocionCliente(idCliente, porcentaje, fechaInicio, fechaFin);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public List<Integer> obtenerPromocionesPorBebida(int idBebida) {
        try {
            return promocionDAO.obtenerPromocionesPorBebida(idBebida);
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public List<Integer> obtenerPromocionesPorCliente(int idCliente) {
        try {
            return promocionDAO.obtenerPromocionesPorCliente(idCliente);
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public boolean crearPromocionBebida(int idBebida, double porcentaje, String fechaInicio, String fechaFin) {
        try {
            return promocionDAO.crearPromocionBebida(idBebida, porcentaje, fechaInicio, fechaFin);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
