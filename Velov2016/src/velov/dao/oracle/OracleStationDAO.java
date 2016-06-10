/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velov.dao.oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import velov.dao.IStationDAO;
import velov.modele.Station;

/**
 *
 * @author Valentin
 */
public class OracleStationDAO implements IStationDAO{
    
    private DataSource datas;
    private Connection connexionBD;
    private List<Station> station = new ArrayList<>();
    
    @Override
    public void setDataSource(DataSource ds) {
        this.datas = ds;
    }

    @Override
    public Connection getConnection() {
        return connexionBD;
    }

    @Override
    public List<Station> getLesStations() {
         Statement stmt;
        try {
            stmt = connexionBD.createStatement ();
            ResultSet rset = stmt.executeQuery ("SELECT * FROM STATION");
            //public Station(String num,String nom,String loc,Integer numarrond)
            while(rset.next()){
                station.add(new Station(rset.getString("NUMSTAT"),rset.getString("NOMSTAT"),rset.getString("LOCSTAT"),rset.getInt("NUMARD")));
            }
            stmt.close();
            rset.close();
            return station;
            
        } catch (SQLException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
      }

    @Override
    public void creerStation(Station s) {
        Statement stmt;
        try{
            stmt = connexionBD.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO STATION VALUES (" + s.getNumeroIdentification() + ", "+s.getNomStation()+", "+s.getNumeroArrondissementVille().toString()+", "+s.getlocalisationStation()+");");
            stmt.close();
            rset.close();
        } catch (SQLException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerStation(String numStation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
