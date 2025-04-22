package vistas;

import controlador.AdminControlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import jakarta.validation.ConstraintViolationException;

public class LoginAdmin extends JFrame {
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private AdminControlador adminControlador;

    public LoginAdmin() {
        adminControlador = new AdminControlador();
        initComponents();
    }

    private void initComponents() {
        setTitle("Login Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Email field
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        txtEmail = new JTextField(20);
        panel.add(txtEmail, gbc);

        // Password field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        txtPassword = new JPasswordField(20);
        panel.add(txtPassword, gbc);

        // Login button
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this::handleLogin);
        panel.add(btnLogin, gbc);

        // Add Enter key listener
        txtPassword.addActionListener(this::handleLogin);

        add(panel);
    }

    private void handleLogin(ActionEvent e) {
        String email = txtEmail.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor complete todos los campos", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            adminControlador.autenticarAdmin(email, password);
            JOptionPane.showMessageDialog(this, 
                "Login exitoso", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // Open main menu
            // new MenuPrincipal().setVisible(true);
            // this.dispose();
            
        } catch (ConstraintViolationException ex) {
            showValidationError(ex);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, 
                ex.getMessage(), 
                "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error de conexión con la base de datos", 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error inesperado: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            txtPassword.setText("");
            txtEmail.requestFocus();
        }
    }

    private void showValidationError(ConstraintViolationException ex) {
        StringBuilder errorMessage = new StringBuilder("Errores de validación:\n");
        ex.getConstraintViolations().forEach(violation -> 
            errorMessage.append("- ").append(violation.getMessage()).append("\n"));
        
        JOptionPane.showMessageDialog(this, 
            errorMessage.toString(), 
            "Datos inválidos", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new LoginAdmin().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}