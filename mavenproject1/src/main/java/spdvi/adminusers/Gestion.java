/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package spdvi.adminusers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
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
    }

    
     public void iniciaTablaUsers() {
         ArrayList<Usuari> users = logica.getUsuaris();
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

        setPreferredSize(new java.awt.Dimension(1200, 800));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Review Info"));

        jLabelComentario.setText("Comentario");

        jTextComentario.setColumns(20);
        jTextComentario.setLineWrap(true);
        jTextComentario.setRows(5);
        jTextComentario.setWrapStyleWord(true);
        jTextComentario.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextComentario.setEnabled(false);
        jScrollPane3.setViewportView(jTextComentario);

        jComboBoxValoracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBoxValoracion.setEnabled(false);
        jComboBoxValoracion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxValoracionItemStateChanged(evt);
            }
        });

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

        jButtonEliminaReview.setText("Eliminar intento");
        jButtonEliminaReview.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(133, 133, 133)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelComentario)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEliminaReview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificaReview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardarReview)))
                .addContainerGap())
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

        jPanelVideo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelVideo.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Ejercicio:");

        jLabelNombreEjercicio.setText("...............................");

        jLabel2.setText("Fecha: ");

        jLabelFechaEjercicio.setText("............................");

        jButtonPlay.setText("Play");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jButtonStrop.setText("Stop");
        jButtonStrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStropActionPerformed(evt);
            }
        });

        jButtonPause.setText("Pause");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanelVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNombreEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelFechaEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jButtonPlay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPause)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonStrop)))
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelFechaEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNombreEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPlay)
                    .addComponent(jButtonStrop)
                    .addComponent(jButtonPause))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonMuestraTodos.setText("Todos");
        jButtonMuestraTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMuestraTodosActionPerformed(evt);
            }
        });

        jButtonMuestraPendientes.setText("Pendientes");
        jButtonMuestraPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMuestraPendientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonMuestraTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMuestraPendientes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonMuestraPendientes)
                                    .addComponent(jButtonMuestraTodos)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    // ------------------------------------------------------------------------------------------------------------------------------------------ACTIVADOR DE VIDEO AL CLICAR EN LA TABLA
    private void jTableIntentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableIntentsMouseClicked

        int row = jTableIntents.getSelectedRow();
        if (row != -1) {
            // Esto para que, al ordenar, no se desajuste el elemento seleccionado
            int modelIndex = jTableIntents.convertRowIndexToModel(row);

            // Usar el índice del modelo para obtener el intento correcto
            TablaIntentosGeneral modelo = (TablaIntentosGeneral) jTableIntents.getModel();
            Intent intento = modelo.getIntent(modelIndex);

            playVid(intento); // Aquí el video correcto estará vinculado al intento correcto
            Review rev = logica.getReview(intento.getId());
            if (rev != null) {
                jTextComentario.setText(rev.getComentari());
                jComboBoxValoracion.setSelectedIndex(rev.getValoracio() - 1); //menos 1 para evitar outOfBounds
                jButtonEliminaReview.setEnabled(true);
                jButtonModificaReview.setEnabled(true);
            } else {
                jTextComentario.setText("");
                jComboBoxValoracion.setSelectedIndex(0);
                jButtonEliminaReview.setEnabled(false);
                jButtonModificaReview.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jTableIntentsMouseClicked

    private void playVid(Intent intento) {
            String archivo = "src\\main\\resources\\videos\\" + intento.getVideofile();
            SwingUtilities.invokeLater(() -> {
                mediaPlayer.mediaPlayer().media().play(archivo);

                jLabelNombreEjercicio.setText(logica.getNombreEjercicio(intento.getIdExercici()));
                jLabelFechaEjercicio.setText(intento.getInici().toString());
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
    
    // ------------------------------------------------------------------------------------------------------------------------------------------BOTON VISUALIZAR REVIEWS PENDIENTES
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

    private void sorterIntentos(TablaIntentosGeneral tabla) {
         //IMPLEMENTACIÓ SORTER
        sorter = new TableRowSorter<>(tabla);
        jTableIntents.setRowSorter(sorter);
        
        // ORDENACIÓ X DEFECTE
        List<SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new SortKey(2,SortOrder.DESCENDING)); // ordre desitjat;
        sorter.setSortKeys(sortKeys);
    }
        // ------------------------------------------------------------------------------------------------------------------------------------------ACTIVADOR AL CLICAR EN LA TABLA USUARIOS
    private void jTableUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsersMouseClicked
        // LOCALIZA EL USUARIO SELECCIONADO Y ALTERA LA TABLA DE INTENTOS PAR MOSTRAR SOLO LOS DE ESE USUARIO
        int numUser = jTableUsers.getSelectedRow();
        if (numUser != -1) {
            TablaUsuariosGeneral modelo = (TablaUsuariosGeneral) jTableUsers.getModel();
            Usuari usuari = modelo.getUser(numUser);
            
            ArrayList<Intent> intents = logica.getIntentsDeUsuario(usuari.getId());
            TablaIntentosGeneral tablaIntentosUsuario = new TablaIntentosGeneral(intents);
            jTableIntents.removeAll();
            jTableIntents.setModel(tablaIntentosUsuario);
            pintaTabla();
            sorterIntentos(tablaIntentosUsuario);
            jTableIntents.changeSelection(0, 0, false, false);
            playVid(intents.get(0));
        }
    }//GEN-LAST:event_jTableUsersMouseClicked

    private void jButtonGuardarReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarReviewActionPerformed
        // TODO add your handling code here:
            int intentoId = (int) jTableIntents.getValueAt(jTableIntents.getSelectedRow(), 0);

            if (logica.intentoTieneReview(intentoId)) {
                String comentario = jTextComentario.getText();
                int valoracion = (int)jComboBoxValoracion.getSelectedIndex()+1;
                logica.updateReview(valoracion, comentario,  intentoId);
            } else {
                Review review = new Review();
                review.setIdIntent(intentoId);
                review.setValoracio((int)jComboBoxValoracion.getSelectedIndex()+1);
                review.setIdReviewer(pare.getUser());
                review.setComentari(jTextComentario.getText());

                int resultado = logica.registraReview(review);
                if (resultado == 1) System.out.println("Ha ido bien");
                if (resultado == 0) System.out.println("Review no registrada");
                else System.out.println("Algo no ha ido bien...");
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

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        mediaPlayer.mediaPlayer().controls().play();
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jButtonStropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStropActionPerformed
       mediaPlayer.mediaPlayer().controls().stop();
    }//GEN-LAST:event_jButtonStropActionPerformed

    private void jButtonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPauseActionPerformed
        mediaPlayer.mediaPlayer().controls().pause();
    }//GEN-LAST:event_jButtonPauseActionPerformed

    private void activaBoton() {
        if(!jTextComentario.getText().isEmpty() && jComboBoxValoracion.getSelectedIndex() != -1) jButtonGuardarReview.setEnabled(true);
        else jButtonGuardarReview.setEnabled(false);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminaReview;
    private javax.swing.JButton jButtonGuardarReview;
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
