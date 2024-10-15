/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.dto;

public class Usuari {
    
    private int id;
    private String nom;
    private String email;
    private String passwordHash;
    private byte[] foto;
    private boolean isInstructor;

    
    
    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String PasswordHash) {
        this.passwordHash = PasswordHash;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] Foto) {
        this.foto = Foto;
    }

    public boolean isIsInstructor() {
        return isInstructor;
    }

    public void setIsInstructor(boolean IsInstructor) {
        this.isInstructor = IsInstructor;
    }
    
    
    
}
