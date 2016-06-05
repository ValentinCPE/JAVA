/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.modele;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Valentin
 */
public class ModeleTableList extends AbstractTableModel{
    private String[] columnNames = {"Numéro station","Nom station","Numéro arrondissement", "Localisation"};
    Object donnees[][];
    
    public ModeleTableList(Object donne[][]){
        super();
        this.donnees = donne;
    }
    
    @Override
    public int getRowCount() {
        return donnees.length; 
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return donnees[rowIndex][columnIndex];  
}
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col < 2) {
        return false;
        } else {
        return true;
       }
}
    @Override
    public void setValueAt(Object value, int row, int col) {
        donnees[row][col] = value;
        fireTableCellUpdated(row, col);
        }
    
}
