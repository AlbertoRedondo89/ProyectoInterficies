
package spdvi.adminusers.dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import static java.time.LocalDateTime.now;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import spdvi.adminusers.dto.Exercici;
import spdvi.adminusers.dto.Intent;
import spdvi.adminusers.dto.Review;
import spdvi.adminusers.dto.Usuari;



public class DataAccess {
    
    
    private Connection getConnection(){
        Connection connection = null;
        
        /*String connectionString = "jdbc:sqlserver://localhost;database=simuladbdb202315101357;"
                + "user=sa;password=1234;";*/
        String connectionString = "jdbc:sqlserver://localhost;database=simulapdb202315101357;encrypt=true;trustServerCertificate=true;" 
                + "user=ElBromas;password=1234;";
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
        }
        catch (SQLException ex){
            System.out.println("mal");
        }
        
        return usuaris;
    }
    
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
        }
        catch (SQLException ex){
            System.out.println("mal");
        }
        
        return userId;
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
                        if(inici != null) intent.setInici(inici.toLocalDateTime());
                        if(fi != null) intent.setFi(fi.toLocalDateTime());
                        intent.setVideofile(vid.toString());   
                        
                        intents.add(intent);
            }
            selectStatement.close();
            connection.close();
            
        }catch (SQLException ex){
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
                        if(inici != null) intent.setInici(inici.toLocalDateTime());
                        if(fi != null) intent.setFi(fi.toLocalDateTime());
                        intent.setVideofile(vid.toString());   
                        
                        intents.add(intent);
            }
            selectStatement.close();
            connection.close();
            
        }catch (SQLException ex){
            System.out.println("mal");
        }   
        return intents;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------- REVIEWS -------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    public ArrayList<Review> getReviews(){
        ArrayList<Review> reviews = new ArrayList<>();
        String sql = "SELECT * from Review";
        Connection connection = getConnection();
        
        try (PreparedStatement selectStatement = connection.prepareStatement(sql);
                ResultSet set = selectStatement.executeQuery()) {
            while(set.next()) {
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
    
    public boolean accesoUsuario(int id, String pssw) {
        boolean autorizado = false;
        ArrayList<Usuari> usuaris = getUsuaris();
        for (Usuari user : usuaris) {
            if (user.getId() == id) {
                if(user.getPasswordHash().equals(pssw)){
                    if(user.isIsInstructor()) autorizado = true;
                }
            }
        }
        
        return autorizado;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------- EXERCICI ----------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public ArrayList<Exercici> getExercicis(){
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT * from Exercicis";
        Connection connection = getConnection();
        
        try (PreparedStatement selectStatement = connection.prepareStatement(sql);
                ResultSet set = selectStatement.executeQuery()) {
            while(set.next()) {
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
}
