package controladores.daos.contratos;

public interface EmpleadoDAO {
    boolean postRegistrar(String nombre, String contrasena, String email);
    boolean updateActualizarDatosPersonales(String email, String nuevoNombre, String nuevaContrasena);
    boolean getLogin(String email, String contrasena);

}
