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

    private final DataAccess da = new DataAccess();
    private ArrayList<Usuari> usuaris = new ArrayList<>();
    private ArrayList<Exercici> exercicis = new ArrayList<>();
    private ArrayList<Intent> intents = new ArrayList<>();
    private ArrayList<Review> reviews = new ArrayList<>();

    public Logica() {
        actualizaDatos();
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

    public void setIntents(ArrayList<Intent> intents, ArrayList<Review> reviews) {
        for (Review rev : reviews) {
            for (Intent intento : intents) {
                if (intento.getId() == rev.getIdIntent()) {
                    if (rev.getValoracio() > 2) {
                        intento.setEstado(Intent.ESTADOS[1]);
                    } else {
                        intento.setEstado(Intent.ESTADOS[2]);
                    }
                }
            }
        }
        this.intents = intents;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void actualizaDatos() {
        setUsuaris(da.getUsuaris());
        setExercicis(da.getExercicis());
        setReviews(da.getReviews());
        setIntents(da.getIntents2(), reviews);
    }

    //METODO PARA GENERAR LOS INTENTOS SIN REVIEW PARA EL MENU INICIAL
    public ArrayList<Intent> getIntentsSinReview() {
        ArrayList<Intent> intentosSinReview = new ArrayList<>();
        boolean check = true;

        for (Intent inten : intents) {
            for (Review revi : reviews) {
                if (inten.getId() == revi.getIdIntent()) {
                    check = false;
                }
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

        for (Intent inten : intents) {
            if (inten.getIdUsuari() == id) {
                intentosUsuario.add(inten);
            }
        }
        return intentosUsuario;
    }

    public String getNombreEjercicio(int intento) {
        for (Exercici ex : exercicis) {
            if (ex.getId() == intento) {
                return ex.getNomExercici();
            }
        }
        return null;
    }

    public Review getReview(int id) {
        Review rev = null;
        for (Review review : reviews) {
            if (review.getIdIntent() == id) {
                return review;
            }
        }
        return rev;
    }

    public int registraReview(Review rev) {
        int ok = 0;
        ok = da.registraReview(rev);
        return ok;
    }

    // -------------------------------------------------------------- CHECK PARA SABER SI CREAR O MODIFICAR LA REVIEW
    public boolean intentoTieneReview(int intentoId) {
        boolean crear = false;
        for (Review rev : reviews) {
            if (rev.getIdIntent() == intentoId) {
                crear = true;  // Si la review existe, no se creara
            }
        }
        return crear;
    }

    public int updateReview(int valoracion, String comentario, int intento) {
        int total = 0;
        total = da.updateReview(valoracion, comentario, intento);
        return total;
    }

    public int dropIntent(int idIntent) {
        int confirmacion = 0;
        confirmacion = da.deleteIntent(idIntent);
        return confirmacion;
    }
}
