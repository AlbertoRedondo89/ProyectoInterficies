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
        exercici = da.getExercicis();
        intents = da.getIntents2();
        reviews = da.getReviews();
    }
    
}
