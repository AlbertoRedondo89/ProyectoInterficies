/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import spdvi.adminusers.dto.Intent;
import spdvi.adminusers.logica.Logica;

/**
 *
 * @author alber
 */
public class TablaIntentosGeneral extends AbstractTableModel{

    String[] columnas = {"Id_Intento", "IdUsuari", "Inicio", "Estado"};
    ArrayList<Intent> intentos = new ArrayList<>();
    
    public TablaIntentosGeneral(ArrayList<Intent> intentos) {
        this.intentos = intentos;
    }
    
    @Override
    public int getRowCount() {
       return intentos.size();
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0 -> {
                return intentos.get(rowIndex).getId();
            }
            case 1 -> {
                return intentos.get(rowIndex).getIdUsuari();
            }
            case 2 -> {
                return intentos.get(rowIndex).getInici();
            }   
            case 3 -> {
                return intentos.get(rowIndex).getEstado();
            }
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    public Intent getIntent(int rowIndex) {
        return intentos.get(rowIndex);
    }
   
}
