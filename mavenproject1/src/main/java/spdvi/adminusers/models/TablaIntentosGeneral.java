/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import spdvi.adminusers.dto.Intents;
import spdvi.adminusers.logica.Logica;

/**
 *
 * @author alber
 */
public class TablaIntentosGeneral extends AbstractTableModel{

    String[] columnas = {"Id_Intento", "IdUsuari"};
    ArrayList<Intents> intentos = new ArrayList<>();
    
    public TablaIntentosGeneral(ArrayList<Intents> intentos) {
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
        
        }
        return null;
    }
   
}
