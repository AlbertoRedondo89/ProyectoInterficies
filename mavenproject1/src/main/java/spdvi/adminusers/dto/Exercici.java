/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.dto;


public class Exercici {
    
    private int id;
    private String nomExercici;
    private String descripcio;

    public Exercici() {
    }

    public Exercici(int id, String nomExercici, String descripcio) {
        this.id = id;
        this.nomExercici = nomExercici;
        this.descripcio = descripcio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomExercici() {
        return nomExercici;
    }

    public void setNomExercici(String nomExercici) {
        this.nomExercici = nomExercici;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "Exercici{" + "id=" + id + ", nomExercici=" + nomExercici + ", descripcio=" + descripcio + '}';
    }
    
    
    
}
