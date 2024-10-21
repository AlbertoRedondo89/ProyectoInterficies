/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.dto;

import java.time.LocalDateTime;



public class Intents {
    private int id;
    private int idUsuari;
    private int idExercici;
    private LocalDateTime inici;
    private LocalDateTime fi;
    private char[] videofile;

    public Intents() {
    }

    public Intents(int id, int idUsuari, int idExercici, LocalDateTime inici, LocalDateTime fi, char[] videofile) {
        this.id = id;
        this.idUsuari = idUsuari;
        this.idExercici = idExercici;
        this.inici = inici;
        this.fi = fi;
        this.videofile = videofile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }
    
    public int getIdExercici() {
        return idExercici;
    }

    public void setIdExercici(int idExercici) {
        this.idExercici = idExercici;
    }

    public LocalDateTime getInici() {
        return inici;
    }

    public void setInici(LocalDateTime inici) {
        this.inici = inici;
    }

    public LocalDateTime getFi() {
        return fi;
    }

    public void setFi(LocalDateTime fi) {
        this.fi = fi;
    }

    public char[] getVideofile() {
        return videofile;
    }

    public void setVideofile(char[] videofile) {
        this.videofile = videofile;
    }

    @Override
    public String toString() {
        return "Intents{" + "id=" + id + ", idUsuari=" + idUsuari + ", idExercici=" + idExercici + ", inici=" + inici + ", fi=" + fi + ", videofile=" + videofile + '}';
    }
    
    

}
