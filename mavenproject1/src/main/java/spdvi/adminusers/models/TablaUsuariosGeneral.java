/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import spdvi.adminusers.dto.Usuari;

/**
 *
 * @author alber
 */
public class TablaUsuariosGeneral extends AbstractTableModel{
    
    private String[] columnas = {"Nombre"};
    ArrayList<Usuari> usuarios = new ArrayList<>();
    
    public TablaUsuariosGeneral(ArrayList<Usuari> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) 
        {
            case 0 -> {
                return usuarios.get(rowIndex).getNom();
            }
        }
        return null;
    }
    
}
