/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package spdvi.adminusers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;
import spdvi.adminusers.dataaccess.DataAccess;
import spdvi.adminusers.dto.Intent;
import spdvi.adminusers.dto.Review;
import spdvi.adminusers.dto.Usuari;
import spdvi.adminusers.logica.Logica;
import spdvi.adminusers.models.ColoresTabla;
import spdvi.adminusers.models.TablaIntentosGeneral;
import spdvi.adminusers.models.TablaUsuariosGeneral;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author alber
 */
public class Gestion extends javax.swing.JPanel {

    private MainForm pare;
    private DataAccess da = new DataAccess();
    private Logica logica = new Logica();
    private EmbeddedMediaPlayerComponent mediaPlayer;
    private TableRowSorter<TablaIntentosGeneral> sorter;
    private Review reviewActiva = null;

    public Gestion() {
        initComponents();
    }

    public Gestion(MainForm pare) {
        this.pare = pare;
        System.setProperty("jna.library.path", "C:\\Program Files\\VideoLAN\\VLC");
        System.setProperty("VLC_PLUGIN_PATH", "C:\\Program Files\\VideoLAN\\VLC\\plugins");
        initComponents();
        mediaPlayer = new EmbeddedMediaPlayerComponent();
        jPanelVideo.add(mediaPlayer, BorderLayout.CENTER);
        iniciaTablaUsers();
        iniciaTablaIntents();
        
        setButtonIcon(jButtonPlay, "/images/play.png");
        setButtonIcon(jButtonPause, "/images/pause.png");
        setButtonIcon(jButtonStrop, "/images/stop.png");
        
    }

    public void iniciaTablaUsers() {
        ArrayList<Usuari> users = logica.getUsuarisNoProfesor();
        TablaUsuariosGeneral tablaUsers = new TablaUsuariosGeneral(users);
        jTableUsers.removeAll();
        jTableUsers.setModel(tablaUsers);
    }

    public void iniciaTablaIntents() {
        ArrayList<Intent> intents = logica.getIntentsSinReview();
        TablaIntentosGeneral tablaIntentos = new TablaIntentosGeneral(intents);
        jTableIntents.removeAll();
        jTableIntents.setModel(tablaIntentos);

        pintaTabla();
        sorterIntentos(tablaIntentos);
        jTextComentario.setForeground(Color.BLACK);
        jTextComentario.setBackground(Color.WHITE);

        // Reproducción automática del primer vídeo
        if (!intents.isEmpty()) {
            jTableIntents.changeSelection(0, 0, false, false);
            playVid(intents.get(0)); // Llama a playVid solo después de que el panel sea visible
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------- METODO PARA LOS COLORES DE LA TABLA
    private void pintaTabla() {
        ColoresTabla coloresTabla = new ColoresTabla();
        for (int i = 0; i < jTableIntents.getColumnCount(); i++) {
            jTableIntents.getColumnModel().getColumn(i).setCellRenderer(coloresTabla);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelComentario = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextComentario = new javax.swing.JTextArea();
        jComboBoxValoracion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButtonGuardarReview = new javax.swing.JButton();
        jButtonModificaReview = new javax.swing.JButton();
        jButtonEliminaReview = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsers = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableIntents = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanelVideo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNombreEjercicio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelFechaEjercicio = new javax.swing.JLabel();
        jButtonPlay = new javax.swing.JButton();
        jButtonStrop = new javax.swing.JButton();
        jButtonPause = new javax.swing.JButton();
        jButtonMuestraTodos = new javax.swing.JButton();
        jButtonMuestraPendientes = new javax.swing.JButton();
        jButtonEliminaIntento = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1200, 800));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Review Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(217, 198, 96))); // NOI18N

        jLabelComentario.setForeground(new java.awt.Color(217, 198, 96));
        jLabelComentario.setText("Comentario");

        jTextComentario.setColumns(20);
        jTextComentario.setLineWrap(true);
        jTextComentario.setRows(5);
        jTextComentario.setWrapStyleWord(true);
        jTextComentario.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextComentario.setEnabled(false);
        jTextComentario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextComentarioPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(jTextComentario);

        jComboBoxValoracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBoxValoracion.setEnabled(false);
        jComboBoxValoracion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxValoracionItemStateChanged(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(217, 198, 96));
        jLabel3.setText("Valoración");

