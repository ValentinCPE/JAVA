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
import javax.sql.DataSource;
import velov.dao.IStationDAO;
import velov.modele.Station;

/**
 *
 * @author Valentin
 */
public class OracleStationDAO implements IStationDAO{
    
    private static DataSource datas;
    private static Connection connexionBD;
    
    @Override
    public void setDataSource(DataSource ds) {
        this.datas = ds;
    }

    public void setConnection(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public List<Station> getLesStations() {
         Statement stmt = null;
         ResultSet rset = null;
         List<Station> station = null;
        try {
            stmt = connexionBD.createStatement ();
            station = new ArrayList<>();
            rset = stmt.executeQuery ("SELECT * FROM STATION");
            //public Station(String num,String nom,String loc,Integer numarrond)
            while(rset.next()){
                station.add(new Station(rset.getString("NUMSTAT"),rset.getString("NOMSTAT"),rset.getString("LOCSTAT"),rset.getInt("NUMARD")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
            try{
            stmt.close();
            rset.close();
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
        }
        return station;
      }

    @Override
    public void creerStation(Station s) {
        PreparedStatement pstm = null;
        try{
            pstm = connexionBD.prepareStatement("INSERT INTO STATION VALUES (?,?,?,?)");
            pstm.setString(1,s.getNumeroIdentification() );
            pstm.setString(2,s.getNomStation() );
            pstm.setInt(3,s.getNumeroArrondissementVille() );
            pstm.setString(4,s.getlocalisationStation() );
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    public void supprimerStation(String numStation) {
        PreparedStatement pstm = null;
       try{
            pstm = connexionBD.prepareStatement("DELETE FROM STATION WHERE NUMSTAT=?");
            pstm.setString(1,numStation );
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
       } 
    }
    
    public void modifStation(String numStation,String nomStation,Integer numArron,String loc,String numStationASuppr){
        PreparedStatement pstm = null;
        try{
            pstm = connexionBD.prepareStatement("UPDATE STATION SET NUMSTAT=?,NOMSTAT=?,NUMARD=?,LOCSTAT=? WHERE NUMSTAT=?");
            pstm.setString(1,numStation );
            pstm.setString(2,nomStation );
            pstm.setInt(3,numArron );
            pstm.setString(4,loc );
            pstm.setString(5,numStationASuppr );
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
            try{
                pstm.close();
            }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
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
    
    public boolean tableStationExiste(){
        boolean existe = false;
        Statement stmt = null;
        ResultSet rset = null;
        try {
            stmt = connexionBD.createStatement ();
            rset = stmt.executeQuery ("SELECT * FROM STATION");
            if(rset.next()){
                 existe = true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
            try {
                stmt.close();
                rset.close();
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        }
        return existe;
      }
    
    public void creerTableStation(){
        Statement stmt = null;
        try {
            stmt = connexionBD.createStatement ();
            String sql = "CREATE TABLE ARRONDISSEMENT " + 
                    "(NumARD NUMBER(4), " + 
                    "NOMARD VARCHAR2(50) NOT NULL, " +
                    "constraint arrondissement_num_pk PRIMARY KEY(numARD))";
            stmt.executeUpdate (sql);
              sql = "CREATE TABLE STATION " + 
                    "(NumSTAT VARCHAR2(10), " + 
                    "NOMSTAT VARCHAR2(50) NOT NULL, " +
                    "numARD NUMBER(4) NOT NULL, " +  
                    "LOCSTAT VARCHAR2(100) NOT NULL, " +
                    "constraint station_num_pk PRIMARY KEY(NumSTAT), " +
                    "constraint station_numARD_fk FOREIGN KEY (NumARD) REFERENCES ARRONDISSEMENT(NumARD))";  
            stmt.executeUpdate (sql); 
            stmt.executeQuery ("INSERT INTO ARRONDISSEMENT VALUES (1,'Lyon 1er arrondissement')");
            stmt.executeQuery ("INSERT INTO ARRONDISSEMENT VALUES (2,'Lyon 2eme arrondissement')");
            stmt.executeQuery ("INSERT INTO ARRONDISSEMENT VALUES (3,'Lyon 3eme arrondissement')");
            stmt.executeQuery ("INSERT INTO ARRONDISSEMENT VALUES (4,'Lyon 4eme arrondissement')");
            stmt.executeQuery ("INSERT INTO ARRONDISSEMENT VALUES (5,'Lyon 5eme arrondissement')");
            stmt.executeQuery ("INSERT INTO ARRONDISSEMENT VALUES (6, 'Lyon 6eme arrondissement')");
            stmt.executeQuery ("INSERT INTO ARRONDISSEMENT VALUES (7, 'Lyon 7eme arrondissement')");
            stmt.executeQuery ("INSERT INTO ARRONDISSEMENT VALUES (8, 'Lyon 8eme arrondissement')");
            stmt.executeQuery ("INSERT INTO ARRONDISSEMENT VALUES (9, 'Lyon 9eme arrondissement')");
            stmt.executeQuery ("INSERT INTO STATION VALUES (1001, 'Terreaux/Terme', 1,'angle rue d''Algérie')");
            stmt.executeQuery ("INSERT INTO STATION VALUES (1002,'Opéra',1,'angle rue Serlin-angle place de la comédie')");
            stmt.executeQuery ("INSERT INTO STATION VALUES (1003,'Place Sathonay',1,'angle Nord-Ouest de la place')");
            stmt.executeQuery ("INSERT INTO STATION VALUES (1005,'Meissonnier',1,'place Meissonnier - angle sud-est de la place')");
            stmt.executeQuery ("INSERT INTO STATION VALUES (1006,'Subsistances',1,'En face du n° 14 quai Saint Vincent')");
            stmt.executeQuery ("INSERT INTO STATION VALUES (2001,'Bellecour/République',2,'angle rue République - rue de la Barre')");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    public void supprTable(){
        Statement stmt = null;
        try {
            stmt = connexionBD.createStatement();
            stmt.executeQuery("DROP TABLE STATION");
            stmt.executeQuery("DROP TABLE ARRONDISSEMENT");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
               try{
                   stmt.close();
                }catch(SQLException ex){
                    System.err.println(ex.getMessage());
                }
          }
    }

    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void quitter(){
        try {
            this.connexionBD.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
