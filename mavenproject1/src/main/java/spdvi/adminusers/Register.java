/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Register extends JDialog{
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Register(JFrame parent) {
        super(parent, "Login", true); // 'true' para que sea modal

        // Configuración del layout
        setLayout(new GridLayout(4, 2, 10, 10)); // 4 filas, 2 columnas

        // Etiquetas y campos de entrada
        JLabel userIdLabel = new JLabel("Usuario: ");
        userIdField = new JTextField();
        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();

        
        // Botón de login
        loginButton = new JButton("Registro");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                char[] passwordChar = passwordField.getPassword();
                String password = BCrypt.withDefaults().hashToString(12, passwordChar);
                System.out.print(userId);
                System.out.print(password);
                
                ((MainForm)parent).registro(userId, password);
                dispose();
            }
        });

        // Agregar componentes al diálogo
        add(userIdLabel);
        add(userIdField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Espacio vacío para alinear el botón
        add(loginButton);

        // Configuración del diálogo
        pack();
        setLocationRelativeTo(parent); // Centrar respecto al JFrame principal
    }
}
