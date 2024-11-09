/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AboutInfo extends JDialog{
    private JTextArea aboutText;
    private JButton cerrarButton;
    private String datosAbout;

    public AboutInfo(JFrame parent) {
        super(parent, "Login", true); // 'true' para que sea modal
       setLayout(new BorderLayout(10, 10)); // Margen entre bordes de 10px

        // CABECERA
        JLabel infoLabel = new JLabel("Información:");
        
        // AREA del TEXTO
        aboutText = new JTextArea();
        aboutText.setEditable(false);
        datosAbout = "Iconos: \nhttps://www.flaticon.es/ \n"
                           + "Logotipo: \nhttps://www.designevo.com/es/logo-maker/ \n "
                           + "Otras fuentes de información y recursos:"
                           + "https://docs.oracle.com/en/java/javase/21/docs/api/ \n"
                           + "www.chatgpt.com"
                           + "https://stackoverflow.com/questions/";
        aboutText.setText(datosAbout);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);

        // PANEL para colocar el contenido
        JPanel centerPanel = new JPanel(new BorderLayout(5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen alrededor
        centerPanel.add(infoLabel, BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(aboutText), BorderLayout.CENTER); // Scroll por si el texto se extiende 

        // Button para cerrar cerrar
        cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana 
            }
        });

        // Panel para alinear el botón a la derecha
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(cerrarButton);

       
        add(centerPanel, BorderLayout.CENTER); // Centro para el texto y etiqueta
        add(buttonPanel, BorderLayout.SOUTH);  // Sur para el botón

        setLocationRelativeTo(parent); // Centrar en el JFrame principal
    }
}
