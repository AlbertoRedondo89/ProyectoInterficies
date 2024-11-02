/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.logica;

import java.util.ArrayList;
import spdvi.adminusers.dataaccess.DataAccess;
import spdvi.adminusers.dto.Exercici;
import spdvi.adminusers.dto.Intent;
import spdvi.adminusers.dto.Review;
import spdvi.adminusers.dto.Usuari;

public class Logica {

    private DataAccess da = new DataAccess();
    private ArrayList<Usuari> usuaris = new ArrayList<>();
    private ArrayList<Exercici> exercicis = new ArrayList<>();
    private ArrayList<Intent> intents = new ArrayList<>();
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

    public ArrayList<Intent> getIntents() {
        return intents;
    }

    public void setIntents(ArrayList<Intent> intents) {
        this.intents = intents;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
    
    //METODO PARA GENERAR LOS INTENTOS SIN REVIEW PARA EL MENU INICIAL
    public ArrayList<Intent> getIntentsSinReview() {
        ArrayList<Intent> intentosSinReview = new ArrayList<>();
        boolean check = true;
        
        for(Intent inten : intents) {
            for(Review revi : reviews) {
                if (inten.getId() == revi.getIdIntent())check = false;
            }
            if (check) {
                intentosSinReview.add(inten);
            }
            check = true;
        }
        return intentosSinReview;
    }
    
    //METODO PARA GENERAR LOS INTENTOS DE UN USUARIO CONCRETO
    public ArrayList<Intent> getIntentsDeUsuario(int id) {
        ArrayList<Intent> intentosUsuario = new ArrayList<>();
        
        for(Intent inten : intents) {
                if (inten.getIdUsuari() == id )intentosUsuario.add(inten);
        }
        
        return intentosUsuario;
    } 
    
    public String getNombreEjercicio(int intento) {
        for(Exercici ex : exercicis) {
            if (ex.getId() == intento) return ex.getNomExercici();
        }
        return null;
    }

}
