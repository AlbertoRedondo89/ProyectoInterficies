/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JDialog{
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login(JFrame parent) {
        super(parent, "Login", true); // 'true' para que sea modal

        // Configuración del layout
        setLayout(new GridLayout(4, 2, 10, 10)); // 4 filas, 2 columnas

        // Etiquetas y campos de entrada
        JLabel userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        
        // Botón de login
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String password = new String(passwordField.getPassword());
                ((MainForm)parent).abrirMenuPrincipal(userId, password);
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