        jButtonGuardarReview.setText("Guardar review");
        jButtonGuardarReview.setEnabled(false);
        jButtonGuardarReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarReviewActionPerformed(evt);
            }
        });

        jButtonModificaReview.setText("Modificar review");
        jButtonModificaReview.setEnabled(false);
        jButtonModificaReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificaReviewActionPerformed(evt);
            }
        });

        jButtonEliminaReview.setText("Eliminar Review");
        jButtonEliminaReview.setEnabled(false);
        jButtonEliminaReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminaReviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonEliminaReview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificaReview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardarReview))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(26, 26, 26)
                            .addComponent(jLabelComentario))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jComboBoxValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelComentario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardarReview)
                    .addComponent(jButtonModificaReview)
                    .addComponent(jButtonEliminaReview))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Users"
            }
        ));
        jTableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableUsers);

        jTableIntents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableIntents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableIntents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableIntentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableIntents);

        jPanel2.setBackground(new java.awt.Color(217, 198, 96));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jPanelVideo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelVideo.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Ejercicio:");

        jLabelNombreEjercicio.setText("...............................");

        jLabel2.setText("Fecha: ");

        jLabelFechaEjercicio.setText("............................");

        jButtonPlay.setBackground(new java.awt.Color(217, 198, 96));
        jButtonPlay.setBorder(null);
        jButtonPlay.setBorderPainted(false);
        jButtonPlay.setContentAreaFilled(false);
        jButtonPlay.setMinimumSize(new java.awt.Dimension(28, 28));
        jButtonPlay.setPreferredSize(new java.awt.Dimension(28, 28));
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jButtonStrop.setBackground(new java.awt.Color(217, 198, 96));
        jButtonStrop.setBorder(null);
        jButtonStrop.setBorderPainted(false);
        jButtonStrop.setContentAreaFilled(false);
        jButtonStrop.setMinimumSize(new java.awt.Dimension(28, 28));
        jButtonStrop.setPreferredSize(new java.awt.Dimension(28, 28));
        jButtonStrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStropActionPerformed(evt);
            }
        });

        jButtonPause.setBackground(new java.awt.Color(217, 198, 96));
        jButtonPause.setBorder(null);
        jButtonPause.setBorderPainted(false);
        jButtonPause.setContentAreaFilled(false);
        jButtonPause.setMinimumSize(new java.awt.Dimension(28, 28));
        jButtonPause.setPreferredSize(new java.awt.Dimension(28, 28));
        jButtonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNombreEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFechaEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanelVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonStrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelFechaEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNombreEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonStrop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jButtonMuestraTodos.setBackground(new java.awt.Color(217, 198, 96));
        jButtonMuestraTodos.setText("Todos");
        jButtonMuestraTodos.setBorderPainted(false);
        jButtonMuestraTodos.setFocusPainted(false);
        jButtonMuestraTodos.setMinimumSize(new java.awt.Dimension(39, 20));
        jButtonMuestraTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMuestraTodosActionPerformed(evt);
            }
        });

        jButtonMuestraPendientes.setBackground(new java.awt.Color(217, 198, 96));
        jButtonMuestraPendientes.setText("Pendientes");
        jButtonMuestraPendientes.setBorderPainted(false);
        jButtonMuestraPendientes.setFocusPainted(false);
        jButtonMuestraPendientes.setMinimumSize(new java.awt.Dimension(67, 20));
        jButtonMuestraPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMuestraPendientesActionPerformed(evt);
            }
        });

        jButtonEliminaIntento.setBackground(new java.awt.Color(217, 198, 96));
        jButtonEliminaIntento.setText("Eliminar");
        jButtonEliminaIntento.setBorderPainted(false);
        jButtonEliminaIntento.setFocusPainted(false);
        jButtonEliminaIntento.setMinimumSize(new java.awt.Dimension(50, 20));
        jButtonEliminaIntento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminaIntentoActionPerformed(evt);
            }
        });

        jButtonLogout.setBackground(new java.awt.Color(217, 198, 96));
        jButtonLogout.setText("LOGOUT");
        jButtonLogout.setBorderPainted(false);
        jButtonLogout.setFocusPainted(false);
        jButtonLogout.setMinimumSize(new java.awt.Dimension(54, 20));
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButtonMuestraTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMuestraPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEliminaIntento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonMuestraPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMuestraTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEliminaIntento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // ------------------------------------------------------------------------------------------------------------------------------------------ACTIVADOR DE VIDEO AL CLICAR EN LA TABLA
    private void jTableIntentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableIntentsMouseClicked
           muestraDatosIntento();
    }//GEN-LAST:event_jTableIntentsMouseClicked

    private void muestraDatosIntento() {
        int row = jTableIntents.getSelectedRow();
        if (row != -1) {
            // Esto para que, al ordenar, no se desajuste el elemento seleccionado
            int modelIndex = jTableIntents.convertRowIndexToModel(row);

            // Usar el índice del modelo para obtener el intento correcto
            TablaIntentosGeneral modelo = (TablaIntentosGeneral) jTableIntents.getModel();
            Intent intento = modelo.getIntent(modelIndex);

            playVid(intento); 
            Review rev = logica.getReview(intento.getId());
            if (rev != null) {
                reviewActiva = rev;
                jTextComentario.setText(rev.getComentari());
                jTextComentario.setEnabled(false);
                jComboBoxValoracion.setSelectedIndex(rev.getValoracio() - 1); //menos 1 para evitar outOfBounds
                jComboBoxValoracion.setEnabled(false);
                jButtonEliminaReview.setEnabled(true);
                jButtonModificaReview.setEnabled(true);
                jButtonGuardarReview.setEnabled(false);
            } else {
                jTextComentario.setText("");
                jTextComentario.setEnabled(true);
                jComboBoxValoracion.setSelectedIndex(0);
                jComboBoxValoracion.setEnabled(true);
                jButtonEliminaReview.setEnabled(false);
                jButtonModificaReview.setEnabled(false);
                jButtonGuardarReview.setEnabled(false);
            }
        }
    }
    
    // ------------------------------------------------------------------------------------------------------------------------------------------ PLAY VIDEO
    private void playVid(Intent intento) {
        String archivo = "src\\main\\resources\\videos\\" + intento.getVideofile();
        SwingUtilities.invokeLater(() -> {
            mediaPlayer.mediaPlayer().media().play(archivo); // espera a que los elementos estén cargados antes de empezar a reproducir el video. 

            jLabelNombreEjercicio.setText(logica.getNombreEjercicio(intento.getIdExercici()));
            jLabelFechaEjercicio.setText(intento.getInici().toString());
        });
    }

    // Comprueba que los botones están creados y les añade el icono
    private void setButtonIcon(JButton button, String imagePath) {
        button.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
                Image image = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(image));
                button.setText(""); // Eliminar cualquier texto
                button.setToolTipText(imagePath); // Opcional: Establecer un tooltip con el nombre de la acción
            }
        });
    }
    // ------------------------------------------------------------------------------------------------------------------------------------------BOTON VISUALIZAR TODAS LAS REVIEWS
    private void jButtonMuestraTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMuestraTodosActionPerformed
        // TODO add your handling code here:
        ArrayList<Intent> intents = logica.getIntents();
        TablaIntentosGeneral tablaIntentos = new TablaIntentosGeneral(intents);

        jTableIntents.removeAll();
        jTableIntents.setModel(tablaIntentos);
        pintaTabla();
        sorterIntentos(tablaIntentos);
        jTableIntents.changeSelection(0, 0, false, false);
        playVid(intents.get(0));
    }//GEN-LAST:event_jButtonMuestraTodosActionPerformed

    // -------------------------------------------------------------------------------------------------------------------------------------------BOTON VISUALIZAR REVIEWS PENDIENTES
    private void jButtonMuestraPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMuestraPendientesActionPerformed
        // TODO add your handling code here:
        ArrayList<Intent> intents = logica.getIntentsSinReview();
        TablaIntentosGeneral tablaIntentos = new TablaIntentosGeneral(intents);

        jTableIntents.removeAll();
        jTableIntents.setModel(tablaIntentos);
        pintaTabla();
        sorterIntentos(tablaIntentos);
        jTableIntents.changeSelection(0, 0, false, false);
        playVid(intents.get(0));

    }//GEN-LAST:event_jButtonMuestraPendientesActionPerformed

    // ------------------------------------------------------------------------------------------------------------------------------------------ SORTER  de tabla
    private void sorterIntentos(TablaIntentosGeneral tabla) {
        sorter = new TableRowSorter<>(tabla);
        jTableIntents.setRowSorter(sorter);

        // ordenación  por defecto
        List<SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new SortKey(2, SortOrder.DESCENDING)); // ordre desitjat;
        sorter.setSortKeys(sortKeys);
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------ACTIVADOR AL CLICAR EN LA TABLA USUARIOS
    private void jTableUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsersMouseClicked
        // LOCALIZA EL USUARIO SELECCIONADO Y ALTERA LA TABLA DE INTENTOS PAR MOSTRAR SOLO LOS DE ESE USUARIO
        int numUser = jTableUsers.getSelectedRow();
        if (numUser != -1) {
            TablaUsuariosGeneral modelo = (TablaUsuariosGeneral) jTableUsers.getModel();
            Usuari usuari = modelo.getUser(numUser);
            if (logica.usuarioTieneintentos(usuari.getId())) {
                ArrayList<Intent> intents = logica.getIntentsDeUsuario(usuari.getId());
                TablaIntentosGeneral tablaIntentosUsuario = new TablaIntentosGeneral(intents);
                jTableIntents.removeAll();
                jTableIntents.setModel(tablaIntentosUsuario);
                pintaTabla();
                sorterIntentos(tablaIntentosUsuario);
                jTableIntents.changeSelection(0, 0, false, false);
                playVid(intents.get(0));
            }
            else  JOptionPane.showMessageDialog(null, "El usuario todavía no tiene intentos");
        }
    }//GEN-LAST:event_jTableUsersMouseClicked

    //Metodo para guardar REVIEW,
    //  if REVIEW existe -> UPDATE rieview    //    else -> INSERT review
    // METODO DEBERIA ESTAR EN LOGICA*****
    private void jButtonGuardarReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarReviewActionPerformed
        // TODO add your handling code here:
        int intentoId = (int) jTableIntents.getValueAt(jTableIntents.getSelectedRow(), 0);

        if (jTextComentario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducirse algún comentario");
        } else {
            if (logica.intentoTieneReview(intentoId)) {
                String comentario = jTextComentario.getText();
                int valoracion = (int) jComboBoxValoracion.getSelectedIndex() + 1;
                logica.updateReview(valoracion, comentario, intentoId);
            } else {
                Review review = new Review();
                review.setIdIntent(intentoId);
                review.setValoracio((int) jComboBoxValoracion.getSelectedIndex() + 1);
                review.setIdReviewer(pare.getUser());
                review.setComentari(jTextComentario.getText());

                int resultado = logica.registraReview(review);
                if (resultado == 1) {
                    System.out.println("Ha ido bien");
                }
                if (resultado == 0) {
                    System.out.println("Review no registrada");
                } else {
                    System.out.println("Algo no ha ido bien...");
                }
            }
            logica.actualizaDatos();
            iniciaTablaIntents();
        }
    }//GEN-LAST:event_jButtonGuardarReviewActionPerformed

    private void jButtonModificaReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificaReviewActionPerformed
        // TODO add your handling code here:
        jTextComentario.setEnabled(true);
        jComboBoxValoracion.setEnabled(true);
    }//GEN-LAST:event_jButtonModificaReviewActionPerformed

    private void jComboBoxValoracionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxValoracionItemStateChanged
        // TODO add your handling code here:
        activaBoton();
    }//GEN-LAST:event_jComboBoxValoracionItemStateChanged

    // ------------------------------------------------------------------------------------------------------------------------------------------ BOTONES VIDEO
    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        mediaPlayer.mediaPlayer().controls().play();
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jButtonStropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStropActionPerformed
        mediaPlayer.mediaPlayer().controls().stop();
    }//GEN-LAST:event_jButtonStropActionPerformed

    private void jButtonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPauseActionPerformed
        mediaPlayer.mediaPlayer().controls().pause();
    }//GEN-LAST:event_jButtonPauseActionPerformed

    
    private void jButtonEliminaIntentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminaIntentoActionPerformed
       eliminaRegistro("Intents", ((int) jTableIntents.getValueAt(jTableIntents.getSelectedRow(), 0)));
       muestraDatosIntento();
    }//GEN-LAST:event_jButtonEliminaIntentoActionPerformed

    private void jButtonEliminaReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminaReviewActionPerformed
        eliminaRegistro("Review", reviewActiva.getId());
        muestraDatosIntento();
    }//GEN-LAST:event_jButtonEliminaReviewActionPerformed

    private void jTextComentarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextComentarioPropertyChange
        activaBoton(); 
    }//GEN-LAST:event_jTextComentarioPropertyChange

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        logica.cerrarSesion();
        pare.cerrarSesion();
    }//GEN-LAST:event_jButtonLogoutActionPerformed

