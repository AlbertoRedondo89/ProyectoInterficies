/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.adminusers.models;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColoresTabla extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Llama al renderizador de celda predeterminado para la configuración base
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Obtiene el valor de la columna "Estado" en la fila actual (suponiendo que es la columna 3)
        Object estadoValue = table.getValueAt(row, 3);
        Color am, roj, ver;

        // Cambia el color de fondo según el valor de "Estado"
        if ("Pendiente".equals(estadoValue)) {
            cell.setBackground(am = new Color(225, 220, 103));
        } else if ("Aprobado".equals(estadoValue)) {
            cell.setBackground(ver = new Color(126, 234, 156));
        } else if ("Suspenso".equals(estadoValue)) {
            cell.setBackground(roj = new Color(234, 116, 164));
        } else {
            cell.setBackground(Color.WHITE); // Fondo blanco por defecto
        }

        // Cambia el color del texto cuando está seleccionada la fila
        if (isSelected) {
            cell.setForeground(Color.WHITE);
        } else {
            cell.setForeground(Color.BLACK);
        }

        return cell;
    }
}
