package modelos.utiles.seguridad;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ContrasenaHasher {


    private static final PasswordEncoder ENCRIPTADOR = new BCryptPasswordEncoder();

    public static String encodePassword(String contrasena) {
        return ENCRIPTADOR.encode(contrasena);
    }


    // Verifica que la contrasena introducida coincida con la de la base de datos
    public static boolean matches(String contrasena, String contrasenaEncriptada) {
        if (contrasena == null){
            return false;
        }
        return ENCRIPTADOR.matches(contrasena, contrasenaEncriptada);
    }
}