/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.dto;


public class Review {
    
    private int id;
    private int idIntent;
    private int idReview;
    private int valoracio;
    private String comentari;

    public Review() {
    }

    public Review(int id, int idIntent, int idReview, int valoracio, String comentari) {
        this.id = id;
        this.idIntent = idIntent;
        this.idReview = idReview;
        this.valoracio = valoracio;
        this.comentari = comentari;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdIntent() {
        return idIntent;
    }

    public void setIdIntent(int idIntent) {
        this.idIntent = idIntent;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getValoracio() {
        return valoracio;
    }

    public void setValoracio(int valoracio) {
        this.valoracio = valoracio;
    }

    public String getComentari() {
        return comentari;
    }

    public void setComentari(String comentari) {
        this.comentari = comentari;
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", idIntent=" + idIntent + ", idReview=" + idReview + ", valoracio=" + valoracio + ", comentari=" + comentari + '}';
    }
    
    
   
}
