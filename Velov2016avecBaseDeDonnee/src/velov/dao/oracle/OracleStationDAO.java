/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velov.dao.oracle;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
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
    
    public OracleStationDAO(String nomFichierProp){
    Properties props = new Properties();
    URL urlFichierProp = OracleStationDAO.class.getResource(nomFichierProp);
    BufferedInputStream bis = null;
    try {
      bis = new BufferedInputStream(urlFichierProp.openStream());
      props.load(bis);
      String driver = props.getProperty("app.jdbc.driverClassName");
      String url = props.getProperty("app.jdbc.url");
      String utilisateur = props.getProperty("app.jdbc.username");
      String mdp = props.getProperty("app.jdbc.password");
      Class.forName(driver).newInstance();
      connexionBD = DriverManager.getConnection(url, utilisateur, mdp);
    }
        catch (IOException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    finally {
      if (bis != null) {
          try {
              bis.close();
          } catch (IOException ex) {
              Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }
  }

    
    public OracleStationDAO(String username,String codeBIP){
        try {
            Class.forName ("oracle.jdbc.OracleDriver");
            this.connexionBD = DriverManager.getConnection ("jdbc:oracle:thin:@iutdoua-oracle.univ-lyon1.fr:1521:orcl", username, codeBIP);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.err.println("Erreur de connexion");
        }
    }
    
    
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
         List<Station> station = new ArrayList<>();
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
        try{
            PreparedStatement pstm = connexionBD.prepareStatement("INSERT INTO STATION VALUES (?,?,?,?)");
            pstm.setString(1,s.getNumeroIdentification() );
            pstm.setString(2,s.getNomStation() );
            pstm.setInt(3,s.getNumeroArrondissementVille() );
            pstm.setString(4,s.getlocalisationStation() );
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerStation(String numStation) {
       try{
            PreparedStatement pstm = connexionBD.prepareStatement("DELETE FROM STATION WHERE NUMSTAT=?");
            pstm.setString(1,numStation );
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void modifStation(String numStation,String nomStation,Integer numArron,String loc,String numStationASuppr){
        try{
            PreparedStatement pstm = connexionBD.prepareStatement("UPDATE STATION SET NUMSTAT=?,NOMSTAT=?,NUMARD=?,LOCSTAT=? WHERE NUMSTAT=?");
            pstm.setString(1,numStation );
            pstm.setString(2,nomStation );
            pstm.setInt(3,numArron );
            pstm.setString(4,loc );
            pstm.setString(5,numStationASuppr );
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OracleStationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public boolean testerConnexion(){
        boolean test = false;
        try {
            if(connexionBD.isValid(6)){
                test = true;
            }
                } catch (SQLException ex) {
            System.err.println("Erreur de connexion");
        }catch(java.lang.NullPointerException e){
            System.err.println("Erreur de connexion");
        }
         return test;
    }
    
}
