/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.logica;

import java.util.ArrayList;
import spdvi.adminusers.dataaccess.DataAccess;
import spdvi.adminusers.dto.Exercici;
import spdvi.adminusers.dto.Intents;
import spdvi.adminusers.dto.Review;
import spdvi.adminusers.dto.Usuari;

public class Logica {

    private DataAccess da = new DataAccess();
    private ArrayList<Usuari> usuaris = new ArrayList<>();
    private ArrayList<Exercici> exercicis = new ArrayList<>();
    private ArrayList<Intents> intents = new ArrayList<>();
    private ArrayList<Review> reviews = new ArrayList<>();

    public Logica() {
        usuaris = da.getUsuaris();
        exercicis = da.getExercicis();
        intents = da.getIntents2();
        reviews = da.getReviews();
    }

    public ArrayList<Usuari> getUsuaris() {
        return usuaris;
    }

    public void setUsuaris(ArrayList<Usuari> usuaris) {
        this.usuaris = usuaris;
    }

    public ArrayList<Exercici> getExercicis() {
        return exercicis;
    }

    public void setExercicis(ArrayList<Exercici> exercicis) {
        this.exercicis = exercicis;
    }

    public ArrayList<Intents> getIntents() {
        return intents;
    }

    public void setIntents(ArrayList<Intents> intents) {
        this.intents = intents;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

}
