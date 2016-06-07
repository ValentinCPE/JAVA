/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.modele;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import velov.modele.Station;

/**
 *
 * @author Valentin
 */
public class ModeleTableList extends AbstractTableModel{
    private String[] columnNames = {"Numéro station","Nom station","Numéro arrondissement", "Localisation"};
    private List<Station> conttable = new ArrayList<>();
    
    public ModeleTableList(List<Station> donne){
        super();
        this.conttable = donne;
    }
    
    @Override
    public int getRowCount() {
        return conttable.size(); 
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; 
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Station recherche = conttable.get(rowIndex);
        switch(columnIndex){
            case 0:
                return recherche.getNumeroIdentification();
            case 1:
                return recherche.getNomStation();
            case 2:
                return recherche.getNumeroArrondissementVille();
            case 3:
                return recherche.getlocalisationStation();
                }
             return 0;
        }
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        Station recherche = conttable.get(row);
        switch(col){
            case 0:
                recherche.setNumStation(String.valueOf(value));
            case 1:
                recherche.setNomStation(String.valueOf(value));
            case 2:
                recherche.setNumArrondissement((Integer) value);
            case 3:
                recherche.setLocalisation(String.valueOf(value));
                }
        fireTableCellUpdated(row, col);
        }
    
    public void ajoutListe(String numsta,String nomsta,String localisation,Integer numarrond){
        Station sta1 = new Station(numsta,nomsta,localisation,numarrond);
        conttable.add(sta1);
        fireTableStructureChanged();
        
    }
    
    public void supprimerListe(String numsta){
        int i = 0;
        while(!conttable.get(i).getNumeroIdentification().contains(numsta)){
            i = i + 1;
        }
        conttable.remove(i);
        fireTableStructureChanged();
    }
    
    public Station rechercheStation(String numSta){
        for(int i = 0; i<conttable.size();i++){
            if(conttable.get(i).getNumeroIdentification().contains(numSta)){
                return conttable.get(i);
            }
        }
        return null;
    }
}
