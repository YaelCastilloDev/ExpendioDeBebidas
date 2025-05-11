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

    boolean postRegistrar(String nombre, String contrasena, String email) throws SQLException;

    public boolean updateActualizarDatosPersonales(String emailViejo, String nuevoNombre, String nuevoEmail, String nuevaContrasena)
            throws SQLException;

    boolean deleteEliminarEmpleado(String email) throws SQLException;

    public List<Bebida> obtenerNombresBebidasMenosVendidas(Connection conexion) throws SQLException;


}
