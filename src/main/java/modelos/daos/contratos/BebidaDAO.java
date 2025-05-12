/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.daos.contratos;

import modelos.Bebida;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yael
 */
public interface BebidaDAO {

    public boolean postRegistrar(Bebida bebida) throws SQLException;

    boolean deleteEliminar(String email) throws SQLException;

    public List<Bebida> obtenerNombresBebidasMenosVendidas(Connection conexion) throws SQLException;

    public boolean existeEnPromocionBebida(int idBebida) throws SQLException;

    public boolean existeEnDetallePedidoProveedor(int idBebida) throws SQLException;

    public boolean existeEnDetallePedidoCliente(int idBebida) throws SQLException;
}