// ---------------------------------------------------------------------------------------------------------------------------------------------  metodo general para llamar a ELIMINAR un registro de datos.     
    private void eliminaRegistro(String tabla, int id) {
         int result = JOptionPane.showConfirmDialog(
                null,
                "¿Seguro que deseas eliminar el registro? \nEsta acción no se puede deshacer",
                "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            int resultado = logica.dropRegistro(tabla, id);
            switch (resultado) {
                case 0 ->
                    JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                case 1 ->
                    JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
                default ->
                    JOptionPane.showMessageDialog(null, "Algo ha ido mal");
            }
        }
            logica.actualizaDatos();
            iniciaTablaIntents();
    }
    
    private void activaBoton() {
        if (!jTextComentario.getText().isEmpty() && jComboBoxValoracion.getSelectedIndex() != -1) {
            jButtonGuardarReview.setEnabled(true);
        } else {
            jButtonGuardarReview.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminaIntento;
    private javax.swing.JButton jButtonEliminaReview;
    private javax.swing.JButton jButtonGuardarReview;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonModificaReview;
    private javax.swing.JButton jButtonMuestraPendientes;
    private javax.swing.JButton jButtonMuestraTodos;
    private javax.swing.JButton jButtonPause;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonStrop;
    private javax.swing.JComboBox<String> jComboBoxValoracion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelComentario;
    private javax.swing.JLabel jLabelFechaEjercicio;
    private javax.swing.JLabel jLabelNombreEjercicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelVideo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableIntents;
    private javax.swing.JTable jTableUsers;
    private javax.swing.JTextArea jTextComentario;
    // End of variables declaration//GEN-END:variables
}
