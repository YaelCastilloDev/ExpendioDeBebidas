package company.expendiodebebidas;

import modelos.utiles.validaciones.BaseDeDatosConeccion;

import controladores.clases.AdminControlador;
import jakarta.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import vistas.LoginAdmin;

/**
 *
 * @author yael
 */
public class ExpendioDeBebidas {

    public static void main(String[] args)  { 
        
        AdminControlador ad = new AdminControlador();
        try {
            ad.autenticarAdmin("q@gmail.com", "12345677");
            
            
            
            
            
            /*
            SwingUtilities.invokeLater(() -> {
            try {
            // Establecer look and feel (opcional)
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            e.printStackTrace();
            }
            
            new LoginAdmin().setVisible(true);
            });
        */     } catch (ConstraintViolationException ex) {
            Logger.getLogger(ExpendioDeBebidas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ExpendioDeBebidas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExpendioDeBebidas.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
