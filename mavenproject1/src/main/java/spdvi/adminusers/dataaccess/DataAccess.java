package spdvi.adminusers.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import spdvi.adminusers.dto.Exercici;
import spdvi.adminusers.dto.Intent;
import spdvi.adminusers.dto.Review;
import spdvi.adminusers.dto.Usuari;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Statement;
import java.util.Properties;

public class DataAccess {

    private static int activo;

    private Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("properties/application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return null;
            }

            // Cargar el archivo de propiedades
            properties.load(input);

            // Extraer los valores
            String url = properties.getProperty("database.url");
            String user = properties.getProperty("database.user");
            String password = properties.getProperty("database.password");

            // Establecer conexión
            connection = DriverManager.getConnection(url + "user=" + user + ";password=" + password + ";");

        } catch (IOException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, "Error al leer application.properties", ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, "Error al conectar con la base de datos", ex);
        }

        return connection;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------- USUARIS ---------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public ArrayList<Usuari> getUsuaris() {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * from Usuaris";

        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                // user.setFoto(resultSet.getBytes("Foto"));
                user.setIsInstructor(resultSet.getBoolean("IsInstructor"));

                usuaris.add(user);
            }
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("mal");
        }

        return usuaris;
    }

    public ArrayList<Intent> getIntents() {
        ArrayList<Intent> intents = new ArrayList<>();
        String sql = "SELECT * from Intents where Id NOT IN (SELECT IdIntent from Review)";

        Connection connection = getConnection();

        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet set = selectStatement.executeQuery();
            while (set.next()) {

                Intent intent = new Intent();
                intent.setId(set.getInt("Id"));
                intent.setIdUsuari(set.getInt("IdUsuari"));
                intent.setIdExercici(set.getInt("IdExercici"));
                // Estos valores los guardo previamente en una variable para convertirlos después a un tipo compatible
                Timestamp inici = set.getTimestamp("Timestamp_Inici");
                Timestamp fi = set.getTimestamp("Timestamp_Fi");
                String vid = set.getString("Videofile");
                if (inici != null) {
                    intent.setInici(inici.toLocalDateTime());
                }
                if (fi != null) {
                    intent.setFi(fi.toLocalDateTime());
                }
                intent.setVideofile(vid.toString());

                intents.add(intent);
            }
            selectStatement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println("mal");
        }

        return intents;
    }
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------- INTENTS --------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<Intent> getIntents2() {
        ArrayList<Intent> intents = new ArrayList<>();
        String sql = "SELECT * from Intents";

        Connection connection = getConnection();

        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet set = selectStatement.executeQuery();
            while (set.next()) {

                Intent intent = new Intent();
                intent.setId(set.getInt("Id"));
                intent.setIdUsuari(set.getInt("IdUsuari"));
                intent.setIdExercici(set.getInt("IdExercici"));
                // Estos valores los guardo previamente en una variable para convertirlos después a un tipo compatible
                Timestamp inici = set.getTimestamp("Timestamp_Inici");
                Timestamp fi = set.getTimestamp("Timestamp_Fi");
                String vid = set.getString("Videofile");
                if (inici != null) {
                    intent.setInici(inici.toLocalDateTime());
                }
                if (fi != null) {
                    intent.setFi(fi.toLocalDateTime());
                }
                intent.setVideofile(vid.toString());

                intents.add(intent);
            }
            selectStatement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println("mal");
        }
        return intents;
    }

    public int deleteIntent(int idIntent) {
        Connection connection = getConnection();
        int confirmacion = 0;
        String sql = "DELETE from Intents where Id = " + idIntent;
        try (Statement st = connection.createStatement()) {

            confirmacion = st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return confirmacion;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------- REVIEWS -------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public ArrayList<Review> getReviews() {
        ArrayList<Review> reviews = new ArrayList<>();
        String sql = "SELECT * from Review";
        Connection connection = getConnection();

        try (PreparedStatement selectStatement = connection.prepareStatement(sql); ResultSet set = selectStatement.executeQuery()) {
            while (set.next()) {
                Review rev = new Review();
                rev.setId(set.getInt("Id"));
                rev.setIdIntent(set.getInt("IdIntent"));
                rev.setIdReviewer(set.getInt("IdReviewer"));
                rev.setValoracio(set.getInt("Valoracio"));
                rev.setComentari(set.getString("Comentari"));

                reviews.add(rev);
            }
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reviews;
    }

    // ----------------------------------------------------------------------------------------------------------------ACCESO DE USUARIO
    public boolean accesoUsuario(String nom, char[] pssw) {
        System.out.println("Buscando usuario: " + nom);

        boolean autorizado = false;
        ArrayList<Usuari> usuaris = getUsuaris();

        for (Usuari user : usuaris) {
            if (user.getNom().equals(nom)) {
                System.out.println("Usuario encontrdo...");

                BCrypt.Result result = BCrypt.verifyer().verify(pssw, user.getPasswordHash());

                if (result.verified) {
                    System.out.println("Contraseña verificada para el usuario: " + nom);
                    activo = user.getId();
                    System.out.println("Conexión estblecida con usuario n: " + activo);
                    autorizado = true;
                    if (user.isIsInstructor()) {
                        autorizado = true;
                    }
                } else {
                    System.out.println("Contraseña incorrecta para el usuario: " + nom);
                }
            }
        }

        return autorizado;
    }

    // ----------------------------------------------------------------------------------------------------------------GESTION DE  REVIEW
    // ----------------------------------------------------------------------------------------------------------------INSERTAR NUEVA  REVIEW
    public int registraReview(Review rev) {
        int revsOk = 0;

        Connection connection = getConnection();
        String sql = "INSERT INTO Review(IdIntent, IdReviewer, Valoracio,  Comentari)"
                + "VALUES(?,?,?,?);";
        try {
            PreparedStatement insertStatement = connection.prepareStatement(sql);
            insertStatement.setInt(1, rev.getIdIntent());
            insertStatement.setInt(2, activo);
            insertStatement.setInt(3, rev.getValoracio());
            insertStatement.setString(4, rev.getComentari());
            revsOk = insertStatement.executeUpdate();

            insertStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return revsOk;
    }

    // ----------------------------------------------------------------------------------------------------------------ACTUALIZAR UNA  REVIEW
    public int updateReview(int valoracion, String comentario, int intento) {
        int total = 0;
        System.out.println(valoracion + ", " + comentario + ", " + activo + ", " + intento);
        Connection connection = getConnection();
        String sql = "UPDATE Review "
                + "SET IdReviewer = ?, Valoracio = ?, Comentari = ? "
                + "WHERE IdIntent = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, activo);
            pst.setInt(2, valoracion);
            pst.setString(3, comentario);
            pst.setInt(4, intento);
            total = pst.executeUpdate();
            System.out.println("Elementos afectados: " + total);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        };
        return total;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------- EXERCICI ----------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public ArrayList<Exercici> getExercicis() {
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT * from Exercicis";
        Connection connection = getConnection();

        try (PreparedStatement selectStatement = connection.prepareStatement(sql); ResultSet set = selectStatement.executeQuery()) {
            while (set.next()) {
                Exercici ex = new Exercici();
                ex.setId(set.getInt("Id"));
                ex.setNomExercici(set.getString("NomExercici"));
                ex.setDescripcio(set.getString("Descripcio"));

                exercicis.add(ex);
            }
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exercicis;
    }

    // EXTRAS
    public int registerUser(Usuari user) {

        int newUserId = 0;
        Connection connection = getConnection();

        String sql = "INSERT into Usuaris(Nom, Email, PasswordHash, IsInstructor) "
                + " VALUES (?,?,?,?);"
                + " SELECT CAST(SCOPE_IDENTITY() AS INT)";

        try {
            PreparedStatement insertStatement = connection.prepareStatement(sql);
            insertStatement.setString(1, user.getNom());
            insertStatement.setString(2, user.getEmail());
            insertStatement.setString(3, user.getPasswordHash());
            insertStatement.setBoolean(4, user.isIsInstructor());
            newUserId = insertStatement.executeUpdate();

            insertStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newUserId;
    }

    public int getLastInsertId() {
        String sql = "SELECT MAX(Id) from Usuaris";
        int userId = 0;

        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                userId = resultSet.getInt(1);
            }
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("mal");
        }

        return userId;
    }
}

/*
 private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Usuari usuari = da.getUsuari(jTextFieldLoginEmail.getText());
        
        if (usuari != null) {
            //Check password
            char[] passwordToVerify = jPasswordLogin.getPassword();
            String userPasswordHash = usuari.getPasswordHash();
            var result = BCrypt.verifyer().verify(passwordToVerify, userPasswordHash);
            if (result.verified) {
                lblInfoMessage.setText("Bienvenido" + usuari.getNom());
                if (usuari.isIsInstructor()) {jButtonDelete.setEnabled(true);
                    
                }
            } else {
                lblInfoMessage.setText("Contraseña equivocada");
            }
        }else {
                lblInfoMessage.setText("El usuario no existe");
            }
        
    }   



    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Usuari user = new Usuari();
        user.setNom(txtNom.getText());
        user.setEmail(txtEmail.getText());
        String psswordHash = Bcrypt.withDefaults().hashToString(12, txtPassword.getPassword());
        user.setPasswordHash(psswordHash);
        user.setIsInstructor(chkInstructor.isSelected());
        
        //DataAccess da = new DataAccess();
        int nouId = da.registerUser(user);
        user.setId(nouId);
        lbMessage.setText("User registered mu bien con ID: " + nouId);
    }    
 */
