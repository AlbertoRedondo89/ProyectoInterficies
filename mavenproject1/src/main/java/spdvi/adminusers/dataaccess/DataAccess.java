
package spdvi.adminusers.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //____________________________
    //MIRAR CRUD__________________
    //____________________________
    
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
    
}